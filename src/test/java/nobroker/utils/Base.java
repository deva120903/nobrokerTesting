package nobroker.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	static final int TIME=1000;
	public static WebDriver driver;

	public void lanchBrowser() {

		Properties prop = PropertyReader.readProperties();

		if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			Map<String, Object> chromePrefs = new HashMap<>();
			chromePrefs.put("credentials_enable_service", false);
			// chromePrefs.put("profile.password_manager_enabled", false);
			chromePrefs.put("profile.password_manager_leak_detection", false);
			chromeOptions.setExperimentalOption("prefs", chromePrefs);

			// Initialize ChromeDriver with the configured options
			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
		}
		
		else if(prop.getProperty("Browser").equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		driver.get(prop.getProperty("URL"));
	}
	public static void sleep(){
		sleep(TIME);
	}public static void sleep(int millis) {
	    try {
	        Thread.sleep(millis);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
}
