package org.example.controller.advice;

import org.example.dto.advice.ExceptionHandlerBodyDTO;
import org.example.exception.ErrorDataNotFound;
import org.example.exception.ErrorInvalidData;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.time.ZonedDateTime;

@ControllerAdvice
public class AdviceExceptionDTO extends ResponseEntityExceptionHandler {

    private ExceptionHandlerBodyDTO sendBodyException(String text, Integer httpStatus, String path) {
        return ExceptionHandlerBodyDTO.builder()
                .error(text)
                .httpStatus(httpStatus)
                .timestamp(ZonedDateTime.now())
                .path(path)
                .build();
    }

    @ExceptionHandler(value = ResourceAccessException.class)
    public ModelAndView handlerConnectException(ResourceAccessException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exception/error");
        ExceptionHandlerBodyDTO exceptionDTO = sendBodyException(ex.getClass().getSimpleName(),
                HttpStatus.SERVICE_UNAVAILABLE.value(), ex.getLocalizedMessage());
        modelAndView.addObject("exceptionDTO", exceptionDTO);
        return modelAndView;
    }

    @ExceptionHandler(value = RestClientResponseException.class)
    public ModelAndView handlerRestClientException(RestClientResponseException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exception/error");
        ExceptionHandlerBodyDTO exceptionDTO = sendBodyException(ex.getClass().getSimpleName(),
                ex.getRawStatusCode(), ex.getLocalizedMessage());
        modelAndView.addObject("exceptionDTO", exceptionDTO);
        return modelAndView;
    }

    @ExceptionHandler(value = ErrorInvalidData.class)
    public ModelAndView handlerErrorInvalidData(ErrorInvalidData ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exception/error");
        ExceptionHandlerBodyDTO exceptionDTO = sendBodyException(ex.getClass().getSimpleName(),
                HttpStatus.BAD_REQUEST.value(), ex.getLocalizedMessage());
        modelAndView.addObject("exceptionDTO", exceptionDTO);
        return modelAndView;
    }

    @ExceptionHandler(value = ErrorDataNotFound.class)
    public ModelAndView handlerErrorDataNotFound(ErrorDataNotFound ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exception/error");
        ExceptionHandlerBodyDTO exceptionDTO = sendBodyException(ex.getClass().getSimpleName(),
                HttpStatus.NOT_FOUND.value(), ex.getLocalizedMessage());
        modelAndView.addObject("exceptionDTO", exceptionDTO);
        return modelAndView;
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ModelAndView handlerUsernameNotFoundException(UsernameNotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exception/error");
        ExceptionHandlerBodyDTO exceptionDTO = sendBodyException(ex.getClass().getSimpleName(),
                HttpStatus.NOT_FOUND.value(), ex.getLocalizedMessage());
        modelAndView.addObject("exceptionDTO", exceptionDTO);
        return modelAndView;
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView handlerUsernameNotFoundException(NullPointerException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exception/error");
        ExceptionHandlerBodyDTO exceptionDTO = sendBodyException(ex.getClass().getSimpleName(),
                HttpStatus.NOT_FOUND.value(), ex.getLocalizedMessage());
        modelAndView.addObject("exceptionDTO", exceptionDTO);
        return modelAndView;
    }

    @ExceptionHandler(value = IOException.class)
    public ModelAndView handlerIOException(IOException ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exception/error");
        ExceptionHandlerBodyDTO exceptionDTO = sendBodyException(ex.getClass().getSimpleName(),
                HttpStatus.NOT_FOUND.value(), ex.getLocalizedMessage());
        modelAndView.addObject("exceptionDTO", exceptionDTO);
        return modelAndView;
    }
}


