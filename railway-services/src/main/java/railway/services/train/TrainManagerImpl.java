package railway.services.train;

import java.sql.SQLException;
import java.util.List;

import railway.dba.dao.IBaseDao;
import railway.dba.dao.train.ITrainDao;
import railway.dba.dao.train.TrainDaoImpl;
import railway.dba.utils.ConnectionPool;
import railway.entities.Schedule;
import railway.entities.Train;
import railway.entities.User;
import railway.entities.models.SiutableScheduleModel;
import railway.entities.models.TrainModel;
import railway.utils.logger.RailwayLogger;

public class TrainManagerImpl implements ITrainManager{

	@Override
	public long addTrain(TrainModel trainModel) {
		
		IBaseDao<Train, Long> trainDao = new TrainDaoImpl();
		
		Schedule schedule = new Schedule();
		schedule.setDepatureTime(trainModel.getDepatureTime());
		schedule.setArrivalTime(trainModel.getArrivalTime());
		schedule.setDepatureStation(trainModel.getDepatureStation());
		schedule.setArrivalStation(trainModel.getArrivalStation());
		
		Train train = new Train();
		train.setPlaces(Integer.parseInt(trainModel.getPlaces()));
		train.setPrice(Double.parseDouble(trainModel.getPrice()));
		train.setSchedule(schedule);
		
		try {
			return trainDao.add(train);
		} catch (SQLException e) {
			RailwayLogger.logError(getClass(), e.getMessage());
			ConnectionPool.getInstatce().connectionRollback(trainDao.getConnection());
			return -1;
		}
	}

	@Override
	public List<Train> getSiutableTrains(SiutableScheduleModel model) {
		ITrainDao trainDao = new TrainDaoImpl();
		
		List<Train> siutableTrainList = null;
		try {
			siutableTrainList = trainDao.getSiutableTrains(model);
		} catch (SQLException e) {
			RailwayLogger.logError(getClass(), e.getMessage());
			ConnectionPool.getInstatce().connectionRollback(trainDao.getConnection());
		}
		return siutableTrainList;
	}

	@Override
	public List<User> getPassengers(long trainId) {

		ITrainDao trainDao = new TrainDaoImpl();
		
		List<User> userList = null;
		try {
			userList = trainDao.getUsersByTrainId(trainId);
		} catch (SQLException e) {
			RailwayLogger.logError(getClass(), e.getMessage());
			ConnectionPool.getInstatce().connectionRollback(trainDao.getConnection());
		}
		
		return userList;
	}

	@Override
	public void deleteTrains() {
		
		ITrainDao trainDao = new TrainDaoImpl();
		
		try {
			trainDao.deleteTrains();
		} catch (SQLException e) {
			RailwayLogger.logError(getClass(), e.getMessage());
			ConnectionPool.getInstatce().connectionRollback(trainDao.getConnection());
		}
	}
}
