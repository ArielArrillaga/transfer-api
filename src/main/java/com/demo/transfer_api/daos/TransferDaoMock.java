package com.demo.transfer_api.daos;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import com.banelco.transferencias.ws.AgendaCBUDTO;
import com.demo.transfer_api.utils.CallHttp;
import com.demo.transfer_api.utils.JsonData;
import com.demo.transfer_api.utils.Mapper;

@Repository
public class TransferDaoMock implements ITransferDao{
	@Value("mockSoapUrl")
	String urlMock;

	@Override
	public List<AgendaCBUDTO> getRecipients(String numDoc, String typeDoc) {
		
		//llamado a la api mock
		String responseMock = "";
		try {
			//Deberia armar el request para el servicio, pero por la forma en que esta creado el mock, no necesito usar los parametros de entrada.
			responseMock = CallHttp.llamadoHttpPost(new URL(urlMock));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			 //En este punto deberia validar que existan los campos y analizar la respuesta, pero como el challenge es a modo ejemplo y
			 //se busca obtener solo la respuesta 200 evito dichas validaciones y si es 200 todo va a funcionar, en cualquier otro caso
			 //estaran las excepciones
			JSONObject json = XML.toJSONObject(responseMock);
			
			json = JsonData.getJsonObject(json, "soapenv:Envelope");
			json = JsonData.getJsonObject(json, "soapenv:Body");
			json = JsonData.getJsonObject(json, "ws:getAgendaCBUResponse");
			JSONArray JSONArrayAgendaCbu = json.getJSONArray("agendaCBU");

			return Mapper.mapArrayToAgenda(JSONArrayAgendaCbu);
		
		} catch (Exception e) { //para cualquier caso que no sea OK
			// agregar exceptionHandlers y logs
			e.printStackTrace();
		}
		return null;
        
	}

}
