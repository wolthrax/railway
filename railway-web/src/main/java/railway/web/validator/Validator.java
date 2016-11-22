package railway.web.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import railway.utils.props.RailwayProps;

public class Validator {

	boolean checkRegexp(String str){
		
		Pattern pattern = Pattern.compile(RailwayProps.getProperty("regex.station.name"));
		Matcher matcher = pattern.matcher(str);
		
		return !matcher.matches();
	}
	
}
