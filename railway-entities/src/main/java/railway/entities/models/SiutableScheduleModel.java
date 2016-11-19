package railway.entities.models;

import java.io.Serializable;

public class SiutableScheduleModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	String depatureTime;
	String depatureStation;
	String arrivalStation;
	
	public SiutableScheduleModel(String depatureTime, String depatureStation, String arrivalStation) {
		this.depatureTime = depatureTime;
		this.depatureStation = depatureStation;
		this.arrivalStation = arrivalStation;
	}
	
	public SiutableScheduleModel(){}

	public String getDepatureTime() {
		return depatureTime;
	}

	public void setDepatureTime(String depatureTime) {
		this.depatureTime = depatureTime;
	}

	public String getDepatureStation() {
		return depatureStation;
	}

	public void setDepatureStation(String depatureStation) {
		this.depatureStation = depatureStation;
	}

	public String getArrivalStation() {
		return arrivalStation;
	}

	public void setArrivalStation(String arrivalStation) {
		this.arrivalStation = arrivalStation;
	}
}
