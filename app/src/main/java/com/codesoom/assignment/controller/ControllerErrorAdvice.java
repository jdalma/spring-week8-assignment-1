package com.codesoom.assignment.controller;

import com.codesoom.assignment.dto.ErrorResponse;
import com.codesoom.assignment.error.LoginFailException;
import com.codesoom.assignment.error.ProductNotFoundException;
import com.codesoom.assignment.error.ResourceCreateException;
import com.codesoom.assignment.error.UserEmailDuplicationException;
import com.codesoom.assignment.error.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseBody
@ControllerAdvice
public class ControllerErrorAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponse handleProductNotFound() {
        return new ErrorResponse("Product not found");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handleUserNotFound() {
        return new ErrorResponse("User not found");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserEmailDuplicationException.class)
    public ErrorResponse handleUserEmailIsAlreadyExisted() {
        return new ErrorResponse("User's email address is already existed");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(LoginFailException.class)
    public ErrorResponse handleLoginFailException() {
        return new ErrorResponse("Log-in failed");
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ResourceCreateException.class)
    public ErrorResponse handleResourceCreateException(ResourceCreateException exception) {
        return new ErrorResponse(exception.getMessage());
    }

}
