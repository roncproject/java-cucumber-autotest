package com.ysshha.autotest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	

	private static DriverFactory instance = new DriverFactory();
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();


	public static DriverFactory getInstance() {
 	   	return instance;
 	}


 	private DriverFactory() {

    	System.setProperty("webdriver.chrome.driver","C:\\dev\\tools\\selenium\\chromedriver.exe");
   	
   	}


 	public static WebDriver getDriver() {
        
        return new ChromeDriver();
    }

    // public static void setDriver(WebDriver driver) {
    //     driver.set(driver);
    // }

    public static void quit() {
        //driver.quit();
        //driver.remove();
    }



}