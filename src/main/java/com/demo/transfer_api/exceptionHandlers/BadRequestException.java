package com.demo.transfer_api.exceptionHandlers;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

    public BadRequestException(String detail) {
        super(detail);
    }

}