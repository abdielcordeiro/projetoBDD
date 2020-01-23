package br.com.rsinet.HUB_BDD.cucumberTest;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import br.com.rsinet.HUB_BDD.managers.FileReaderManager;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:feature", // configuração do pacote que contém as features
		glue = "br.com.rsinet.HUB_BDD.stepDefinition", // configuração do pacote que contém minhas step
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/resultados.html" }, // Plugin responsavel por criar o arquivo do reporte
		snippets = SnippetType.CAMELCASE,
		monochrome = true,
		dryRun = false,
		tags = {"@Falha, @Sucesso"} // Configurações das anotações que devem ser executadas
) // Configurações do Cucumber

public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	}
}
