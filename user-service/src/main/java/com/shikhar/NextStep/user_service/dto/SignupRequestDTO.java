package com.shikhar.NextStep.user_service.dto;

import lombok.Data;

@Data
public class SignupRequestDTO {
    private String email;
    private String password;
    private String name;
}
