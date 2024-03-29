package com.fatianov.SmartShop.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String name;

    private String surname;

    private Date birthday;

    private String phone;

    private String email;

    private String password;
}
