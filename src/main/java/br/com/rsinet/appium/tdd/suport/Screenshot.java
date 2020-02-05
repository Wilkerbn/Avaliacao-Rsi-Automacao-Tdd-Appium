package br.com.rsinet.appium.tdd.suport;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;

public class Screenshot {
	public static String tirar(String arquivo) {
		File screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		String caminho = System.getProperty("user.dir") + "/target/screenshot/" + arquivo + "-"
				+ Generator.dataHoraParaArquivo() + ".png";
		try {
			FileUtils.copyFile(screenshot, new File(caminho));
		} catch (Exception e) {
			System.out.println("Houveram problemas ao copiar o arquivo para a pasta" + e.getMessage());
		}
		return caminho;

	}
}
