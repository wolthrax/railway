package railway.web.validator;

import java.util.HashMap;
import java.util.Map;

import railway.entities.models.SiutableScheduleModel;
import railway.utils.props.RailwayProps;

public class SiutableScheduleValidator extends Validator{

	public Map<String,String> getErrorMap(SiutableScheduleModel model){
		
		Map<String, String> errorMap = new HashMap<>();
		
		if(checkRegexp(model.getDepatureTime(), RailwayProps.getProperty("regex.schedule.time")))
			errorMap.put("depature_time", RailwayProps.getProperty("mess.error.schedule.time"));
		
		if(checkRegexp(model.getDepatureStation(), RailwayProps.getProperty("regex.station.number")))
			errorMap.put("depature_station", RailwayProps.getProperty("mess.error.station.name"));
		
		if(checkRegexp(model.getArrivalStation(), RailwayProps.getProperty("regex.station.number")))
			errorMap.put("arrival_station", RailwayProps.getProperty("mess.error.station.name"));
		
		return errorMap;
	}
}
