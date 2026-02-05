# -------- BUILD STAGE --------
FROM eclipse-temurin:17-jdk-focal AS builder

WORKDIR /app

# Copy Maven wrapper & config
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (cache layer)
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src src

# Build jar
RUN ./mvnw clean package -DskipTests


# -------- RUN STAGE --------
FROM eclipse-temurin:17-jre-focal

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
