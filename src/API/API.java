package API;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class API {

	public static JSONObject Consulta(String name) {
		HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

		HttpRequest request;
		try {
			request = HttpRequest.newBuilder(new URI("https://imdb-api.com/en/API/SearchMovie/k_arj9pg4t/"+name))
					.GET().build();		
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
		
		JSONObject myJson = new JSONObject(response.body());
		System.out.println(myJson);
		return myJson;
			
		} catch (URISyntaxException | IOException | InterruptedException e) {
			e.printStackTrace();
		}





		return null;
		
	}

}
