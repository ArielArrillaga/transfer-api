package com.demo.transfer_api.exceptionHandlers;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Response {

	//En el yaml se ve que la interfaz para la respuesta es diferente, pero dado que solo se busca el caso 200 decidi simplificarla
	
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
