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

import br.com.rsinet.appium.tdd.pages.FormularioPage;
import br.com.rsinet.appium.tdd.pages.HomePage;
import br.com.rsinet.appium.tdd.pages.LoginPage;
import br.com.rsinet.appium.tdd.suport.DriverFactory;
import br.com.rsinet.appium.tdd.utility.Constant;
import br.com.rsinet.appium.tdd.utility.Report;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CadastroDeUsuarioTest {

	public static AndroidDriver<MobileElement> driver;
	public ExtentTest test;
	public ExtentReports extent;

	@BeforeMethod
	public void inicializa() throws Exception {
		driver = DriverFactory.getDriver();
		Constant.recebeDadosDoExcel("Cadastro");

	}

	@BeforeTest
	public void criarRelatorio() {
		extent = Report.setExtent();
	}

	@Test
	public void deveCadastrarUsuario() throws Exception {
		test = Report.setUp("deveCadastrarUsuario");

		HomePage.menuLateral().click();
		HomePage.botaoLogin().click();
		LoginPage.botaoCriarNovaConta().click();
		FormularioPage.campoApelido().click();
		FormularioPage.campoApelido().sendKeys(Constant.apelido());
		FormularioPage.campoEmail().click();
		FormularioPage.campoEmail().sendKeys(Constant.email());
		FormularioPage.campoSenha().click();
		FormularioPage.campoSenha().sendKeys(Constant.senha());
		FormularioPage.campoConfirmaSenha().click();
		FormularioPage.campoConfirmaSenha().sendKeys(Constant.confirmaSenha());
		FormularioPage.campoNome().click();
		FormularioPage.campoNome().sendKeys(Constant.primeiroNome());
		FormularioPage.campoUltimoNome().click();
		FormularioPage.campoUltimoNome().sendKeys(Constant.ultimoNome());
		FormularioPage.scrollNoForm();
		FormularioPage.campoTelefone().click();
		FormularioPage.campoTelefone().sendKeys(Constant.telefone());
		FormularioPage.campoPais().click();
		FormularioPage.selecionaPais(driver, Constant.pais());
		FormularioPage.campoEstado().click();
		FormularioPage.campoEstado().sendKeys(Constant.estado());
		FormularioPage.campoEndereco().click();
		FormularioPage.campoEndereco().sendKeys(Constant.endereco());
		FormularioPage.campoCidade().click();
		FormularioPage.campoCidade().sendKeys(Constant.cidade());
		FormularioPage.campoCep().click();
		FormularioPage.campoCep().sendKeys(Constant.cep());
		FormularioPage.botaoParaRegistrar().click();
		HomePage.menuLateral().click();
		Assert.assertEquals(Constant.apelido(), HomePage.usuarioCadastrado());
	}

	@Test
	public void deveTentarCadastrarUsuarioJaExistente() throws Exception {
		test = Report.setUp("deveTentarCadastrarUsuarioJaExistente");

		HomePage.menuLateral().click();
		HomePage.botaoLogin().click();
		LoginPage.botaoCriarNovaConta().click();
		FormularioPage.campoApelido().click();
		FormularioPage.campoApelido().sendKeys(Constant.apelido());
		FormularioPage.campoEmail().click();
		FormularioPage.campoEmail().sendKeys(Constant.email());
		FormularioPage.campoSenha().click();
		FormularioPage.campoSenha().sendKeys(Constant.senha());
		FormularioPage.campoConfirmaSenha().click();
		FormularioPage.campoConfirmaSenha().sendKeys(Constant.confirmaSenha());
		FormularioPage.campoNome().click();
		FormularioPage.campoNome().sendKeys(Constant.primeiroNome());
		FormularioPage.campoUltimoNome().click();
		FormularioPage.campoUltimoNome().sendKeys(Constant.ultimoNome());
		FormularioPage.scrollNoForm();
		FormularioPage.campoTelefone().click();
		FormularioPage.campoTelefone().sendKeys(Constant.telefone());
		FormularioPage.campoPais().click();
		FormularioPage.selecionaPais(driver, Constant.pais());
		FormularioPage.campoEstado().click();
		FormularioPage.campoEstado().sendKeys(Constant.estado());
		FormularioPage.campoEndereco().click();
		FormularioPage.campoEndereco().sendKeys(Constant.endereco());
		FormularioPage.campoCidade().click();
		FormularioPage.campoCidade().sendKeys(Constant.cidade());
		FormularioPage.campoCep().click();
		FormularioPage.campoCep().sendKeys(Constant.cep());
		FormularioPage.botaoParaRegistrar().click();
		Assert.assertEquals(Constant.usuarioJaExistente(), FormularioPage.usuarioJaExiste());

	}
	
	@AfterMethod
	public void finaliza(ITestResult result) throws IOException {
		Report.tearDown(result, test);
		Report.closeReport(extent);
		DriverFactory.killDriver();
	}

}
