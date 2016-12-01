package railway.web.validator;

import java.util.HashMap;
import java.util.Map;

import railway.entities.models.UserModel;
import railway.utils.props.RailwayProps;

public class UserValidator extends Validator{

public Map<String,String> getErrorMap(UserModel user){
		
		Map<String, String> errorMap = new HashMap<>();
		
		if(checkRegexp(user.getLogin(), RailwayProps.getProperty("regex.user.login")))
			errorMap.put("login", RailwayProps.getProperty("mess.error.user.login"));
		
		if(user.getPassword1().equals(user.getPassword2())){
			if(checkRegexp(user.getPassword1(), RailwayProps.getProperty("regex.user.password")))
				errorMap.put("password", RailwayProps.getProperty("mess.error.user.password"));
		} else errorMap.put("password", RailwayProps.getProperty("mess.error.user.password.not_match"));
		
		if(checkRegexp(user.getName(), RailwayProps.getProperty("regex.user.name")))
			errorMap.put("name", RailwayProps.getProperty("mess.error.user.name"));
		
		if(checkRegexp(user.getSurname(), RailwayProps.getProperty("regex.user.surname")))
			errorMap.put("surname", RailwayProps.getProperty("mess.error.user.surname"));
		
		if(checkRegexp(user.getEmail(), RailwayProps.getProperty("regex.user.email")))
			errorMap.put("email", RailwayProps.getProperty("mess.error.user.email"));
		
		if(checkRegexp(user.getPhone(), RailwayProps.getProperty("regex.user.phone")))
			errorMap.put("phone", RailwayProps.getProperty("mess.error.user.phone"));
		
		return errorMap;	
	}
	
}
