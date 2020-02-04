package br.com.rsinet.appium.tdd.pages;

import static br.com.rsinet.appium.tdd.suport.DriverFactory.getDriver;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;

public class HomePage {
	private static WebElement elemento = null;
	
	public static WebElement menuLateral() throws Exception {
		Thread.sleep(5000);
		elemento = getDriver().findElementById("com.Advantage.aShopping:id/imageViewMenu");
		return elemento;
	}

	public static WebElement botaoLogin() {
		elemento = getDriver().findElementById("com.Advantage.aShopping:id/linearLayoutLogin");
		return elemento;
	}

	

	

	
}
