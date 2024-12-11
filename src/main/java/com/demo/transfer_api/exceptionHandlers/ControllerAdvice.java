package com.demo.transfer_api.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
	
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            BadRequestException.class,
            org.springframework.web.bind.support.WebExchangeBindException.class,
            org.springframework.http.converter.HttpMessageNotReadableException.class,
            org.springframework.web.server.ServerWebInputException.class,
            org.springframework.web.HttpRequestMethodNotSupportedException.class,
            org.springframework.web.bind.MethodArgumentNotValidException.class,
            org.springframework.web.bind.MissingRequestHeaderException.class,
            org.springframework.web.bind.MissingServletRequestParameterException.class,
            java.util.InputMismatchException.class
    })
    @ResponseBody
    public Response badRequest(Exception ex) {
    	return new Response(ex.getMessage(),  HttpStatus.BAD_REQUEST.value());
    }
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseBody
    public Response internalServerError(InternalServerErrorException ex) {
    	return new Response(ex.getMessage(),  HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
    
}
