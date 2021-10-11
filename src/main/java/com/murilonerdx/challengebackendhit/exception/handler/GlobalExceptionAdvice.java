package com.murilonerdx.challengebackendhit.exception.handler;

import com.murilonerdx.challengebackendhit.exception.NotFoundPlanet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    public List<FieldDataError> handle(MethodArgumentNotValidException e){
        List<FieldDataError> list = new ArrayList<>();
        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        errors.forEach(erro->{
            list.add(new FieldDataError(erro.getField(), erro.getDefaultMessage(), LocalDateTime.now()));
        });
        return list;
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<FieldDataError> handleAllExceptions(Exception ex, WebRequest request) {
        FieldDataError exceptionResponse =
                new FieldDataError(
                        ex.getMessage(),
                        request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundPlanet.class)
    public final ResponseEntity<FieldDataError> handleBadRequestExceptions(Exception ex, WebRequest request) {
        FieldDataError exceptionResponse =
                new FieldDataError(
                        ex.getMessage(),
                        request.getDescription(false),  LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
