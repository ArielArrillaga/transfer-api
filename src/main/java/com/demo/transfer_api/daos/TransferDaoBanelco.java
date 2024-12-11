package com.demo.transfer_api.daos;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.banelco.transferencias.ws.AgendaCBUDTO;
import com.banelco.transferencias.ws.TerminalDTO;
import com.banelco.transferencias.ws.TransferenciasV2;
import com.banelco.transferencias.ws.TransferenciasV2Service;
import com.banelco.transferencias.ws.UsuarioDTO;
import com.demo.transfer_api.exceptionHandlers.InternalServerErrorException;

@Repository
public class TransferDaoBanelco implements ITransferDao{
	private static final Logger log = LoggerFactory.getLogger(TransferDaoBanelco.class);
	
	@Override
	public List<AgendaCBUDTO> getRecipients(String numDoc, String typeDoc) {
		
        TransferenciasV2Service service = new TransferenciasV2Service();
        TransferenciasV2 transferenciasPort = service.getTransferenciasV2Port();

        //Creo los objetos DTO necesarios
        UsuarioDTO usuario = new UsuarioDTO();
        TerminalDTO terminal = new TerminalDTO();
        
        log.info("TransferDaoBanelco: getRecipients: Seteando datos para request...");
        //Completo los datos
        usuario.setNroDocumento(numDoc);
        usuario.setTipoDocumento(typeDoc);
        
        try {
            // Llamar al servicio SOAP
        	List<AgendaCBUDTO> agenda = transferenciasPort.getAgendaCBU(usuario, terminal);
            log.info("TransferDaoBanelco: getRecipients: Respuesta de Banelco obtenida.");

            return agenda;
        } catch (Exception e) {
            log.error("TransferDaoBanelco: getRecipients: No se obtuvo respuesta de Banelco: "+e);
            throw new InternalServerErrorException("No se obtuvo respuesta del proveedor.");
        }
	}

}
