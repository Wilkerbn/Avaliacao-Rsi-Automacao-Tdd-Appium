package br.com.rsinet.appium.tdd.utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import br.com.rsinet.appium.tdd.suport.DriverFactory;
import br.com.rsinet.appium.tdd.suport.Screenshot;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Report {

	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static ExtentReports setExtent() {
		

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myReport.html");
		htmlReporter.config().setDocumentTitle("Relatorio de Automacao"); // Titulo do report
		htmlReporter.config().setReportName("Relatorio Funcional"); // Nome do report
		htmlReporter.config().setTheme(Theme.DARK); // Seleciona o tema

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "Wilker");
		extent.setSystemInfo("Browser", "Chrome");
		
		return extent;
	}

	/* Fecha o relatorio */
	public static void closeReport(ExtentReports extent) {
		extent.flush();
	}

	/* Cria o Report */
	public static ExtentTest setUp(String report) {
		test = extent.createTest(report);
		return test;
	}

	/* Verifica se o teste passou, falhou ou pulou e tira screenshot */
	public static void tearDown(ITestResult result, ExtentTest test) throws IOException {
		String screenshotPath = Screenshot.tirar(result.getName());
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); 
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); 
			test.addScreenCaptureFromPath(screenshotPath); 

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
			test.addScreenCaptureFromPath(screenshotPath); 

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		}
	}
}
