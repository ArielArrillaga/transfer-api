package com.demo.transfer_api.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class RecipientsResponse {
	private List<Recipient> recipient;
	
	public RecipientsResponse (List<Recipient> recipients) {
		this.recipient = recipients;
	}
	
	public List<Recipient> getRecipient(){
		return new ArrayList<Recipient>(recipient);
	}
}
