package com.capstone.products.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.awt.image.RescaleOp;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleGenericRuntimeExceptions(RuntimeException ex,
                                                                        WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorResponse,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNPE(RuntimeException ex,
                                                                        WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorResponse,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}