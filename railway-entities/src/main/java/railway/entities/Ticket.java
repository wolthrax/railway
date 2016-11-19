package railway.entities;

import java.io.Serializable;

public class Ticket implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long userId;
	private long trainId;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getTrainId() {
		return trainId;
	}
	public void setTrainId(long trainId) {
		this.trainId = trainId;
	}
	
	@Override
	public String toString() {
		return "Ticket [userId=" + userId + ", trainId=" + trainId + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (trainId ^ (trainId >>> 32));
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		Ticket other = (Ticket) obj;
		if (trainId != other.trainId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
}
