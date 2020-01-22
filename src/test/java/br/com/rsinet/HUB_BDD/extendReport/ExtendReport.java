package br.com.rsinet.HUB_BDD.extendReport;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReport {

	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest test;
	public static ExtentReports extent;


//	public String getReportConfigPath(){
//		 String reportConfigPath = properties.getProperty("reportConfigPath");
//		 if(reportConfigPath!= null) return reportConfigPath;
//		 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
//		}

	public static ExtentReports setExtent(String nome) {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/reports/"+nome+".html");

		htmlReporter.config().setDocumentTitle("Automatização de Teste");// Titulo do documento
		htmlReporter.config().setReportName("Reporte Funcional");// Nome do reporte
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "Abdiel");
		extent.setSystemInfo("Browser", "Chrome");

		return extent;
	}

	public static void endReport(ExtentReports extent) {
		extent.flush();
	}

	public static void tearDown(ITestResult result, ExtentTest test) {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Caso de teste falhou " + result.getName()); // Adiciona o nome na extenção reporte
			test.log(Status.FAIL, "Caso de teste falhou " + result.getThrowable()); // Adiciona o erro/ exceção

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Caso de teste que pulou " + result.getName());
		} else if(result.getStatus() == ITestResult.SUCCESS){
			test.log(Status.PASS, "Caso de teste passou " + result.getName());
		}
	}

}
