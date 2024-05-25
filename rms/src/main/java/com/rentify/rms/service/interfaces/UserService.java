package com.rentify.rms.service.interfaces;

import com.rentify.rms.dto.UserDto;
import com.rentify.rms.exception.InternalServerErrorException;
import com.rentify.rms.exception.UserRegistrationException;

public interface UserService {
    boolean register(UserDto userDto) throws UserRegistrationException, InternalServerErrorException;
}
