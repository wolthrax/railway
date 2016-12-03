package railway.entities.models;

import java.io.Serializable;

public class InfoForTicketModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long userId;
	private long trainId;
	private int place;
	private double price;
	
	public InfoForTicketModel(long userId, long trainId, int place, double price) {
		
		this.userId = userId;
		this.trainId = trainId;
		this.place = place;
		this.price = price;
	}

	public long getUserId() {
		return userId;
	}

	public long getTrainId() {
		return trainId;
	}

	public int getPlace() {
		return place;
	}

	public double getPrice() {
		return price;
	}
}
