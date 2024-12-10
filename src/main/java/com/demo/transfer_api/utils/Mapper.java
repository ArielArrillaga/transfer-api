package com.demo.transfer_api.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

import com.banelco.transferencias.ws.AgendaCBUDTO;
import com.banelco.transferencias.ws.PropiedadDTO;
import com.demo.transfer_api.entities.Account;
import com.demo.transfer_api.entities.Recipient;

public class Mapper {
	
    public static List<Recipient> mapToRecipients(List<AgendaCBUDTO> agendaCBUDTOs) {
        return agendaCBUDTOs.stream()
            .map(dto -> new Recipient(
                dto.getCuitCuil(), // Mapeo de cuitCuil a cuit
                dto.getDescripcion(), // Mapeo de descripcion a description
                new Account(
                    dto.getNroCBU(), // Mapeo de nroCBU a cbu
                    Integer.valueOf(dto.getPropiedadDTO().getCodigo()), // Mapeo de codigo a code
                    dto.getPropiedadDTO().isCtaCorriente(), // ctaCorriente a current
                    dto.getPropiedadDTO().isPropia() // propia a own
                )
            ))
            .collect(Collectors.toList());
    }
    
	public static List<AgendaCBUDTO> mapArrayToAgenda(JSONArray JSONArrayAgendaCbu) throws Exception{  //Como solo busco que funcione el caso OK para los demas solo devuelvo exception
		
		List<AgendaCBUDTO> agenda = new ArrayList<AgendaCBUDTO>();
		
		for (int i = 0; i < JSONArrayAgendaCbu.length(); i++) {
		    JSONObject obj = JSONArrayAgendaCbu.getJSONObject(i);
		    
		    
		    AgendaCBUDTO agendaCbu = new AgendaCBUDTO();
		    agendaCbu.setCuitCuil(JsonData.getValueFromJsonObject(obj, "cuitCuil").trim());
		    agendaCbu.setDescripcion(JsonData.getValueFromJsonObject(obj, "descripcion").trim());
		    agendaCbu.setNroCBU(JsonData.getValueFromJsonObject(obj, "nroCBU"));
		    
		    JSONObject propiedad = JsonData.getJsonObject(obj, "propiedadDTO");
		    
		    PropiedadDTO propietario = new PropiedadDTO();
		    propietario.setCodigo(JsonData.getValueFromJsonObject(propiedad, "codigo").trim());
		    propietario.setCtaCorriente(Boolean.valueOf(JsonData.getValueFromJsonObject(propiedad, "ctaCorriente")));
		    propietario.setDescripcion(JsonData.getValueFromJsonObject(propiedad, "descripcion").trim());
		    propietario.setPropia(Boolean.valueOf(JsonData.getValueFromJsonObject(propiedad, "propia")));;

		    agendaCbu.setPropiedadDTO(propietario);
		    
		    agenda.add(agendaCbu);
		}
		return agenda;
	}
}
