package com.ptit.ptitexam.exceptions;


import com.ptit.ptitexam.payload.response.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException e) {

        return new ErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(UsernameOrEmailAlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleUsernameOrEmailAlreadyExists(UsernameOrEmailAlreadyExists e) {
        return new ErrorResponse(HttpStatus.CONFLICT, e.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationException(ConstraintViolationException e) {
        e.getConstraintViolations().forEach(a -> System.out.println(a.getConstraintDescriptor()));
        return new ErrorResponse(HttpStatus.BAD_REQUEST, "Validation Failed");
    }
}
