package br.com.rsinet.appium.tdd.screens;

import static br.com.rsinet.appium.tdd.suport.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;

public class HomeScreen {
	private static WebElement elemento = null;
	
	public static MobileElement menuLateral() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.Advantage.aShopping:id/imageViewMenu")));
    }

	public static WebElement botaoLogin() {
		elemento = getDriver().findElementById("com.Advantage.aShopping:id/linearLayoutLogin");
		return elemento;
	}
	
	public static String usuarioCadastrado() {
		WebElement textoUsuarioCadastrado = getDriver().findElementByXPath("//android.support.v4.widget.DrawerLayout[@content-desc=\"Main Menu\"]/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]\r\n");
		String usuarioCadastrado = textoUsuarioCadastrado.getText();
		return usuarioCadastrado;
	}
	
	public static WebElement campoDePesquisa() {
		elemento = getDriver().findElementById("com.Advantage.aShopping:id/editTextSearch");
		return elemento; 
	}
	
	public static WebElement lupaParaPesquisarProdutoInserido() {
		elemento = getDriver().findElementById("com.Advantage.aShopping:id/imageViewSearch");
		return elemento;
	}

	public static WebElement categoriaDeProdutosTelaPrincipal(String categoria) {
		elemento = getDriver().findElementByXPath("//*[@text='"+ categoria +"']");
		return elemento;
	}
	

	

	
}
