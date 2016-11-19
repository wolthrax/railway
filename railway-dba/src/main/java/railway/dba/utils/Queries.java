package railway.dba.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Queries {
	 

	public static String getQuery(String key){
		
		Properties props = new Properties();
		
		try(InputStream is = Queries.class.getResourceAsStream("/queries.properties")){
			props.load(is);
		} catch (IOException e) {
			// TODO
		}
		
		return props.getProperty(key);
	}
}