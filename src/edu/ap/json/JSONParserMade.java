package edu.ap.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;


public class JSONParserMade {
	
private static String INPUTFILE = "producten.json";
	
	public static String getSearchProduct(String naam) {
		JSONObject Product = new JSONObject();
		String result = "";
		
		try{
			FileReader reader = new FileReader(INPUTFILE);
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray)parser.parse(reader);
			
			for (Object med : array){
				JSONObject product = (JSONObject)med;
				
				if(((String)product.get("naam")).equalsIgnoreCase(naam)){
					
					product = product;
					
					String naam1 = String.valueOf(product.get("naam"));
					String producent = String.valueOf(product.get("producent"));
					String prijs = String.valueOf(product.get("prijs"));
					result += "naam: " + naam1 + "</br>";
					result += "producent: " + producent + "</br>";
					result += "prijs: " + prijs + "</br>";
					
				}
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return Product.toString();
		
	}
	
	public static String getProducts(){
		String producten = "";
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(INPUTFILE));
			while((line=br.readLine())!=null){
				producten+=line + "\n";
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return producten;
	}
	
	public String addProduct(JSONObject json) {

		  try (FileWriter file = new FileWriter(INPUTFILE)) {

	            file.write(json.toString());
	            file.flush();
	            return this.getProducts();
			
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
