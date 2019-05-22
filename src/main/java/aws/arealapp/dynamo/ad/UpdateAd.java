package aws.arealapp.dynamo.ad;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import Interfaces.RequiredParams;
import aws.arealapp.dynamo.model.AdParams;
import aws.arealapp.dynamo.util.DatabaseOperations;

public class UpdateAd implements RequestHandler<Map<String,Object>, Object>{

	@Override
	public Object handleRequest(Map<String, Object> input, Context context) {
		
		DatabaseOperations databaseOps = new DatabaseOperations();
		
		RequiredParams paramObj = new AdParams();
		
		String pk = (String) input.get(paramObj.getPk());
		
		//Overskriver objekt med gitt partisionKey
		return databaseOps.addObj(pk, input, "Ads", paramObj);
		
	}
	
}
