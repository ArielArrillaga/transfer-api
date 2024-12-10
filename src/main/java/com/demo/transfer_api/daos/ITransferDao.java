package com.demo.transfer_api.daos;

import java.util.List;

import com.banelco.transferencias.ws.AgendaCBUDTO;

public interface ITransferDao {
	public List<AgendaCBUDTO> getRecipients(String numDoc, String typeDoc);
}
