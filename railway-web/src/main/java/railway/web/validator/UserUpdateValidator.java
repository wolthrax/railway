package railway.web.validator;

import java.util.HashMap;
import java.util.Map;

import railway.entities.models.UserModel;
import railway.utils.props.RailwayProps;

public class UserUpdateValidator extends Validator{
	
public Map<String,String> getErrorMap(UserModel user){
		
		Map<String, String> errorMap = new HashMap<>();
		
		if(!user.getPassword1().equals("") && !user.getPassword2().equals("")){
			if(user.getPassword1().equals(user.getPassword2())){
				if(checkRegexp(user.getPassword1(), RailwayProps.getProperty("regex.user.password")))
					errorMap.put("password", RailwayProps.getProperty("mess.error.user.password"));
			} else errorMap.put("password", RailwayProps.getProperty("mess.error.user.password.not_match"));
		}
		
		if(!user.getName().equals("")){
			if(checkRegexp(user.getName(), RailwayProps.getProperty("regex.user.name")))
				errorMap.put("name", RailwayProps.getProperty("mess.error.user.name"));
		}
		
		if(!user.getSurname().equals("")){
			if(checkRegexp(user.getSurname(), RailwayProps.getProperty("regex.user.surname")))
				errorMap.put("surname", RailwayProps.getProperty("mess.error.user.surname"));
		}
		
		if(!user.getEmail().equals("")){
			if(checkRegexp(user.getEmail(), RailwayProps.getProperty("regex.user.email")))
				errorMap.put("email", RailwayProps.getProperty("mess.error.user.email"));
		}
		
		if(!user.getPhone().equals("")){
			if(checkRegexp(user.getPhone(), RailwayProps.getProperty("regex.user.phone")))
				errorMap.put("phone", RailwayProps.getProperty("mess.error.user.phone"));
		}
		
		if(!user.getMoney().equals("")){
			if(checkRegexp(user.getMoney(), RailwayProps.getProperty("regex.train.price")))
				errorMap.put("money", RailwayProps.getProperty("mess.error.user.money"));
		}
		
		return errorMap;	
	}

}
