package aws.arealapp.dynamo.model;

import java.util.Map;

public class Place {
	String placeId, kontakt, email, 
		number, description, date;
	Map<String, Object> user;
	
	public Place() {
		super();
	}

	public Place(String placeId, String userId, String kontakt, String email, String number, String description,
			String date, Map<String, Object> user) {
		super();
		this.placeId = placeId;
		this.kontakt = kontakt;
		this.email = email;
		this.number = number;
		this.description = description;
		this.date = date;
		this.user = user;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Map<String, Object> getUser() {
		return user;
	}

	public void setUser(Map<String, Object> user) {
		this.user = user;
	}
	
	
}
