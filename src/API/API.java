package API;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class API {

	
	
	
	
	public static JSONArray Consulta(String name) {
		HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

		HttpRequest request;
		try {
			request = HttpRequest.newBuilder(new URI("https://imdb-api.com/en/API/SearchMovie/k_hn279zy6/"+name))
					.GET().build();		
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
		
		JSONObject myJson = new JSONObject(response.body());

		
		return (JSONArray) myJson.get("results");
			
		} catch (URISyntaxException | IOException | InterruptedException e) {
			e.printStackTrace();
		}





		return null;
		
	}
	
	
	public static JSONObject Consulta2(String id) {
		HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

		HttpRequest request;
		try {
			request = HttpRequest.newBuilder(new URI("https://imdb-api.com/en/API/Title/k_hn279zy6/"+id))
					.GET().build();		
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		
		JSONObject myJson = new JSONObject(response.body());

		return myJson;
			
		} catch (URISyntaxException | IOException | InterruptedException e) {
			e.printStackTrace();
		}

		return null;
		
	}
	
	
	
	

}
