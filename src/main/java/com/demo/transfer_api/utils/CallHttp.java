package com.demo.transfer_api.utils;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
	
public class CallHttp {
	

    public static String llamadoHttpPost(URL url) throws IOException {
        
        String inputLine;
        StringBuffer response = new StringBuffer();
        HttpURLConnection con = null;

        con = (HttpURLConnection) url.openConnection();
        
        con.setRequestMethod("POST");
        con.setRequestProperty("cache-control", "no-cache");
        con.setRequestProperty("Content-Type", "application/xml");

        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in;
            in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            return con.getContent().toString();
        }
    }
	

}
