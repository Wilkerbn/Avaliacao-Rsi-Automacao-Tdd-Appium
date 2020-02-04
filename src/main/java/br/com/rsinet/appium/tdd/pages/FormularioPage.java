package br.com.rsinet.appium.tdd.pages;

import static br.com.rsinet.appium.tdd.suport.DriverFactory.getDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class FormularioPage {
	
	private static WebElement elemento = null;
	
	public static WebElement campoApelido() throws Exception {
		elemento = getDriver().findElementByXPath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText");
		return elemento;
	}
	
	public static WebElement campoEmail() {
		elemento = getDriver().findElementByXPath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText\r\n");
		return elemento;
	}
	
	public static WebElement campoSenha() {
		elemento = getDriver().findElementByXPath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText\r\n");
		return elemento;
	}
	
	public static WebElement campoConfirmaSenha() {
		elemento = getDriver().findElementByXPath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText\r\n");
		return elemento;
	}
	
	public static WebElement campoNome() {
		getDriver().hideKeyboard();
		elemento = getDriver().findElementByXPath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText\r\n");
		TouchAction scroll = new TouchAction(getDriver());
		scroll.press(PointOption.point(708, 917)).moveTo(PointOption.point(703, 133)).perform();
		getDriver().hideKeyboard();
		return elemento;
		
	}
	
	

}