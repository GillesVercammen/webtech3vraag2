package edu.ap.rest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import edu.ap.json.JSONParserMade;

public class ProductResource extends ServerResource {
	private static final String INPUTFILE = "producten.json";

	@Get("json")
	public String getProducten() {
		JSONParserMade parses = new JSONParserMade();
		return parses.getProducts();
	}
	
	@Post("json")
	public void addProduct(String json) throws JSONException {
		
		
		JSONObject product = new JSONObject(json);
		JSONArray array = new JSONArray();
		JSONParser parser = new JSONParser();
		
		
		try {
			array = (JSONArray) parser.parse(new FileReader(INPUTFILE));
		} 			
		catch (Exception e) {
			System.out.println(e);
		}
				
		try {
			File file=new File(INPUTFILE);
			FileWriter fw=new FileWriter(file,false);
			BufferedWriter bf=new BufferedWriter(fw);
			PrintWriter pr=new PrintWriter(bf);
			pr.print(array.toString());
			pr.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
