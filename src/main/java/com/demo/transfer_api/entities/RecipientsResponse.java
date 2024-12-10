package com.demo.transfer_api.entities;

import java.util.ArrayList;
import java.util.List;

import com.banelco.transferencias.ws.AgendaCBUDTO;
import com.demo.transfer_api.utils.Mapper;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class RecipientsResponse {
	private List<Recipient> recipient;
	
	public RecipientsResponse (List<AgendaCBUDTO> recipients) {
		this.recipient = Mapper.mapToRecipients(recipients);
	}
	
	public List<Recipient> getRecipient(){
		return new ArrayList<Recipient>(recipient);
	}
}
