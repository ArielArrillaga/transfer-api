package com.demo.transfer_api.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.banelco.transferencias.ws.AgendaCBUDTO;
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
}
