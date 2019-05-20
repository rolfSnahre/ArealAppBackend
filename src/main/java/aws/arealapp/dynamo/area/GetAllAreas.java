package aws.arealapp.dynamo.area;

import java.util.Map;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

import aws.arealapp.dynamo.model.AreaParams;
import aws.arealapp.dynamo.util.DatabaseOperations;

public class GetAllAreas implements RequestHandler<Map<String, Object>, Object> {
	Gson gson = new Gson();
	@Override
	public Object handleRequest(Map<String, Object> input, Context context) {	
	
		DatabaseOperations databaseOp = new DatabaseOperations();
		
		return databaseOp.getAll(input, "Areas", new AreaParams());
	}
}
