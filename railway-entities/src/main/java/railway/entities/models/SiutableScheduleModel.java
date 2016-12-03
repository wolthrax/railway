package railway.entities.models;

import java.io.Serializable;

public class SiutableScheduleModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String fromTime;
	private String toTime;
	private String depatureStation;
	private String arrivalStation;
	
	public SiutableScheduleModel(String fromTime, String toTime, String depatureStation, String arrivalStation) {
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.depatureStation = depatureStation;
		this.arrivalStation = arrivalStation;
	}

	public String getFromTime() {
		return fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public String getDepatureStation() {
		return depatureStation;
	}

	public String getArrivalStation() {
		return arrivalStation;
	}
}
