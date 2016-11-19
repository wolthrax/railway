package railway.dba.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBProperties {
	
public static String getProperty(String key){
		
		Properties props = new Properties();
		
		try(InputStream is = Queries.class.getResourceAsStream("/db.properties")){
			props.load(is);
		} catch (IOException e) {
			// TODO
		}
		
		return props.getProperty(key);
	}
}
