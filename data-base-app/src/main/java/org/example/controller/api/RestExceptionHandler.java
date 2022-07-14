package org.example.controller.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

//    private ExceptionHandlerBodyDTO sendBodyException(String text, HttpStatus httpStatus) {
//        return ExceptionHandlerBodyDTO.builder()
//                .error(text)
//                .httpStatus(httpStatus)
//                .timestamp(ZonedDateTime.now())
//                .path("data_base-app")
//                .build();
//    }
//
//    @ExceptionHandler(value = {ErrorInvalidData.class})
//    protected ResponseEntity<Object> handleErrorInvalidData(RuntimeException ex, WebRequest request) {
//        return handleExceptionInternal(
//                ex,
//                sendBodyException("The entered data is not correct", HttpStatus.BAD_REQUEST),
//                new HttpHeaders(),
//                HttpStatus.BAD_REQUEST,
//                request);
//    }
//
//    @ExceptionHandler(value = {ErrorDataNotFound.class})
//    protected ResponseEntity<Object> handleErrorDataNotFound(RuntimeException ex, WebRequest request) {
//        return handleExceptionInternal(
//                ex,
//                sendBodyException("The entered data is not found", HttpStatus.NOT_FOUND),
//                new HttpHeaders(),
//                HttpStatus.NOT_FOUND,
//                request);
//    }
//
//    @ExceptionHandler(value = {ErrorTransaction.class})
//    protected ResponseEntity<Object> handleErrorTransaction(RuntimeException ex, WebRequest request) {
//        return handleExceptionInternal(
//                ex,
//                sendBodyException("Error transacion", HttpStatus.INTERNAL_SERVER_ERROR),
//                new HttpHeaders(),
//                HttpStatus.INTERNAL_SERVER_ERROR,
//                request);
//    }
//
//    @ExceptionHandler(value = {NullPointerException.class})
//    protected ResponseEntity<Object> handleNullPointerException(RuntimeException ex, WebRequest request) {
//        return handleExceptionInternal(
//                ex,
//                sendBodyException("The entered data is not correct", HttpStatus.BAD_REQUEST),
//                new HttpHeaders(),
//                HttpStatus.BAD_REQUEST,
//                request);
//    }

}


