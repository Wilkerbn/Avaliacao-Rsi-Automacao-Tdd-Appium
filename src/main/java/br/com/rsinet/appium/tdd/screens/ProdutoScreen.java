package br.com.rsinet.appium.tdd.screens;

import org.openqa.selenium.WebElement;
import static br.com.rsinet.appium.tdd.suport.DriverFactory.getDriver;

public class ProdutoScreen {
	private static WebElement elemento = null;
	
	public static WebElement selecionaProduto(String texto) {
		elemento = getDriver().findElementByXPath("//*[@text='"+ texto +"']");
		return elemento;
	}
	
	public static String confirmaProdutoSelecionado(String texto) {
		WebElement produtoSelecionadoTexto = getDriver().findElementByXPath("//*[@text='"+ texto +"']");
		String produtoSelecionado = produtoSelecionadoTexto.getText();
		return produtoSelecionado;
	}
	
	public static String confirmaProdutoInvalidoSelecionado() {
		WebElement produtoSelecionadoTexto = getDriver().findElementById("com.Advantage.aShopping:id/textViewNoProductsToShow");
		String produtoInvalidoSelecionado = produtoSelecionadoTexto.getText();
		return produtoInvalidoSelecionado;
	}
	
	public static String confirmaProdutoEsgotado() {
		WebElement campoProdutoEsgotado = getDriver().findElementByXPath("//*[@text='SOLD OUT']");
		String textoProdutoEsgotado = campoProdutoEsgotado.getText();
		return textoProdutoEsgotado;
	}
	
	

}
