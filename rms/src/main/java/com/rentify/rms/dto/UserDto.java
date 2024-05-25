package com.rentify.rms.dto;

import lombok.Data;

@Data
public class UserDto extends Login {
    private String firstName;
    private String lastName;
    private String phone;
}
