package baseBrowser;

import org.openqa.selenium.WebDriver;

public class Initialization{

	protected static WebDriver driver;	

	/*
	 * Browser setup function and call the state. 
	 */
	public static void setItUp(String state) {
		driver =Browser.getBrowser("Chrome");
		String URL = "https://inerg-test.web.app/";
		driver.get(URL);
		Browser.selectState(state);
	}
}

