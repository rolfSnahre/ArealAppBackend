package aws.arealapp.dynamo.marker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

import aws.arealapp.dynamo.model.Marker;
import aws.arealapp.dynamo.model.MarkersParams;
import aws.arealapp.dynamo.util.DUtil;
import aws.arealapp.dynamo.util.DatabaseOperations;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazonaws.services.kinesis.model.Consumer;

public class GetAllMarkers implements RequestHandler<Map<String, Object>, Object> {
	Gson gson = new Gson();
	@Override
	public Object handleRequest(Map<String, Object> input, Context context) {	
	
		DatabaseOperations databaseOp = new DatabaseOperations();
		
		return databaseOp.getAll(input, "Markers", new MarkersParams());
	}
}

