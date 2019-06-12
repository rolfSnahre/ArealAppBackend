package aws.arealapp.dynamo.marker;

import java.util.Map;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import aws.arealapp.dynamo.model.MarkersParams;
import aws.arealapp.dynamo.util.DatabaseOperations;

public class GetAllMarkers implements RequestHandler<Map<String, Object>, Object> {
	@Override
	public Object handleRequest(Map<String, Object> input, Context context) {	
	
		DatabaseOperations databaseOp = new DatabaseOperations();
		
		return databaseOp.getAll(input, "Markers", new MarkersParams());
	}
}

