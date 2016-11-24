package railway.services.train;

import java.util.List;

import railway.entities.Train;
import railway.entities.models.SiutableScheduleModel;
import railway.entities.models.TrainModel;

public interface ITrainManager {
	
	long addTrain(TrainModel trainModel);
	List<Train> getSiutableTrains(SiutableScheduleModel model);

}