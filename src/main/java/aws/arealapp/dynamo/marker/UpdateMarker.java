package aws.arealapp.dynamo.marker;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import aws.arealapp.dynamo.model.AreaParams;
import aws.arealapp.dynamo.model.MarkersParams;
import aws.arealapp.dynamo.util.DatabaseOperations;

public class UpdateMarker implements RequestHandler<Map<String, Object>, Object> {

	public Object handleRequest(Map<String, Object> input, Context context) {
			
		DatabaseOperations dops = new DatabaseOperations();
		
		MarkersParams markerParams = new MarkersParams();
		
		String id = (String) input.get("markerId");
		
		Map<String, Object> markerMap;
		try {
			markerMap = (Map) dops.getObj(id, "Markers", markerParams);
		
		
		//Ads in all parameters from input
		for(String param : input.keySet()) {
			markerMap.put(param, input.get(param));
		}
		
		//Overides previus object
		return dops.addObj(id, markerMap, "Markers", markerParams);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
