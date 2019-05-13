package aws.arealapp.dynamo.model;

import java.util.HashMap;
import java.util.Map;

public class Marker {
	
	double latitude;
	double longditude;
	
	String pinColour;
	
	Map<String, Object> info;

	public Marker(double latitude, double longditude, 
			String pinColour, Map<String, Object> info) {
		super();
		this.latitude = latitude;
		this.longditude = longditude;
		this.pinColour = pinColour;
		this.info = info;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongditude() {
		return longditude;
	}

	public void setLongditude(double longditude) {
		this.longditude = longditude;
	}

	public String getPinColour() {
		return pinColour;
	}

	public void setPinColour(String pinColour) {
		this.pinColour = pinColour;
	}

	public Map<String, Object> getInfo() {
		return info;
	}

	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}

	
}
