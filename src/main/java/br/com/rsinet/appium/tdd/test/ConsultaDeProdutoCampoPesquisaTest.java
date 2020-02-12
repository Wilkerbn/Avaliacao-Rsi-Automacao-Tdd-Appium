package br.com.rsinet.appium.tdd.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.appium.tdd.screens.HomeScreen;
import br.com.rsinet.appium.tdd.screens.ProdutoScreen;
import br.com.rsinet.appium.tdd.suport.DriverFactory;
import br.com.rsinet.appium.tdd.utility.Constant;
import br.com.rsinet.appium.tdd.utility.Report;

public class ConsultaDeProdutoCampoPesquisaTest {

	private ExtentTest test;
	private ExtentReports extent;
	
	@BeforeMethod
	public void inicializa() throws Exception {
		DriverFactory.getDriver();
		Constant.recebeDadosDoExcel("Produtos");
	}
	
	@BeforeTest
	public void criarRelatorio() {
		extent = Report.setExtent();
	}

	@Test
	public void consultaProdutoLupa() throws Exception  {
		test = Report.setUp("consultaProdutoLupa");
		
		HomeScreen.campoDePesquisa().sendKeys("LAPTOPS");
		HomeScreen.lupaParaPesquisarProdutoInserido().click();
		ProdutoScreen.selecionaProduto("HP PAVILION 15T TOUCH LAPTOP").click();
		Assert.assertEquals("HP PAVILION 15T TOUCH LAPTOP", ProdutoScreen.confirmaProdutoSelecionado("HP PAVILION 15T TOUCH LAPTOP"));
	}
	
	@Test
	public void consultaProdutoLupaInvalido() throws Exception  {
		test = Report.setUp("consultaProdutoLupaInvalido");
		
		HomeScreen.campoDePesquisa().sendKeys("Video Game");
		HomeScreen.lupaParaPesquisarProdutoInserido().click();
		Assert.assertTrue(ProdutoScreen.confirmaProdutoInvalidoSelecionado().contains("No results for"));
	}
	
	@AfterMethod
	public void finaliza(ITestResult result) throws IOException {
		Report.tearDown(result, test);
		Report.closeReport(extent);
		DriverFactory.killDriver();
	}
}
