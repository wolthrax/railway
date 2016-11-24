package railway.web.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	boolean checkRegexp(String value, String regex){
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		
		return !matcher.matches();
	}
	
}
