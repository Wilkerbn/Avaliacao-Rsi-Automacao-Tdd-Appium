package br.com.rsinet.appium.tdd.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestXiaomi {
	
	@Test
	public void test() throws MalformedURLException {
	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

	 

    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("deviceName", "2a32194acc16");
//    desiredCapabilities.setCapability("appPackage", "com.Advantage.aShopping");
//    desiredCapabilities.setCapability("appActivity", "com.Advantage.aShopping.SplashActivity");
    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\wilker.nogueira\\eclipse-workspace-automacao\\appium-advantage\\src\\main\\resources\\apk\\Advantage+demo+2_0.apk");
    
    AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
