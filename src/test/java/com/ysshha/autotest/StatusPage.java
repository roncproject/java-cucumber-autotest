package com.ysshha.autotest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


public class StatusPage extends AbstractPage {

	private static final Logger logger = LogManager.getLogger(StatusPage.class);

	@FindBy(xpath="//h2[@class=\"panel-title\" and contains(text(), \"Order\")]")
	WebElement orderListTitle;
	@FindBy(xpath="//a[@class=\"btn btn-default pull-right\" and contains(text(), \"Back\")]")
	WebElement backButton;
//	@FindBy(xpath="//a[text()[contains(.,\"Back\")] and @class = \"btn btn-default pull-right\"]")
//	WebElement backButton;


//	StatusPage() {
//		logger.info("StatusPage.StatusPage()");
//	}

	public void checkPage()  {
		logger.info("StatusPage.checkPage()");

	//	Assert.assertTrue(orderListTitle.isDisplayed());
		Assert.assertTrue(backButton.isDisplayed());
	}

	public void goBackToList() {
		logger.info("StatusPage.goBackToList");

		backButton.click();
	}



}	