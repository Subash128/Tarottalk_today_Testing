package tarottalk.today.utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertieFileConfig {


	public static Properties config() {
		FileReader Location = null;
		Properties property = new Properties();
		try {
			Location = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\Testdata.properties");
			property.load(Location);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return property;
	}

}
