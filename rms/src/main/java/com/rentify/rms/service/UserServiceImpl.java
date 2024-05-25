package com.rentify.rms.service;

import com.rentify.rms.dto.UserDto;
import com.rentify.rms.entity.User;
import com.rentify.rms.exception.InternalServerErrorException;
import com.rentify.rms.exception.UserRegistrationException;
import com.rentify.rms.repository.UserRepository;
import com.rentify.rms.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    private void handleDuplicateEmailError(String email) throws UserRegistrationException {
        // Return a custom error message to the frontend
        // For example, you can use a specific error code or string message
        throw new UserRegistrationException("Email already exists. Please try with another email.");
    }

    private void handleInternalServerError() throws InternalServerErrorException {
        // Handle other exceptions and return a generic error message
        throw new InternalServerErrorException("Internal server error occurred. Please try again later.");
    }

    @Override
    public boolean register(UserDto userDto) throws UserRegistrationException, InternalServerErrorException {
        try {
            User user = new User(userDto);
            userRepository.save(user);
            return true;
        } catch (DataIntegrityViolationException ex) {
            if (ex.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                handleDuplicateEmailError(userDto.getEmail());
            } else {
                handleInternalServerError();
            }
        } catch (Exception ex) {
            handleInternalServerError();
        }
        return false;
    }
}
