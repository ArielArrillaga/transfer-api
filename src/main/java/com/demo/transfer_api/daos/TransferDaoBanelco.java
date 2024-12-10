package com.demo.transfer_api.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.banelco.transferencias.ws.AgendaCBUDTO;
import com.banelco.transferencias.ws.TerminalDTO;
import com.banelco.transferencias.ws.TransferenciasV2;
import com.banelco.transferencias.ws.TransferenciasV2Service;
import com.banelco.transferencias.ws.UsuarioDTO;

@Repository
public class TransferDaoBanelco implements ITransferDao{

	@Override
	public List<AgendaCBUDTO> getRecipients(String numDoc, String typeDoc) {
		
        TransferenciasV2Service service = new TransferenciasV2Service();
        TransferenciasV2 transferenciasPort = service.getTransferenciasV2Port();

        //Creo los objetos DTO necesarios
        UsuarioDTO usuario = new UsuarioDTO();
        TerminalDTO terminal = new TerminalDTO();
        
        //Completo los datos
        usuario.setNroDocumento(numDoc);
        usuario.setTipoDocumento(typeDoc);
        
        try {
            // Llamar al servicio SOAP
        	List<AgendaCBUDTO> agenda = transferenciasPort.getAgendaCBU(usuario, terminal);
            return agenda;
        } catch (Exception e) {
            e.printStackTrace();
            //internal server error o algo asi
        }
        return null;
	}

}
