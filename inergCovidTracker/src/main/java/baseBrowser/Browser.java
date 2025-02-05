package baseBrowser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Browser {
	static WebDriver driver = null;
	private Browser() {

	}

	/*
	 * multiple browser declared function
	 */

	protected static WebDriver getBrowser(String browserName) {

		switch (browserName) {
		case "Firefox":
			if (driver == null) {
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}
			break;
		case "Edge":
			if (driver == null) {
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));
			}
			break;
		case "Chrome":
			if (driver == null) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));
				driver.manage().deleteAllCookies();
			}
			break;
		}
		return driver;
	}

	/*
	 * Select the state using the 'Select' class in the base class.
	 */
	
	protected static void selectState(String statename) {
		WebElement statesElement = driver.findElement(By.cssSelector(".data-filter-input"));
		Select select = new Select(statesElement);
		select.selectByVisibleText(statename);
		String text=select.getFirstSelectedOption().getText();
		System.out.println("Selected state :" +text);
	}
}

