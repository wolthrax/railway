package railway.services.station;

import java.util.List;

import railway.entities.Station;

public interface IStationManager {

	long addStation(Station station);
	List<Station> getAllStations();
	long checkForUniqueness(String station);
	
}
