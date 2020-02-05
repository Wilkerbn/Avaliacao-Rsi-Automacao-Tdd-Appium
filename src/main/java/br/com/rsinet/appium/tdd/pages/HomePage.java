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
