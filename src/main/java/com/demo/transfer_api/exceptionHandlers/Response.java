package com.demo.transfer_api.exceptionHandlers;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Response {

	private String menssage;
	private int code;
	private UUID id;

	public Response(String menssage, int code) {
		this.menssage = menssage;
		this.code = code;
		this.id = UUID.randomUUID();
	}
	
    public Response() {
        this.id = UUID.randomUUID(); 
    }
}
