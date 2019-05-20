package aws.arealapp.dynamo.ad;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import aws.arealapp.dynamo.model.AdParams;
import aws.arealapp.dynamo.model.MarkersParams;
import aws.arealapp.dynamo.util.DatabaseOperations;

public class AddAd implements RequestHandler<Map<String, Object>, Object> {

	public Object handleRequest(Map<String, Object> input, Context context) {
		
		DatabaseOperations databaseOp = new DatabaseOperations();
		
		return databaseOp.addObjRandId(input, "Ads", new AdParams());
		
		
	}
}
