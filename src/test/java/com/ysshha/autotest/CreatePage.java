package com.ysshha.autotest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class CreatePage extends AbstractPage {
	
	private static final Logger logger = LogManager.getLogger(CreatePage.class);
	
	@FindBy(linkText="Create")
	WebElement gotoCreateButton;
	@FindBy(name="cardNumber")
	WebElement cardInput;
	@FindBy(name="passNumber")
	WebElement passInput;
	@FindBy(name="amount")
	WebElement amountInput;	
	@FindBy(xpath="//button[text()[contains(.,\" Create \")]]")
	WebElement createButton;

	// CreatePage() {		
	// 	logger.info("CreatePage.CreatePage()");

	// }

	public void checkPage()  {
		logger.info("CreatePage.checkPage()");
	
	}

	public void enterOrder(String card, String pass, String amount) {
		logger.info("CreatePage.enterOrder(" + card + "," + pass + "," + amount + ")");

		gotoCreateButton.click();
		cardInput.sendKeys(card);
		passInput.sendKeys(pass);
		amountInput.sendKeys(amount);
	}

	public void createButtonDisabled() {
		logger.info("CreatePage.createButtonDisabled");

		Assert.assertFalse(createButton.isEnabled());
	}

	public void createButtonEnabled() {
		logger.info("CreatePage.createButtonEnabled");

		Assert.assertTrue(createButton.isEnabled());
	}

	public void clickCreateButton() {
		logger.info("CreatePage.clickCreateButton");

		createButton.click();		
	}


}	