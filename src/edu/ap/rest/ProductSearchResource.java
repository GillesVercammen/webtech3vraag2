package edu.ap.rest;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import edu.ap.json.JSONParserMade;

public class ProductSearchResource extends ServerResource {
	
	@Get("html")
	public String getSearchProducts(String searchTerm) {
		searchTerm = getAttribute("searchTerm");
		JSONParserMade parser = new JSONParserMade();
		return parser.getSearchProduct(searchTerm);
	}
}
