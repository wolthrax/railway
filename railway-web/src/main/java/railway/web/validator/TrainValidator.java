package railway.web.validator;

import java.util.HashMap;
import java.util.Map;

import railway.entities.models.TrainModel;
import railway.utils.props.RailwayProps;

public class TrainValidator extends Validator{

	public Map<String,String> getErrorMap(TrainModel trainModel){
		
		Map<String, String> errorMap = new HashMap<>();
		
		if(checkRegexp(trainModel.getPlaces(), RailwayProps.getProperty("regex.train.places")))
			errorMap.put("places", RailwayProps.getProperty("mess.error.train.palces"));
		
		if(checkRegexp(trainModel.getPrice(), RailwayProps.getProperty("regex.train.places")))
			errorMap.put("price", RailwayProps.getProperty("mess.error.train.price"));
		
		if(checkRegexp(trainModel.getDepatureTime(), RailwayProps.getProperty("regex.schedule.time")))
			errorMap.put("depature_time", RailwayProps.getProperty("mess.error.schedule.time"));
		
		if(checkRegexp(trainModel.getArrivalTime(), RailwayProps.getProperty("regex.schedule.time")))
			errorMap.put("arrival_time", RailwayProps.getProperty("mess.error.schedule.time"));
		
//		if(checkRegexp(trainModel.getDepatureStation(), RailwayProps.getProperty("regex.station.name")))
//			errorMap.put("depature_station", RailwayProps.getProperty("mess.error.station.name"));
//		
//		if(checkRegexp(trainModel.getArrivalStation(), RailwayProps.getProperty("regex.station.name")))
//			errorMap.put("arrival_station", RailwayProps.getProperty("mess.error.station.name"));
		
		return errorMap;	
	}
}
