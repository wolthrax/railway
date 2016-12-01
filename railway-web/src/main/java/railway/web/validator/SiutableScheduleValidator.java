package railway.web.validator;

import java.util.HashMap;
import java.util.Map;

import railway.entities.models.SiutableScheduleModel;
import railway.utils.props.RailwayProps;

public class SiutableScheduleValidator extends Validator{

	public Map<String,String> getErrorMap(SiutableScheduleModel model){
		
		Map<String, String> errorMap = new HashMap<>();
		
		if(checkRegexp(model.getFromTime(), RailwayProps.getProperty("regex.schedule.time")))
			errorMap.put("from_time", RailwayProps.getProperty("mess.error.schedule.from_time"));
		
		if(checkRegexp(model.getToTime(), RailwayProps.getProperty("regex.schedule.time")))
			errorMap.put("to_time", RailwayProps.getProperty("mess.error.schedule.to_time"));
		
		if(checkRegexp(model.getDepatureStation(), RailwayProps.getProperty("regex.station.number")) || 
				model.getDepatureStation().equals("0"))
			errorMap.put("depature_station", RailwayProps.getProperty("mess.error.station.depature_station_name"));
		
		if(checkRegexp(model.getArrivalStation(), RailwayProps.getProperty("regex.station.number")) || 
				model.getArrivalStation().equals("0"))
			errorMap.put("arrival_station", RailwayProps.getProperty("mess.error.station.arrival_station_name"));
		
		return errorMap;
	}
}
