package aws.arealapp.dynamo.model;

public class Coord {
	double latitude;
	double longditude;
	
	public Coord() {
		latitude = 60;
		longditude = 5;
	}

	public Coord(double latitude, double longditude) {
		super();
		this.latitude = latitude;
		this.longditude = longditude;
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
	
	
}
