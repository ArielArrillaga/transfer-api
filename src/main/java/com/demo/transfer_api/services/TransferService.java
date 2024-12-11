package com.demo.transfer_api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.transfer_api.daos.ITransferDao;
import com.demo.transfer_api.daos.TransferDaoBanelco;
import com.demo.transfer_api.daos.TransferDaoMock;
import com.demo.transfer_api.entities.RecipientsResponse;
import com.demo.transfer_api.enums.DocEnum;
import com.demo.transfer_api.exceptionHandlers.BadRequestException;
import com.demo.transfer_api.exceptionHandlers.InternalServerErrorException;

@Service
public class TransferService implements ITransferService{
	private static final Logger log = LoggerFactory.getLogger(TransferService.class);
	@Autowired
	TransferDaoMock mockDao;
	
	@Autowired
	TransferDaoBanelco banelcoDao;

	@Override
	public RecipientsResponse getRecipients(String numDoc, String typeDoc) {// Para mock doc = 1234 typeDoc = DNI
		
		ITransferDao dao = banelcoDao; //Por defecto es banelco
		
		if (isUserMock(numDoc, typeDoc)) { //si es usuario mock lo cambio
			log.info("TransferService: getRecipients: Usando servicio mock");
			dao = mockDao;
		}
		
		return new RecipientsResponse(dao.getRecipients(numDoc, this.typeDocCode(typeDoc)));

	}
	
	private boolean isUserMock(String numDoc, String typeDoc) {
		return (numDoc.equals("1234")&&typeDoc.equals("DNI"));
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
	            	 log.error("TransferService: typeDocCode: Tipo de documento inválido.");
	            	 throw new BadRequestException("Tipo de documento inválido");
         }
     } catch (IllegalArgumentException e) {
    	 log.error("TransferService: typeDocCode: Algo salió mal al mapear el tipo de documento: "+e);
    	 throw new InternalServerErrorException("Error interno de servicio, por favor vuelva a intentar.");
     }
	}

}
