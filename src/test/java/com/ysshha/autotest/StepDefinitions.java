package com.ysshha.autotest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;
import io.cucumber.java.After;


public class StepDefinitions {

	private static final Logger logger = LogManager.getLogger(StepDefinitions.class);

	OrderPage orderPage;
	CreatePage createPage;
	StatusPage statusPage;

    @Before
    public void setUp() throws Throwable {
		logger.info("StepDefinitions.setUp()");

	}
	
	@Given("I start browser")
	public void I_start_browser() {
		logger.info("StepDefinitions.I_start_browser()");

		orderPage = new OrderPage();	
	}


	@When("I load url {string}")
	public void I_load_url(String s) {
		logger.info("StepDefinitions.I_load_url(" + s + ")");

		orderPage.gotoUrl(s);
		orderPage.checkUrl(s);
	}


	@Then("I see page {string}")
	public void I_see_page(String s) {
		logger.info("StepDefinitions.I_see_page(" + s + ")");

		orderPage.checkTitle(s);
	}

	@When("I refresh Homepage")
	public void I_refresh_homepage() {
		logger.info("StepDefinitions.I_refresh_homepage()");
		orderPage.refreshPage();
	}
	@When("I check Homepage")
	public void I_check_page() {
		logger.info("StepDefinitions.I_check_page()");

		orderPage.checkPage();
	}

	@When("I see that the list has {int} orders")
	public void I_see_that_the_list_has_int_orders(int arg1) {
		logger.info("StepDefinitions.I_see_that_the_list_has_int_orders()");

		//orderPage.checkPage();
		orderPage.checkOrderAmount(arg1);
	}


	@When("I fill in an order with Card: {string} , Pass: {string} , for Amount: {string}")
	public void I_create_order(String arg1, String arg2, String arg3) {
		logger.info("StepDefinitions.I_create_order(" + arg1 + "," + arg2 + "," + arg3 + ")");

		createPage = new CreatePage();
		createPage.enterOrder(arg1, arg2, arg3);	
	}


	@Then("I see Create is disabled") 
	public void I_see_create_is_disabled() {
		logger.info("StepDefinitions.I_see_create_is_disabled()");

		createPage.createButtonDisabled();
	}

	@Then("I see Create is enabled") 
	public void I_see_create_is_enabled() {
		logger.info("StepDefinitions.I_see_create_is_enabled()");

		createPage.createButtonEnabled();
	}

	@When("I push Create")
	public void i_push_create() {
		logger.info("StepDefinitions.i_push_create()");

		createPage.clickCreateButton();
		statusPage = new StatusPage();
	}


	@Then("I see the Status page")
	public void I_see_the_Status_page() {

		statusPage.checkPage();
	}


	@Then("I go back to the Order list")
	public void I_go_back_to_the_Order_list() {

		statusPage.goBackToList();
	}

	@Then("I close page")
	public void I_close_page() {

		orderPage.closePage();
	}


	@After
    public void tearDown() throws Throwable {
		logger.info("StepDefinitions.tearDown()");

		//orderPage.closePage();
	}

}

