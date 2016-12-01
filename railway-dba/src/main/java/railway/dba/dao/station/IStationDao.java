package railway.dba.dao.station;

import java.sql.SQLException;

import railway.dba.dao.IBaseDao;
import railway.entities.Station;

public interface IStationDao extends IBaseDao<Station, Long>{

	long checkForUniqueness(String station) throws SQLException;
	
}
