package com.ysshha.autotest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class OrderPage extends AbstractPage {
	
	private static final Logger logger = LogManager.getLogger(CreatePage.class);

	@FindBy(xpath="//h2[@class=\"panel-title\" and contains(text(), \"Orders\")]")
	WebElement orderListTitle;
	@FindBy(linkText="Create")
	WebElement gotoCreateButton;
	@FindBy(xpath="//*[text()=\"Card number\"]")
	WebElement orderListCategoryCardnumber;
	@FindBy(xpath="//*[text()=\"Pass number\"]")
	WebElement orderListCategoryPassnumber;
	@FindBy(xpath="//*[text()=\"Amount\"]")
	WebElement orderListCategoryAmount;
	@FindBy(xpath="//*[text()=\"Status\"]")
	WebElement orderListCategoryStatus;

	public void checkPage()  {
		logger.info("OrderPage.checkPage()");

		Assert.assertTrue(orderListTitle.isDisplayed());
		Assert.assertTrue(gotoCreateButton.isDisplayed());
		Assert.assertTrue(orderListCategoryCardnumber.isDisplayed());
		Assert.assertTrue(orderListCategoryPassnumber.isDisplayed());
		Assert.assertTrue(orderListCategoryAmount.isDisplayed());
		Assert.assertTrue(orderListCategoryStatus.isDisplayed());
	}

	public void checkOrderAmount(int i) {
		logger.info("OrderPage.checkOrderAmount(" + i + " )");

		String empty = "//div[@class=\"panel panel-primary\"]/div[2]/table/tbody/tr/td";
		int num = driver.findElements(By.xpath(empty)).size();
		int amount;
		if (num <= 0) {
			amount = 0;
		} else {
			amount = num / 5;
		}
		logger.info("OrderPage.checkListEmpty() => empty => [" + empty + "]");
		logger.info("OrderPage.checkListEmpty() => num => [" + num + "]");
		logger.info("OrderPage.checkListEmpty() => amount => [" + amount + "]");


		Assert.assertTrue(i == amount);

	}

	public void checkOrderExist(int line, String card, String Pass, String Amount, String status) {

		// TODO
	}

	public void gotoCreatePage() {
		logger.info("gotoCreatePage()");

		gotoCreateButton.click();		
	}

}	