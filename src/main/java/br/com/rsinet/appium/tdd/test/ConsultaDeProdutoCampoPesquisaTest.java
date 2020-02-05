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

import br.com.rsinet.appium.tdd.pages.HomePage;
import br.com.rsinet.appium.tdd.pages.ProdutoPage;
import br.com.rsinet.appium.tdd.suport.DriverFactory;
import br.com.rsinet.appium.tdd.utility.Constant;
import br.com.rsinet.appium.tdd.utility.Report;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ConsultaDeProdutoCampoPesquisaTest {
	
	public static AndroidDriver<MobileElement> driver;
	public ExtentTest test;
	public ExtentReports extent;
	
	@BeforeMethod
	public void inicializa() throws Exception {
		driver = DriverFactory.getDriver();
		Constant.recebeDadosDoExcel("Produtos");

	}
	
	@BeforeTest
	public void criarRelatorio() {
		extent = Report.setExtent();
	}

	@Test
	public void consultaProdutoLupa() throws Exception  {
		test = Report.setUp("consultaProdutoLupa");
		
		HomePage.campoDePesquisa().sendKeys("LAPTOPS");
		HomePage.lupaParaPesquisarProdutoInserido().click();
		ProdutoPage.selecionaProduto("HP PAVILION 15T TOUCH LAPTOP").click();
		Assert.assertEquals("HP PAVILION 15T TOUCH LAPTOP", ProdutoPage.confirmaProdutoSelecionado("HP PAVILION 15T TOUCH LAPTOP"));
	
	}
	
	@Test
	public void consultaProdutoLupaInvalido() throws Exception  {
		test = Report.setUp("consultaProdutoLupaInvalido");
		
		HomePage.campoDePesquisa().sendKeys("Video Game");
		HomePage.lupaParaPesquisarProdutoInserido().click();
		Assert.assertTrue(ProdutoPage.confirmaProdutoInvalidoSelecionado().contains("No results for"));
		System.out.println(ProdutoPage.confirmaProdutoInvalidoSelecionado());
	}
	
	@AfterMethod
	public void finaliza(ITestResult result) throws IOException {
		Report.tearDown(result, test);
		Report.closeReport(extent);
		DriverFactory.killDriver();
	}
}
