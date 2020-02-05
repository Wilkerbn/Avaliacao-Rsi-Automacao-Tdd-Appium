package br.com.rsinet.appium.tdd.suport;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory  {
	
	private static AndroidDriver<MobileElement> driver;
	
	public static AndroidDriver<MobileElement> getDriver() {
		if(driver==null) {
			createDriver();
		}
		return driver;
	}

	
	private static void createDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
//		desiredCapabilities.setCapability("platformName", "Android");
//		desiredCapabilities.setCapability("deviceName", "2a32194acc16");
//		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.Advantage.aShopping");
		desiredCapabilities.setCapability("appActivity", "com.Advantage.aShopping.SplashActivity");
		desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
//		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\wilker.nogueira\\eclipse-workspace-automacao\\appium-advantage\\src\\main\\resources\\apk\\Advantage+demo+2_0.apk");
		desiredCapabilities.setCapability("unicodeKeyboard", true);   
		desiredCapabilities.setCapability("resetKeyboard", true);

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void killDriver() {
		if(driver !=null) {
			driver.quit();
			driver = null;
		}
	}

}
