package com.rentify.rms.controller;

import com.rentify.rms.dto.UserDto;
import com.rentify.rms.exception.InternalServerErrorException;
import com.rentify.rms.exception.UserRegistrationException;
import com.rentify.rms.service.interfaces.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestBody UserDto userDto) throws UserRegistrationException, InternalServerErrorException {
        this.userService.register(userDto);
        return ResponseEntity.ok("Success");
    }

}
