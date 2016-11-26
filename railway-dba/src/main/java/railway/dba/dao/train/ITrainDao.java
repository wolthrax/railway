package railway.dba.dao.train;

import java.sql.SQLException;
import java.util.List;

import railway.dba.dao.IBaseDao;
import railway.entities.Train;
import railway.entities.User;
import railway.entities.models.SiutableScheduleModel;

public interface ITrainDao extends IBaseDao<Train, Long>{
	
	List<Train> getSiutableTrains(SiutableScheduleModel model) throws SQLException;
	List<User> getUsersByTrainId(long id) throws SQLException;

}
