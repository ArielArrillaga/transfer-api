package com.demo.transfer_api.services;

import com.demo.transfer_api.entities.RecipientsResponse;

public interface ITransferService {
	public RecipientsResponse getRecipients(String numDoc, String typeDoc);
}
