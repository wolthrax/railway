package railway.services.train;

import java.util.List;

import railway.entities.Train;
import railway.entities.models.SiutableScheduleModel;

public interface ITrainManager {
	
	void addTrain(Train train);
	List<Train> getSiutableTrains(SiutableScheduleModel model);

}