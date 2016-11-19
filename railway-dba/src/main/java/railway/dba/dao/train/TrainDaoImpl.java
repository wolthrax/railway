package railway.dba.dao.train;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import railway.dba.dao.BaseDaoImpl;
import railway.dba.enums.ColumnNames;
import railway.dba.utils.ConnectionPool;
import railway.dba.utils.Queries;
import railway.entities.Schedule;
import railway.entities.Train;
import railway.entities.models.SiutableScheduleModel;

public class TrainDaoImpl extends BaseDaoImpl<Train, Long> implements ITrainDao{
	
	public TrainDaoImpl() {
		super(Train.class);
	}

	@Override
	public List<Train> getAll(){
		
		return null;	
	}
	
	@Override
	public Long add(Train train) throws SQLException{
		
		connection = ConnectionPool.getInstatce().getConnection();
		
		PreparedStatement statement = connection.prepareStatement(Queries.getQuery("add_schedule"), 
				Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, train.getSchedule().getDepatureTime());
		statement.setString(2, train.getSchedule().getArrivalTime());
		statement.setLong(3, Long.valueOf(train.getSchedule().getDepatureStation()));
		statement.setLong(4,  Long.valueOf(train.getSchedule().getArrivalStation()));
		statement.executeUpdate();
		
		ResultSet result = statement.getGeneratedKeys();
		result.next();
		long scheduleId = result.getLong(1);
		
		statement.clearParameters();
		
		statement = connection.prepareStatement(Queries.getQuery("add_train"),
				Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, train.getPlaces());
		statement.setDouble(2, train.getPrice());
		statement.setLong(3, scheduleId);
		statement.executeUpdate();
		
		result = statement.getGeneratedKeys();
		result.next();
		long trainId = result.getLong(1);
		
		connection.commit();
		ConnectionPool.getInstatce().closeConnection(connection);
		
		return trainId;
	}

	@Override
	public List<Train> getSiutableTrains(SiutableScheduleModel model) throws SQLException {
		
		connection = ConnectionPool.getInstatce().getConnection();
		
		PreparedStatement statement = connection.prepareStatement(Queries.getQuery("get_needful_trains"));
		statement.setString(1, model.getDepatureTime());
		statement.setLong(2, Long.valueOf(model.getDepatureStation()));
		statement.setLong(3, Long.valueOf(model.getArrivalStation()));
		
		ResultSet result = statement.executeQuery();
		
		List<Train> trainList = new ArrayList<>();
		while(result.next()){
			Schedule schedule = new Schedule();
			
			schedule.setId(result.getLong(ColumnNames.SCHEDULE_ID.getColumnName()));
			schedule.setDepatureTime(result.getString(ColumnNames.SCHEDULE_DEPATURE_TIME.getColumnName()));
			schedule.setArrivalTime(result.getString(ColumnNames.SCHEDULE_ARRIVAL_TIME.getColumnName()));
			schedule.setDepatureStation(result.getString(ColumnNames.SCHEDULE_DEPATURE_STATION.getColumnName()));
			schedule.setArrivalStation(result.getString(ColumnNames.SCHEDULE_ARRIVAL_STATION.getColumnName()));
			
			Train train = new Train();
			train.setId(result.getLong(ColumnNames.TRAIN_ID.getColumnName()));
			train.setPlaces(result.getInt(ColumnNames.TRAIN_PLACES.getColumnName()));
			train.setPrice(result.getDouble(ColumnNames.TRAIN_PRICE.getColumnName()));
			train.setSchedule(schedule);
			
			trainList.add(train);
		}
		
		ConnectionPool.getInstatce().closeConnection(connection);
		
		return trainList;
	}
}
