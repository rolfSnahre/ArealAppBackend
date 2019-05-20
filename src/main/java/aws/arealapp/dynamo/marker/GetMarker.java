package aws.arealapp.dynamo.marker;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

import aws.arealapp.dynamo.model.*;
import aws.arealapp.dynamo.util.DUtil;
import aws.arealapp.dynamo.util.DatabaseOperations;

public class GetMarker implements RequestHandler<String, Object> {
	 
	@Override
	public Object handleRequest(String id, Context context) {
		
		DatabaseOperations databaseOp = new DatabaseOperations();
		
		return databaseOp.getObj(id, "Markers", new MarkersParams());
		
	}
}
