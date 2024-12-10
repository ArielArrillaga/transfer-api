package com.demo.transfer_api.daos;

import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.banelco.transferencias.ws.AgendaCBUDTO;
import com.banelco.transferencias.ws.GetAgendaCBUResponse;
import com.banelco.transferencias.ws.PropiedadDTO;
import com.demo.transfer_api.utils.CallHttp;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

@Repository
public class TransferDaoMock implements ITransferDao{

	@Override
	public List<AgendaCBUDTO> getRecipients(String numDoc, String typeDoc) {
		//JAXBContext context;
		
		//llamado a la api mock
		String responseMock = "";
		try {
			responseMock = CallHttp.llamadoHttpPost(new URL("http://localhost:3003/servicios/transferenciasV2"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			JSONObject json = XML.toJSONObject(responseMock);
			
			json = getJsonObject(json, "soapenv:Envelope");
			json = getJsonObject(json, "soapenv:Body");
			json = getJsonObject(json, "ws:getAgendaCBUResponse");
			JSONArray JSONArrayAgendaCbu = json.getJSONArray("agendaCBU");

			return this.mapArrayToAgenda(JSONArrayAgendaCbu);
			
		
		} catch (Exception e) { //para cualquier caso que no sea OK
			// agregar exceptionHandlers y logs
			e.printStackTrace();
		}
		return null;
        
	}
	
	private List<AgendaCBUDTO> mapArrayToAgenda(JSONArray JSONArrayAgendaCbu) throws Exception{  //Como solo busco que funcione el caso OK para los demas solo devuelvo exception
		
		List<AgendaCBUDTO> agenda = new ArrayList<AgendaCBUDTO>();
		
		for (int i = 0; i < JSONArrayAgendaCbu.length(); i++) {
		    JSONObject obj = JSONArrayAgendaCbu.getJSONObject(i);
		    
		    
		    AgendaCBUDTO agendaCbu = new AgendaCBUDTO();
		    agendaCbu.setCuitCuil(getValueFromJsonObject(obj, "cuitCuil").trim());
		    agendaCbu.setDescripcion(getValueFromJsonObject(obj, "descripcion").trim());
		    agendaCbu.setNroCBU(getValueFromJsonObject(obj, "nroCBU"));
		    
		    JSONObject propiedad = getJsonObject(obj, "propiedadDTO");
		    
		    PropiedadDTO propietario = new PropiedadDTO();
		    propietario.setCodigo(getValueFromJsonObject(propiedad, "codigo").trim());
		    propietario.setCtaCorriente(Boolean.valueOf(getValueFromJsonObject(propiedad, "ctaCorriente")));
		    propietario.setDescripcion(getValueFromJsonObject(propiedad, "descripcion").trim());
		    propietario.setPropia(Boolean.valueOf(getValueFromJsonObject(propiedad, "propia")));;

		    agendaCbu.setPropiedadDTO(propietario);
		    
		    agenda.add(agendaCbu);
		}
		return agenda;
	}

	private JSONObject getJsonObject(JSONObject jsonObject, String key) throws Exception {
		if (jsonObject.has(key)) {
		   return jsonObject.optJSONObject(key);
		}
		throw new Exception();
	}
	
	private String getValueFromJsonObject(JSONObject jsonObject, String key){
		if (jsonObject.has(key)) {
		   return jsonObject.optString(key);
		}
		return "";
	}

}
