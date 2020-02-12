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

import br.com.rsinet.appium.tdd.screens.BaseScreen;
import br.com.rsinet.appium.tdd.screens.FormularioScreen;
import br.com.rsinet.appium.tdd.screens.HomeScreen;
import br.com.rsinet.appium.tdd.screens.LoginScreen;
import br.com.rsinet.appium.tdd.suport.DriverFactory;
import br.com.rsinet.appium.tdd.utility.Constant;
import br.com.rsinet.appium.tdd.utility.Report;

public class CadastroDeUsuarioTest {
	
	private ExtentTest test;
	private ExtentReports extent;

	@BeforeMethod
	public void inicializa() throws Exception {
		DriverFactory.getDriver();
		Constant.recebeDadosDoExcel("Cadastro");
	}

	@BeforeTest
	public void criarRelatorio() {
		extent = Report.setExtent();
	}

	@Test
	public void deveCadastrarUsuario() throws Exception {
		test = Report.setUp("deveCadastrarUsuario");

		HomeScreen.menuLateral().click();
		HomeScreen.botaoLogin().click();
		LoginScreen.botaoCriarNovaConta().click();
		FormularioScreen.campoApelido().click();
		FormularioScreen.campoApelido().sendKeys(Constant.apelido());
		FormularioScreen.campoEmail().click();
		FormularioScreen.campoEmail().sendKeys(Constant.email());
		FormularioScreen.campoSenha().click();
		FormularioScreen.campoSenha().sendKeys(Constant.senha());
		FormularioScreen.campoConfirmaSenha().click();
		FormularioScreen.campoConfirmaSenha().sendKeys(Constant.confirmaSenha());
		FormularioScreen.campoNome().click();
		FormularioScreen.campoNome().sendKeys(Constant.primeiroNome());
		FormularioScreen.campoUltimoNome().click();
		FormularioScreen.campoUltimoNome().sendKeys(Constant.ultimoNome());
		BaseScreen.scrollDown(0.9, 0.1);
		FormularioScreen.campoTelefone().click();
		FormularioScreen.campoTelefone().sendKeys(Constant.telefone());
		FormularioScreen.campoPais().click();
		FormularioScreen.selecionaPais(Constant.pais());
		FormularioScreen.campoEstado().click();
		FormularioScreen.campoEstado().sendKeys(Constant.estado());
		FormularioScreen.campoEndereco().click();
		FormularioScreen.campoEndereco().sendKeys(Constant.endereco());
		FormularioScreen.campoCidade().click();
		FormularioScreen.campoCidade().sendKeys(Constant.cidade());
		FormularioScreen.campoCep().click();
		FormularioScreen.campoCep().sendKeys(Constant.cep());
		FormularioScreen.botaoParaRegistrar().click();
		HomeScreen.menuLateral().click();
		Assert.assertEquals(Constant.apelido(), HomeScreen.usuarioCadastrado());
	}

	@Test
	public void deveTentarCadastrarUsuarioJaExistente() throws Exception {
		test = Report.setUp("deveTentarCadastrarUsuarioJaExistente");

		HomeScreen.menuLateral().click();
		HomeScreen.botaoLogin().click();
		LoginScreen.botaoCriarNovaConta().click();
		FormularioScreen.campoApelido().click();
		FormularioScreen.campoApelido().sendKeys(Constant.apelido());
		FormularioScreen.campoEmail().click();
		FormularioScreen.campoEmail().sendKeys(Constant.email());
		FormularioScreen.campoSenha().click();
		FormularioScreen.campoSenha().sendKeys(Constant.senha());
		FormularioScreen.campoConfirmaSenha().click();
		FormularioScreen.campoConfirmaSenha().sendKeys(Constant.confirmaSenha());
		FormularioScreen.campoNome().click();
		FormularioScreen.campoNome().sendKeys(Constant.primeiroNome());
		FormularioScreen.campoUltimoNome().click();
		FormularioScreen.campoUltimoNome().sendKeys(Constant.ultimoNome());
		BaseScreen.scrollDown(0.8, 0.2);
		FormularioScreen.campoTelefone().click();
		FormularioScreen.campoTelefone().sendKeys(Constant.telefone());
		FormularioScreen.campoPais().click();
		FormularioScreen.selecionaPais(Constant.pais());
		FormularioScreen.campoEstado().click();
		FormularioScreen.campoEstado().sendKeys(Constant.estado());
		FormularioScreen.campoEndereco().click();
		FormularioScreen.campoEndereco().sendKeys(Constant.endereco());
		FormularioScreen.campoCidade().click();
		FormularioScreen.campoCidade().sendKeys(Constant.cidade());
		FormularioScreen.campoCep().click();
		FormularioScreen.campoCep().sendKeys(Constant.cep());
		FormularioScreen.botaoParaRegistrar().click();
		Assert.assertEquals(Constant.usuarioJaExistente(), FormularioScreen.usuarioJaExiste());
	}
	
	@AfterMethod
	public void finaliza(ITestResult result) throws IOException {
		Report.tearDown(result, test);
		Report.closeReport(extent);
		DriverFactory.killDriver();
	}
}
