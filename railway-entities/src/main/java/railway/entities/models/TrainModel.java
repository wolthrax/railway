package railway.entities.models;

import java.io.Serializable;

public class TrainModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String places;
	private String price;
	private String depatureTime;
	private String arrivalTime;
	private String depatureStation;
	private String arrivalStation;
	
	public TrainModel(String places, String price, String depatureTime, String arrivalTime, String depatureStation,
			String arrivalStation) {

		this.places = places;
		this.price = price;
		this.depatureTime = depatureTime;
		this.arrivalTime = arrivalTime;
		this.depatureStation = depatureStation;
		this.arrivalStation = arrivalStation;
	}

	public String getPlaces() {
		return places;
	}

	public String getPrice() {
		return price;
	}

	public String getDepatureTime() {
		return depatureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public String getDepatureStation() {
		return depatureStation;
	}

	public String getArrivalStation() {
		return arrivalStation;
	}
}
