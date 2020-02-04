package br.com.rsinet.appium.tdd.test;

import java.net.MalformedURLException;
import java.text.Normalizer.Form;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.rsinet.appium.tdd.pages.FormularioPage;
import br.com.rsinet.appium.tdd.pages.HomePage;
import br.com.rsinet.appium.tdd.pages.LoginPage;
import br.com.rsinet.appium.tdd.suport.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class CadastroDeUsuarioTest {

	private AndroidDriver<MobileElement> driver;
	

	@Before
	public void inicializa() {
		driver = DriverFactory.getDriver();
	}
	
	@After
	public void finaliza() {
		DriverFactory.killDriver();
	}

	@Test
	public void deveCadastrarUsuario() throws MalformedURLException, Exception {

		HomePage.menuLateral().click();
		HomePage.botaoLogin().click();
		LoginPage.botaoCriarNovaConta().click();
		FormularioPage.campoApelido().click();
		FormularioPage.campoApelido().sendKeys("Wilker00001");
		FormularioPage.campoEmail().click();
		FormularioPage.campoEmail().sendKeys("teste@teste.com.br");
		FormularioPage.campoSenha().sendKeys("Wbn221190");
		FormularioPage.campoConfirmaSenha().click();
		FormularioPage.campoConfirmaSenha().sendKeys("Wbn221190");
		FormularioPage.campoNome().click();
		FormularioPage.campoNome().sendKeys("Carlitos");
		
		
		//driver.hideKeyboard();
		

//		MobileElement campoNome = driver.findElementByXPath(
//				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText\r\n");
//		campoNome.click();
//		campoNome.sendKeys("Carlitos");
//		driver.hideKeyboard();
		TouchAction scroll = new TouchAction(driver);
//		scroll.press(PointOption.point(708, 917)).moveTo(PointOption.point(703, 133)).perform();

		MobileElement campoUltimoNome = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText\r\n");
		campoUltimoNome.click();
		campoUltimoNome.sendKeys("Tevez");

		MobileElement campoTelefone = driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText\r\n");
		campoTelefone.click();
		campoTelefone.sendKeys("11936054021");
		driver.hideKeyboard();

		MobileElement campoPais = driver.findElementById("com.Advantage.aShopping:id/textViewCountries");
		campoPais.click();

		MobileElement pais = (MobileElement) driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[9]");
		pais.click();

		MobileElement campoEstado = (MobileElement) driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText");
		campoEstado.click();
		campoEstado.sendKeys("BA");
		driver.hideKeyboard();
		scroll.press(PointOption.point(708, 917)).moveTo(PointOption.point(703, 800)).perform();

		MobileElement campoEndereco = (MobileElement) driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText");
		campoEndereco.click();
		campoEndereco.sendKeys("R. La Nina de lo Carlitos Tevez");
		driver.hideKeyboard();

		MobileElement campoCidade = (MobileElement) driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.EditText");
		campoCidade.click();
		campoCidade.sendKeys("La Vila");
		driver.hideKeyboard();

		MobileElement campoCep = (MobileElement) driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.EditText");
		campoCep.click();
		campoCep.sendKeys("06160-380");
		driver.hideKeyboard();
		scroll.press(PointOption.point(708, 651)).moveTo(PointOption.point(703, 500)).perform();

		MobileElement botaoEnviarFormulario = (MobileElement) driver
				.findElementById("com.Advantage.aShopping:id/buttonRegister");
		botaoEnviarFormulario.click();

//		Thread.sleep(2000);
//		MobileElement toastMensagem = (MobileElement) driver.findElementByName("android.widget.Toast[1]");
//		String mensagemUsuarioJaExiste = toastMensagem.getText();
//		System.out.println(mensagemUsuarioJaExiste);

	}
	
	
}
