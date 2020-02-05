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

public class ConsultaDeProdutoTelaPrincipalTest {
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
	public void consultaProdutoTelaPrincipal() {
		test = Report.setUp("consultaProdutoTelaPrincipal");
		
		HomePage.categoriaDeProdutosTelaPrincipal("LAPTOPS").click();
		ProdutoPage.selecionaProduto("HP CHROMEBOOK 14 G1(ES)").click();
		Assert.assertEquals("HP CHROMEBOOK 14 G1(ES)", ProdutoPage.confirmaProdutoSelecionado("HP CHROMEBOOK 14 G1(ES)"));
	}
	
	@Test
	public void consultaProdutoTelaPrincipalEsgotado() {
		test = Report.setUp("consultaProdutoTelaPrincipalEsgotado");
		
		HomePage.categoriaDeProdutosTelaPrincipal("HEADPHONES").click();
		ProdutoPage.selecionaProduto("BOSE SOUNDLINK AROUND-EAR WIRELESS HEADPHONES II").click();
		Assert.assertTrue(ProdutoPage.confirmaProdutoEsgotado().contains("SOLD OUT"));		
	}
	
	
	@AfterMethod
	public void finaliza(ITestResult result) throws IOException {
		Report.tearDown(result, test);
		Report.closeReport(extent);
		DriverFactory.killDriver();
	}

}
