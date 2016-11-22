package railway.utils.props;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import railway.utils.logger.RailwayLogger;

public class RailwayProps {
	public static String getProperty(String key){
		
		String typeOfProperty = key.substring(0, key.indexOf('.')).trim();	
		
		String path = null;
		
		if(typeOfProperty.equals("query"))
			path = "/queries.properties";
			
		else if(typeOfProperty.equals("db"))
			path = "/db.properties";
			
		else if(typeOfProperty.equals("page"))
			path = "/pages.properties";
			
		else if(typeOfProperty.equals("regex"))
			path = "/regexp.properties";
		
		else if(typeOfProperty.equals("mess"))
			path = "/messages.properties";
		
		Properties props = new Properties();
		
		try(InputStream is = RailwayProps.class.getResourceAsStream(path)){
			props.load(is);
		} catch (IOException e) {
			RailwayLogger.logError(RailwayProps.class, e.getMessage());
		}
		
		return props.getProperty(key);
	}
}
