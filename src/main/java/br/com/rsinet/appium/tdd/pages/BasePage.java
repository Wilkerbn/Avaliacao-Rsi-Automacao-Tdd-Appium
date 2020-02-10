package br.com.rsinet.appium.tdd.pages;
import static br.com.rsinet.appium.tdd.suport.DriverFactory.getDriver;

import org.openqa.selenium.Dimension;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage{
	
	public static void scrollDown(double inicio, double fim) {
	       
        Dimension size = getDriver().manage().window().getSize();
       
        int x = size.width / 2;
       
        int yInicial = (int) (size.height * inicio);
        int yFinal = (int) (size.height * fim);
       
        new TouchAction(getDriver())
        .press(PointOption.point(x, yInicial))
        .waitAction()
        .moveTo(PointOption.point(x, yFinal))
        .release().perform();
    }
	
//	public static TouchAction scrollNoForm() {
//		TouchAction scroll = new TouchAction(getDriver());
//		scroll.press(PointOption.point(1059, 1698)).moveTo(PointOption.point(1059, 300)).perform();
//		return scroll;
//	}
	
}