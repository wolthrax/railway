package railway.entities;

import java.io.Serializable;

public class Schedule implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String depatureTime;
	private String arrivalTime;
	private String depatureStation;
	private String arrivalStation;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDepatureTime() {
		return depatureTime;
	}
	public void setDepatureTime(String depatureTime) {
		this.depatureTime = depatureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
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
	
	@Override
	public String toString() {
		return "Schedule [id=" + id + ", depatureTime=" + depatureTime + ", arrivalTime=" + arrivalTime
				+ ", depatureStation=" + depatureStation + ", arrivalStation=" + arrivalStation + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalStation == null) ? 0 : arrivalStation.hashCode());
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		result = prime * result + ((depatureStation == null) ? 0 : depatureStation.hashCode());
		result = prime * result + ((depatureTime == null) ? 0 : depatureTime.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		if (arrivalStation == null) {
			if (other.arrivalStation != null)
				return false;
		} else if (!arrivalStation.equals(other.arrivalStation))
			return false;
		if (arrivalTime == null) {
			if (other.arrivalTime != null)
				return false;
		} else if (!arrivalTime.equals(other.arrivalTime))
			return false;
		if (depatureStation == null) {
			if (other.depatureStation != null)
				return false;
		} else if (!depatureStation.equals(other.depatureStation))
			return false;
		if (depatureTime == null) {
			if (other.depatureTime != null)
				return false;
		} else if (!depatureTime.equals(other.depatureTime))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}
