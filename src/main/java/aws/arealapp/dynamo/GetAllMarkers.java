package aws.arealapp.dynamo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

import aws.arealapp.dynamo.model.SimpleMarker;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazonaws.services.kinesis.model.Consumer;

public class GetAllMarkers implements RequestHandler<Map<Object, Object>, Object> {
	Gson gson = new Gson();
	@Override
	public Object handleRequest(Map<Object, Object> map, Context context) {	
	
	Table table = DUtil.getTable();
		
		ScanSpec spec = new ScanSpec().
				withProjectionExpression("latitude, longditude, pinColour, info");
		try {
			ItemCollection<ScanOutcome> mCol = table.scan(spec);
			Iterator<Item> mIter = mCol.iterator();

			List<SimpleMarker> SimpleMarkersL = new ArrayList<SimpleMarker>();
			SimpleMarker sMarker;
			
			while(mIter.hasNext()) {
				Item item = mIter.next();
				
				sMarker = gson.fromJson(item.toJSON(), SimpleMarker.class);
				
				SimpleMarkersL.add(sMarker);
			}

			return SimpleMarkersL;
		}catch(Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
		
	}	
}

