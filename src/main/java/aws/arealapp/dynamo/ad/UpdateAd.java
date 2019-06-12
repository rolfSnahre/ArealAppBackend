package aws.arealapp.dynamo.ad;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import Interfaces.Params;
import aws.arealapp.dynamo.model.AdParams;
import aws.arealapp.dynamo.model.AreaParams;
import aws.arealapp.dynamo.util.DatabaseOperations;

public class UpdateAd implements RequestHandler<Map<String,Object>, Object>{

	@Override
	public Object handleRequest(Map<String, Object> input, Context context) {
		
		DatabaseOperations dops = new DatabaseOperations();
		
		AdParams adParams = new AdParams();
		
		String id = (String) input.get("adId");
		
		Map<String, Object> adMap;
		try {
			adMap = (Map) dops.getObj(id, "Ads", adParams);
		//Ads in all parameters from input
		for(String param : input.keySet()) {
			adMap.put(param, input.get(param));
		}
		
		//Overides previus object
		return dops.addObj(id, adMap, "Ads", adParams);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
		
	}
	
}
