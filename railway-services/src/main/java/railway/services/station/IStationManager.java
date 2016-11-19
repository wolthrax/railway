package railway.services.station;

import java.util.List;

import railway.entities.Station;

public interface IStationManager {

	void addStation(Station station);
	List<Station> getAllStations();
	
}
