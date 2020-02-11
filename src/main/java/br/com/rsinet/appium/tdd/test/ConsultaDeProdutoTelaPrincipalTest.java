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
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ConsultaDeProdutoTelaPrincipalTest {
	
	private static AndroidDriver<MobileElement> driver;
	private ExtentTest test;
	private ExtentReports extent;
	
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
		
		HomeScreen.categoriaDeProdutosTelaPrincipal("LAPTOPS").click();
		ProdutoScreen.selecionaProduto("HP CHROMEBOOK 14 G1(ES)").click();
		Assert.assertEquals("HP CHROMEBOOK 14 G1(ES)", ProdutoScreen.confirmaProdutoSelecionado("HP CHROMEBOOK 14 G1(ES)"));
	}
	
	@Test
	public void consultaProdutoTelaPrincipalEsgotado() {
		test = Report.setUp("consultaProdutoTelaPrincipalEsgotado");
		
		HomeScreen.categoriaDeProdutosTelaPrincipal("HEADPHONES").click();
		ProdutoScreen.selecionaProduto("BOSE SOUNDLINK AROUND-EAR WIRELESS HEADPHONES II").click();
		Assert.assertTrue(ProdutoScreen.confirmaProdutoEsgotado().contains("SOLD OUT"));		
	}
	
	
	@AfterMethod
	public void finaliza(ITestResult result) throws IOException {
		Report.tearDown(result, test);
		Report.closeReport(extent);
		DriverFactory.killDriver();
	}

}
