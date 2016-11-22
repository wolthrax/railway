package railway.services.train;

import java.sql.SQLException;
import java.util.List;

import railway.dba.dao.IBaseDao;
import railway.dba.dao.train.ITrainDao;
import railway.dba.dao.train.TrainDaoImpl;
import railway.dba.utils.ConnectionPool;
import railway.entities.Train;
import railway.entities.models.SiutableScheduleModel;
import railway.utils.logger.RailwayLogger;

public class TrainManagerImpl implements ITrainManager{

	@Override
	public void addTrain(Train train) {
		
		IBaseDao<Train, Long> trainDao = new TrainDaoImpl();
		try {
			trainDao.add(train);
		} catch (SQLException e) {
			RailwayLogger.logError(getClass(), e.getMessage());
			ConnectionPool.getInstatce().connectionRollback(trainDao.getConnection());
		}
	}

	@Override
	public List<Train> getSiutableTrains(SiutableScheduleModel model) {
		ITrainDao trainDao = new TrainDaoImpl();
		
		List<Train> siutableTrainList = null;
		try {
			siutableTrainList = trainDao.getSiutableTrains(model);
		} catch (SQLException e) {
			ConnectionPool.getInstatce().connectionRollback(trainDao.getConnection());
		}
		return siutableTrainList;
	}
}
