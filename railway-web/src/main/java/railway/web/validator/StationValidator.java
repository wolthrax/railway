package railway.web.validator;

import java.util.HashMap;
import java.util.Map;

import railway.entities.Station;
import railway.utils.props.RailwayProps;

public class StationValidator extends Validator{
	
	public Map<String,String> getErrorMap(Station station){
		
		Map<String, String> errorMap = new HashMap<>();
		
		if(checkRegexp(station.getName(), RailwayProps.getProperty("regex.station.name")))
			errorMap.put("name", RailwayProps.getProperty("mess.error.station.name"));
		
		return errorMap;
	}

}
