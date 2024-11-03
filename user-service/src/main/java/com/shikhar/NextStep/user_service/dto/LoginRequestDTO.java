package com.shikhar.NextStep.user_service.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String password;
    private String name;
    private String email;

}
