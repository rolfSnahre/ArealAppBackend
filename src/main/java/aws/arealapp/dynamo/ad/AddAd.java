package aws.arealapp.dynamo.ad;

import java.util.Map;
import org.joda.time.DateTime;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import aws.arealapp.dynamo.model.AdParams;
import aws.arealapp.dynamo.util.DUtil;

public class AddAd implements RequestHandler<Map<String, Object>, Object> {

	public Object handleRequest(Map<String, Object> input, Context context) {
		
		Table table = DUtil.getTable("Ads");
		
		AdParams adParams = new AdParams();
		
		try {
			Item item = DUtil.makeItemWithParams(input, adParams);
			
			DateTime dateTime = DateTime.now();
			String date = dateTime.getDayOfMonth() + "/" + dateTime.getMonthOfYear() + "/" + dateTime.getYear();
			
			item.withString("date", date);
			table.putItem(item);
			
			return item.asMap();
		} catch (Exception e) {
			return e.getMessage();
		}
		
		
		
	}
}
