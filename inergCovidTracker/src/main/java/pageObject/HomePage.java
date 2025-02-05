package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseBrowser.Initialization;

public class HomePage extends Initialization{
	WebDriverWait wait=null;

	/*
	 * Expicity wait 
	 */
	public HomePage() {
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	/*
	 * Getting title 
	 */
	public String getHomepageTitle() {
		return driver.getTitle();
	}

	/*
	 * Line chart repersentation fuction
	 */

	public void linechart() throws InterruptedException {
		Thread.sleep(3000);

		By line = By.xpath("//*[local-name()='svg']//*[name()='g' and @class='points']");

		By toolTip = By.xpath("//*[local-name()='svg']//*[name()='g' and @class='hovertext']");

		List<WebElement> lineList = driver.findElements (line);

		System.out.println("total lines in the graph:" + lineList.size());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[@title='Zoom in']")));
		Actions act = new Actions (driver);

		for (WebElement ele: lineList) {

			act.moveToElement(ele).perform();

			String text = driver.findElement(toolTip).getText();

			System.out.println(text);
		}
	}


	/*
	 * Leaflet clickable function
	 */	
	public void leaflet() {
		WebElement element = driver.findElement(By.xpath("//a[text()=' Leaflet']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
		driver.navigate().back();
	}

	/*
	 * Openstreetmap clickable function
	 */

	public void openStreetMap() {
		WebElement element = driver.findElement(By.xpath("//a[text()='OpenStreetMap']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
		driver.navigate().back();
	}
}

