import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class InviteCustomers {
	
	public static void main(String args[]) throws IOException{
		double lat1=12.935076;
		double lng1=77.614277;
		double inilat=Math.toRadians(lat1);
		//double inilng=Math.toRadians(lng1);
		BufferedReader br=null;
		br=new BufferedReader(new FileReader("./customers.json"));
		StringBuffer fileContent=new StringBuffer();
		String line=null;
		while((line=br.readLine())!=null){
			fileContent.append(line);	
		}
		br.close();
		
		//System.out.println(fileContent.toString());
		
		JsonObject root=new JsonParser().parse(fileContent.toString()).getAsJsonObject();
		JsonArray customerList=root.get("customers").getAsJsonArray();
		
		for(JsonElement customerElement : customerList){
			
			JsonObject customer=customerElement.getAsJsonObject();
			String name=customer.get("name").getAsString();
			int id=customer.get("id").getAsInt();
			JsonObject address=customer.get("address").getAsJsonObject();
			double lat2=address.get("lat").getAsDouble();
			double lng2=address.get("lng").getAsDouble();
			
			//lattitude and longitude converted to radians
			double latRad=Math.toRadians(lat2);
			//double lngRad=Math.toRadians(lng2);
			
			double phi=Math.toRadians(lat1-lat2);
			double lambda=Math.toRadians(lng1-lng2);
			
			/*double lambdaRad=Math.toRadians(lambda);
			double sigma=Math.acos((Math.sin(inilat)*Math.sin(latRad))+(Math.cos(inilat)*Math.cos(latRad)*Math.cos(lambdaRad)));*/
			//double distance=6371000 * sigma;
			
			double a=Math.sin(phi/2)*Math.sin(phi/2)+
					Math.cos(inilat)*Math.cos(latRad)+
					Math.sin(lambda/2)*Math.sin(lambda/2);
			double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
			double distance=6371e3 * c;
			System.out.println(name);
			System.out.format("Distance from office:%f km", distance/1000);
			System.out.println("");
			
		}
		
	}

}
