package Linkdin;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;

	public static Properties getProperties() {
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream ip = new FileInputStream(
						"C:\\Users\\pooja\\OneDrive\\Desktop\\SeleniumProject\\SeleniumPractise\\src\\main\\java\\config.properties");
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}
}
