package com.demo.transfer_api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.transfer_api.entities.RecipientsResponse;
import com.demo.transfer_api.services.ITransferService;

@RestController
@RequestMapping("/v1/transfers")
public class TransferController {
	private static final Logger log = LoggerFactory.getLogger(TransferController.class);
	
	@Autowired
	ITransferService transferService;
	
    @GetMapping("/customers-document/{customerDocument}/recipients")
    public ResponseEntity<RecipientsResponse> getRecipients(@PathVariable("customerDocument") String customerDocument,
    														@RequestParam("customer-document-type") String customerDocumentType) {
		log.info("TransferController: getRecipients: Request: "+customerDocumentType+": "+customerDocument);
		
    	return  ResponseEntity.ok(transferService.getRecipients(customerDocument, customerDocumentType));
    }
}
