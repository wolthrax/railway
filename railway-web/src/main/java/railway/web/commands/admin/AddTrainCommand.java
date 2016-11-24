package railway.web.commands.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import railway.entities.models.TrainModel;
import railway.services.train.ITrainManager;
import railway.services.train.TrainManagerImpl;
import railway.utils.props.RailwayProps;
import railway.web.commands.AbstractCommand;
import railway.web.validator.TrainValidator;

public class AddTrainCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		
		ITrainManager trainManager = new TrainManagerImpl();
		
		TrainModel trainModel = new TrainModel(request.getParameter("places"), 
				request.getParameter("price"),
				request.getParameter("depatureTime"), 
				request.getParameter("arrivalTime"), 
				request.getParameter("depatureStation"), 
				request.getParameter("arrivalStation"));
		
		TrainValidator trainValidator = new TrainValidator();
		
		Map<String,String> errors = trainValidator.getErrorMap(trainModel);
		
		if(errors.isEmpty()){
			long id = trainManager.addTrain(trainModel);
			if(id > 0)
				request.setAttribute("message", RailwayProps.getProperty("mess.train ") + " id: " + id);
			else request.setAttribute("message", RailwayProps.getProperty("mess.error.train"));
			return RailwayProps.getProperty("page.admin.main");
		}else{		
			request.setAttribute("errors", errors);
			return RailwayProps.getProperty("page.admin.go_to_add_train");
		}
	}
}
