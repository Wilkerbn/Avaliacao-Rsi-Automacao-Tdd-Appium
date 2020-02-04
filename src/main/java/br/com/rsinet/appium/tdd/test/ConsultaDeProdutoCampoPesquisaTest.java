package br.com.rsinet.appium.tdd.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ConsultaDeProdutoCampoPesquisaTest {
	

	@Test
	public void consultaProdutoValidoLupa() throws MalformedURLException, Exception {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "2a32194acc16");
//	    desiredCapabilities.setCapability("automationName", "uiautomator2");
//	    desiredCapabilities.setCapability("appPackage", "com.Advantage.aShopping");
//	    desiredCapabilities.setCapability("appActivity", "com.Advantage.aShopping.SplashActivity");
	    //desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
	    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\wilker.nogueira\\eclipse-workspace-automacao\\appium-advantage\\src\\main\\resources\\apk\\Advantage+demo+2_0.apk");
	    

	AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	
	
	Thread.sleep(2000);
	driver.findElementById("com.Advantage.aShopping:id/imageViewMenu").click();
	}
}
