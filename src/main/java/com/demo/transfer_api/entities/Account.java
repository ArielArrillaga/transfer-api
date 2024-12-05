package com.demo.transfer_api.entities;

import lombok.Data;

@Data
public class Account {
	private String cbu;
	private Integer code;
	private boolean current;
	private boolean own;
}
