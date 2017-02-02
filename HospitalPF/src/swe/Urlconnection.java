package swe;



import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import java.nio.charset.StandardCharsets;
import java.io.InputStreamReader;
import java.io.BufferedReader;
//import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
 
public class Urlconnection {

	private static final String GEOCODING_API_URL = "https://maps.googleapis.com/maps/api/geocode/json";
	private static final String GOOGLE_API_KEY = "AIzaSyAVi-WNNwr2xYZTAWEbeUYgj__QHe_itRc";

	public static double[] getCoordinates(String address) throws Exception {
		// Convert address to url safe string
		String urlSafeAddress = URLEncoder.encode(address, java.nio.charset.StandardCharsets.UTF_8.toString());
		
		// Building the url
		String requestUrl = GEOCODING_API_URL + "?key=" + GOOGLE_API_KEY + "&address=" + urlSafeAddress;

		// Making a connection object to send a request to the built url.
		HttpURLConnection connection = (HttpURLConnection) new URL(requestUrl).openConnection();
        connection.setDoOutput(true);
        int status = connection.getResponseCode();

        // If response code is in the range 200 - 299 then it means that we got okay response
      	if(status / 100 != 2) {
            throw new Exception("Error occured while getting coordinates");
        }

      	// Reading the response same as we read a file.
      	BufferedReader reader = new BufferedReader(
          new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));

      	// We are using StringBuffer not Strings
      	// because strings are immutable and will consume more memory.
      	StringBuffer sb = new StringBuffer();
    	String line = null;
    	while ((line = reader.readLine()) != null) {
      		sb.append(line);
    	}
    	String jsonResponse = sb.toString();

    	// Parsing the json response which we read as string to a JSON Object.
      	JsonObject response = new JsonParser().parse(jsonResponse).getAsJsonObject();
      	//System.out.println("Response: " + response.toString());

      	// Extracting the coordinates from the JSON object.
      	JsonObject location = response.get("results").getAsJsonArray()
      								.get(0).getAsJsonObject()
      								.get("geometry").getAsJsonObject()
      								.get("location").getAsJsonObject();
      	double lat = location.get("lat").getAsDouble();
      	double lng = location.get("lng").getAsDouble();
      	double[] coordinates = new double[]{lat, lng};
      	return coordinates;
	}
}