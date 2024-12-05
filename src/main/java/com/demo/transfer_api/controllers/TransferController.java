package com.demo.transfer_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.transfer_api.entities.RecipientsResponse;

@RestController
@RequestMapping("/v1/transfers")
public class TransferController {

    @GetMapping("/customers-document/{customerDocument}/recipients")
    public ResponseEntity<RecipientsResponse> getRecipients(@PathVariable("customerDocument") String customerDocument,
    														@RequestParam("customer-document-type") String customerDocumentType) {
		
    	return  ResponseEntity.ok(null);
    }
}
