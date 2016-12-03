package railway.services.station;

import java.sql.SQLException;
import java.util.List;

import railway.dba.dao.station.IStationDao;
import railway.dba.dao.station.StationDaoImpl;
import railway.dba.utils.ConnectionPool;
import railway.entities.Station;
import railway.utils.logger.RailwayLogger;

public class StationManagerImpl implements IStationManager{
	
	private IStationDao stationDao = StationDaoImpl.getInstance();

	@Override
	public long addStation(Station station) {
		
		try {
			long id = stationDao.add(station);
			return id;
		} catch (SQLException e) {
			RailwayLogger.logError(getClass(), e.getMessage());
			ConnectionPool.getInstatce().connectionRollback(stationDao.getConnection());
			return -1;
		}
		
	}

	@Override
	public List<Station> getAllStations() {
		
		List<Station> stations = null;
		try {
			stations = stationDao.getAll();
		} catch (SQLException e) {
			RailwayLogger.logError(getClass(), e.getMessage());
			ConnectionPool.getInstatce().connectionRollback(stationDao.getConnection());
		}
		
		return stations;
	}

	@Override
	public long checkForUniqueness(String station) {
		
		long uniqueness = -1;
		try {
			uniqueness = stationDao.checkForUniqueness(station);
		} catch (SQLException e) {
			RailwayLogger.logError(getClass(), e.getMessage());
			ConnectionPool.getInstatce().connectionRollback(stationDao.getConnection());
		}
		return uniqueness;
	}
}
