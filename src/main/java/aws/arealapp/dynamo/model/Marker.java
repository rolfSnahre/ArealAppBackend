package aws.arealapp.dynamo.model;

import java.util.HashMap;
import java.util.Map;

public class Marker {
	
	String key;
	
	String pinColor;
	
	Map<String, Double> coordinate;
	
	Map<String, Object> markerData;
	
	public Marker() {
		
	}

	public Marker(String markerId, String pinColor,
			Map<String, Double> coordinate, Map<String, Object> markerData) {
		super();
		this.key = markerId;
		this.pinColor = pinColor;
		this.coordinate = coordinate;
		this.markerData = markerData;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String markerId) {
		this.key = markerId;
	}

	public String getPinColor() {
		return pinColor;
	}

	public void setPinColor(String pinColor) {
		this.pinColor = pinColor;
	}

	public Map<String, Double> getcoordinate() {
		return coordinate;
	}

	public void setcoordinate(Map<String, Double> coordinate) {
		this.coordinate = coordinate;
	}

	public Map<String, Object> getMarkerData() {
		return markerData;
	}

	public void setMarkerData(Map<String, Object> markerData) {
		this.markerData = markerData;
	}

	
	
	
}