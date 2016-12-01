package railway.web.commands.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import railway.entities.Station;
import railway.services.station.IStationManager;
import railway.services.station.StationManagerImpl;
import railway.utils.props.RailwayProps;
import railway.web.commands.AbstractCommand;
import railway.web.validator.StationValidator;

public class AddStationCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		
		IStationManager stationManager = new StationManagerImpl();
		
		long uniqueStationName = stationManager.checkForUniqueness(request.getParameter("station"));
		
		if(uniqueStationName == 0){
			Station station = new Station();
			station.setName(request.getParameter("station"));
			
			StationValidator stationValidator = new StationValidator();
			Map<String,String> errors = stationValidator.getErrorMap(station);
			
			if(errors.isEmpty()){
				long id = stationManager.addStation(station);
				if(id > 0){
					request.setAttribute("message", RailwayProps.getProperty("mess.station"));
				} else request.setAttribute("message", RailwayProps.getProperty("mess.error.station"));
				
			}else{
				request.setAttribute("errors", errors);
				return RailwayProps.getProperty("page.admin.add_station");
			}
		} else {
			request.setAttribute("message", "Station with name " + 
					"\"" + request.getParameter("station") + 
					"\"" + " alredy exists.");
			return RailwayProps.getProperty("page.admin.add_station");
		}
		return RailwayProps.getProperty("page.admin.go_to_main");
	}
}
