package com.demo.transfer_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.transfer_api.daos.TransferDaoMock;
import com.demo.transfer_api.entities.RecipientsResponse;
import com.demo.transfer_api.enums.DocEnum;

@Service
public class TransferService implements ITransferService{
	
	@Autowired
	TransferDaoMock transferDao;

	@Override
	public RecipientsResponse getRecipients(String numDoc, String typeDoc) {
		return new RecipientsResponse(transferDao.getRecipients(numDoc, this.typeDocCode(typeDoc)));
	}
	
	//agrego una validacion y mapeo para permitir al usuario usar nombres descriptivos y mapearlo a su codigo si exite dicho nombre
	private String typeDocCode(String typeDock) {
		try {
			DocEnum tipo = DocEnum.valueOf(typeDock.toUpperCase());
	        switch (tipo) {
	             case DNI:
	                 return DocEnum.DNI.getCodigo();
	             case LE:
	                 return DocEnum.LE.getCodigo();
	             case LC:
	                 return DocEnum.LC.getCodigo();
	             case CUIT:
	                 return DocEnum.CUIT.getCodigo();
	             case CI:
	                 return DocEnum.CI.getCodigo();
	             case PAS:
	                 return DocEnum.PAS.getCodigo();
	             default:
	            	 //404
	            	 //devuelvo exception
                 return null; // Caso por defecto (opcional)
         }
     } catch (IllegalArgumentException e) {
    	 //devuelvo 404
         return null; // Si la entrada no es válida
     }
	}



}
