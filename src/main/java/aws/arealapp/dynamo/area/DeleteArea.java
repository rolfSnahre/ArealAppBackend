package aws.arealapp.dynamo.area;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import aws.arealapp.dynamo.model.AreaParams;
import aws.arealapp.dynamo.util.DatabaseOperations;

public class DeleteArea implements RequestHandler<String, Object>{


	@Override
	public Object handleRequest(String id, Context context) {
		
		DatabaseOperations databaseOp = new DatabaseOperations();
		
		return databaseOp.deleteObj(id, "Areas", new AreaParams());
		
	}
	
}