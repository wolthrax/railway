package railway.web.commands.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import railway.entities.Train;
import railway.entities.models.SiutableScheduleModel;
import railway.services.train.ITrainManager;
import railway.services.train.TrainManagerImpl;
import railway.utils.props.RailwayProps;
import railway.web.commands.AbstractCommand;
import railway.web.validator.SiutableScheduleValidator;

public class FindTrainCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		
		ITrainManager trainManager = new TrainManagerImpl();
		
		SiutableScheduleModel siutableScheduleModel = new SiutableScheduleModel(
				request.getParameter("fromTime"),
				request.getParameter("toTime"),
				request.getParameter("depatureStation"),
				request.getParameter("arrivalStation"));
		
		SiutableScheduleValidator validator = new SiutableScheduleValidator();
		Map<String,String> errors = validator.getErrorMap(siutableScheduleModel);
		
		if(errors.isEmpty()){
			List<Train> trainList = trainManager.getSiutableTrains(siutableScheduleModel);
			if(trainList.isEmpty())
				request.setAttribute("messageTrain", RailwayProps.getProperty("mess.train.no_train"));
			request.setAttribute("trainList", trainList);
		} else {
			request.setAttribute("errors", errors);
		}
		
		return RailwayProps.getProperty("page.admin.go_to_main");
	}

}
