package com.demo.transfer_api.entities;

import lombok.Data;

@Data
public class Account {
	private String cbu;
	private Integer code;
	private boolean current;
	private boolean own;
	
    public Account(String cbu, Integer code, boolean current, boolean own) {
        this.cbu = cbu;
        this.code = code;
        this.current = current;
        this.own = own;
    }
}
