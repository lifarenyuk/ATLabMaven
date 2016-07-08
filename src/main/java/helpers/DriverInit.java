package helpers;

import org.openqa.selenium.WebDriver;

public class DriverInit {

	WebDriver driver;

	public void initDriver(String driver, String url) {
		if (driver.equalsIgnoreCase("firefox")) {
			
		} else if (driver.equalsIgnoreCase("chrome")) {

		} else if (driver.equalsIgnoreCase("IE")) {

		}
	}
}
