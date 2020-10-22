package com.ysshha.autotest;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;


public abstract class AbstractPage {

	private static final Logger logger = LogManager.getLogger(AbstractPage.class.getName());
	
	public static WebDriver driver;

	AbstractPage() {
		logger.info("AbstractPage.AbstractPage()");
		
		if (driver == null) {
			driver = DriverFactory.getInstance().getDriver();
		}
	
		initPage();
	}

	public void initPage() {
		logger.info("AbstractPage.initPage()");
 
		PageFactory.initElements(driver, this);
	}

	public void gotoUrl(String s) {
		logger.info("AbstractPage.gotoUrl(" + s + ")");

		this.driver.get(s);
		this.driver.manage().window().maximize();

	}

	public void checkTitle(String s) {
		logger.info("AbstractPage.checkTitle(" + s + ")");

		Assert.assertEquals(this.driver.getTitle(), s);
	}

	public void checkUrl(String s) {
		logger.info("AbstractPage.checkUrl(" + s + ")");

		Assert.assertEquals(this.driver.getCurrentUrl(), s);
	}

	public WebElement searchElementText(String s) {
		logger.info("AbstractPage.searchElementText(" + s + ")");

		String[] parts = { "//*[text()=\"" , s , "\"]"} ;
		
		String xpath_string = String.join("", parts);

		System.out.println ("xpath: " + xpath_string);

		WebElement searchResult = driver.findElement(By.xpath(xpath_string));

		return searchResult;
	}

	public void refreshPage() {
		logger.info("AbstractPage.refreshPage()");

			this.driver.navigate().refresh();

	}
	public void closePage() {
		logger.info("AbstractPage.closePage()");

		this.driver.close();
		this.driver.quit();
		driver = DriverFactory.getInstance().getDriver();
	}
}