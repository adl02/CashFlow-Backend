package com.h2k.Expense.Tracker.service;

import com.h2k.Expense.Tracker.dto.SignupResponseDto;
import com.h2k.Expense.Tracker.entity.User;
import com.h2k.Expense.Tracker.security.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ModelMapper modelMapper;
    private final AuthUtil authUtil;

    public SignupResponseDto getCurrentUser() {
        User currentUser = authUtil.getCurrentUser();
        return modelMapper.map(currentUser, SignupResponseDto.class);
    }
}
