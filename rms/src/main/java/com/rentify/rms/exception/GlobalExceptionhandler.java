package com.rentify.rms.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionhandler {

    Log log = LogFactory.getLog(this.getClass());

    @ExceptionHandler(UserRegistrationException.class)
    public @ResponseBody ErrorInfo UserRegisterationException(UserRegistrationException e, HttpServletRequest req){
       return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
    }
}
