package aws.arealapp.dynamo.ad;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import aws.arealapp.dynamo.model.AdParams;
import aws.arealapp.dynamo.util.DatabaseOperations;

public class DeleteAd implements RequestHandler<String, Object> {

public Object handleRequest(String id, Context context) {
		
		DatabaseOperations databaseOp = new DatabaseOperations();
		
		try {
			return databaseOp.deleteObj(id, "Ads", new AdParams());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
