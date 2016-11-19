package railway.services.station;

import java.sql.SQLException;
import java.util.List;

import railway.dba.dao.IBaseDao;
import railway.dba.dao.station.StationDaoImpl;
import railway.dba.utils.ConnectionPool;
import railway.entities.Station;

public class StationManagerImpl implements IStationManager{
	
	private IBaseDao<Station, Long> stationDao = new StationDaoImpl();

	@Override
	public void addStation(Station station) {
		
		try {
			stationDao.add(station);
		} catch (SQLException e) {
			ConnectionPool.getInstatce().connectionRollback(stationDao.getConnection());
		}
		
	}

	@Override
	public List<Station> getAllStations() {
		
		List<Station> stations = null;
		try {
			stations = stationDao.getAll();
		} catch (SQLException e) {
			ConnectionPool.getInstatce().connectionRollback(stationDao.getConnection());
		}
		
		return stations;
	}

}
