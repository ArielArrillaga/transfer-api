package com.demo.transfer_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.transfer_api.daos.TransferDaoMock;
import com.demo.transfer_api.entities.RecipientsResponse;

@Service
public class TransferService implements ITransferService{
	
	@Autowired
	TransferDaoMock transferDao;

	@Override
	public RecipientsResponse getRecipients(String numDoc, String typeDoc) {
		return new RecipientsResponse(transferDao.getRecipients(numDoc, typeDoc));
	}
	
	



}
