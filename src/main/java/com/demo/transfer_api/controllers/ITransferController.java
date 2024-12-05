package com.demo.transfer_api.controllers;

import org.springframework.http.ResponseEntity;

import com.demo.transfer_api.entities.RecipientsResponse;

public interface ITransferController {
	public ResponseEntity<RecipientsResponse> getRecipients(String customerDocument,String customerDocumentType);
}
