package com.demo.transfer_api.services;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banelco.transferencias.ws.AgendaCBUDTO;
import com.banelco.transferencias.ws.TerminalDTO;
import com.banelco.transferencias.ws.TransferenciasV2;
import com.banelco.transferencias.ws.TransferenciasV2Service;
import com.banelco.transferencias.ws.UsuarioDTO;
import com.demo.transfer_api.daos.ITransferDao;
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
