package aws.arealapp.dynamo.ad;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import aws.arealapp.dynamo.model.AdParams;
import aws.arealapp.dynamo.util.DatabaseOperations;

public class GetAd implements RequestHandler<String, Object>{

	public Object handleRequest(String id, Context context) {
		
		DatabaseOperations databaseOp = new DatabaseOperations();
		
		return databaseOp.getObj(id, "Ads", new AdParams());
	}
}
