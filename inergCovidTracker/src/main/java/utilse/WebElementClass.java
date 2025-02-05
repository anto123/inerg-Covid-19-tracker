package utilse;

import baseBrowser.Initialization;

public class WebElementClass extends Initialization {

	/*
	 * quit declare function
	 */

	public static void teardown() {
		driver.quit();
	}

}