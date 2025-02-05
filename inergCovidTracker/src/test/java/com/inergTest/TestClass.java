package com.inergTest;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import baseBrowser.Initialization;
import pageObject.HomePage;
import utilse.WebElementClass;

public class TestClass {

	/*
	 * Run each test before opening the browser and click the state. 
	 */

	@BeforeSuite
	public void init() {
		Initialization.setItUp("Goa");
	}

	/*
	 * validatation process
	 */

	@Test(priority = 1)
	public void validateHomepageTitle() throws InterruptedException {
		HomePage home=new HomePage();
		String title=home.getHomepageTitle();
		Assert.assertEquals(title, "InerG Test App");
		System.out.println("the title name is ;" +title);
	}

	/*
	 * Line chart repersentation and print the values at the points
	 */

	@Test(priority = 2)
	public void lineChartrepersentation() throws InterruptedException {
		HomePage linechartobj=new HomePage();
		linechartobj.linechart();
	}

	/*
	 * Leaflet clickable test script.
	 */

	@Test(priority = 3)
	public void leafletClickable() {
		HomePage leaflefn=new HomePage();
		leaflefn.leaflet();
	}

	/*
	 * OpenStreet clickable test script.
	 */

	@Test(priority = 4)
	public void openStreet() {
		HomePage openStreet=new HomePage();
		openStreet.openStreetMap();
	}

	/*
	 * After every test case passes, finally run the test script.
	 */

	@AfterSuite
	public void tearDown() {
		WebElementClass.teardown();
	}
}
