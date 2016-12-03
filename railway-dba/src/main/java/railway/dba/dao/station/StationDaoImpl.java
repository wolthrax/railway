package railway.dba.dao.station;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import railway.dba.dao.BaseDaoImpl;
import railway.dba.enums.ColumnNames;
import railway.dba.utils.ConnectionPool;
import railway.entities.Station;
import railway.utils.props.RailwayProps;

public class StationDaoImpl extends BaseDaoImpl<Station, Long> implements IStationDao{
	
	public static StationDaoImpl StationDaoImpl;
	
	private StationDaoImpl() {
		super(Station.class);
	}
	
	public static StationDaoImpl getInstance(){
		if(StationDaoImpl == null){
			StationDaoImpl = new StationDaoImpl();
			return StationDaoImpl;
		} else return StationDaoImpl;
	}
	
	@Override
	public Long add(Station station) throws SQLException{
		
		connection = ConnectionPool.getInstatce().getConnection();
		
		PreparedStatement statement = connection.prepareStatement(RailwayProps.getProperty("query.add_station"),
				Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, station.getName());
		statement.executeUpdate();
		
		ResultSet result = statement.getGeneratedKeys();
		result.next();
		
		long id = result.getLong(1);
		
		connection.commit();
		ConnectionPool.getInstatce().closeConnection(connection);
		
		return id;
	}
	
	@Override
	public List<Station> getAll() throws SQLException{
		
		connection = ConnectionPool.getInstatce().getConnection();
		
		PreparedStatement statement = connection.prepareStatement(RailwayProps.getProperty("query.get_all_stations"));
		ResultSet result = statement.executeQuery();
		List<Station> stationList = new ArrayList<>();
		
		while(result.next()){
			Station station = new Station();
			station.setId(result.getLong(ColumnNames.STATION_ID.getColumnName()));
			station.setName(result.getString(ColumnNames.STATION_NAME.getColumnName()));
			
			stationList.add(station);
		}
		
		ConnectionPool.getInstatce().closeConnection(connection);
		return stationList;
	}

	@Override
	public long checkForUniqueness(String station) throws SQLException {
		connection = ConnectionPool.getInstatce().getConnection();
		
		PreparedStatement statement = connection.prepareStatement(RailwayProps.getProperty("query.check_station_for_uniqueness"));
		statement.setString(1, station);
		
		ResultSet resultSet = statement.executeQuery();
		resultSet.next();
		
		long result = resultSet.getLong(1);
		
		ConnectionPool.getInstatce().closeConnection(connection);
		return result;
	}

}
