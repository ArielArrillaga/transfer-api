package com.demo.transfer_api.entities;
import lombok.Data;

@Data
public class Recipient {
	private String cuit;
	private String description;
	private Account account;
}
