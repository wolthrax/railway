package railway.web.validator;

import java.util.HashMap;
import java.util.Map;

import railway.entities.Station;
import railway.utils.props.RailwayProps;

public class StationValidator extends Validator{
	
	public Map<String,String> getErrorMap(Station station){
		
		Map<String, String> errorMap = new HashMap<>();
		
		if(checkRegexp(station.getName()))
			errorMap.put("name", RailwayProps.getProperty("mess.error.station_name"));
		
		return errorMap;
	}

}
