package com.h2k.Expense.Tracker.dto;

import com.h2k.Expense.Tracker.entity.type.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategorySummaryDTO implements Serializable {
    private CategoryType category;
    private BigDecimal totalAmount;
}
