package railway.services.train;

import java.util.List;

import railway.entities.Train;
import railway.entities.User;
import railway.entities.models.SiutableScheduleModel;
import railway.entities.models.TrainModel;

public interface ITrainManager {
	
	long addTrain(TrainModel trainModel);
	List<Train> getSiutableTrains(SiutableScheduleModel model);
	List<User> getPassengers(long trainId);
	void deleteTrains();

}