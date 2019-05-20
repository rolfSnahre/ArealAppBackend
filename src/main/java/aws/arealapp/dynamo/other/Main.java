package aws.arealapp.dynamo;

import com.google.gson.Gson;


public class Main {

	public static void main(String[] args) {
		
		Gson gson = new Gson();
		
		GetMarker gm = new GetMarker();
		
		
		AddMarker am = new AddMarker();
		
		GetAllMarkers gtm = new GetAllMarkers();
		

	}

}
