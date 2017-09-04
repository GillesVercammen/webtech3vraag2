package edu.ap.rest;

import org.restlet.resource.ClientResource;
import org.json.JSONObject;

public class ProductClient {
	 public static void main(String[] args) {
         
         try {
        	ClientResource resource = new ClientResource("http://127.0.0.1:8181/products/productTable");
        	
        	JSONObject jsonObject = new JSONObject();
        	jsonObject.put("naam", "vaatwasser");
        	jsonObject.put("producent", "bosh");
        	jsonObject.put("prijs", "500");
        	System.out.println(jsonObject.toString());
        	resource.post(jsonObject.toString());
        	
        	JSONObject jsonObject2 = new JSONObject();
        	jsonObject2.put("naam", "stofzuiger");
        	jsonObject2.put("producent", "dyson");
        	jsonObject2.put("prijs", "300");
        	resource.post(jsonObject2.toString());

        }
        catch (Exception error) {
        	System.out.println(error.getMessage());
        }
    }
}
