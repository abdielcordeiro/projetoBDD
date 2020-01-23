package br.com.rsinet.HUB_BDD.stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.HUB_BDD.pageFactory.Cadastrar_Page;
import br.com.rsinet.HUB_BDD.pageFactory.Home_Page;
import br.com.rsinet.HUB_BDD.utility.Constant;
import br.com.rsinet.HUB_BDD.utility.DriverFactory;
import br.com.rsinet.HUB_BDD.utility.DriverFactory.DriverType;
import br.com.rsinet.HUB_BDD.utility.ExcelUtils;
import br.com.rsinet.HUB_BDD.utility.MassaDados;
import br.com.rsinet.HUB_BDD.utility.print;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class Cadastrar {

	private WebDriver driver;
	private Cadastrar_Page cadastrar;
	private Home_Page home;
	private MassaDados dados;

	@Dado("^O usuário esta na pagina home para cadastro$")
	public void o_usuário_esta_na_pagina_home_para_cadastro() throws Throwable {
		driver = DriverFactory.openBrowser(DriverType.CHROME, Constant.URL);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");
		dados = new MassaDados();

		home = PageFactory.initElements(driver, Home_Page.class);
		cadastrar = PageFactory.initElements(driver, Cadastrar_Page.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Quando("^Navega para o login$")
	public void navega_para_o_login() throws Throwable {
		home.bntClicarLogin(driver);
	}

	@Quando("^clicar em cadastrar novo usuário$")
	public void clicar_em_cadastrar_novo_usuário() throws Throwable {
		home.bntClicarCadastro(driver);
	}

	@Quando("^preenche formulario de cadastro sucesso$")
	public void preenche_formulario_de_cadastro_sucesso() throws Throwable {

		cadastrar.preencherCadastro(dados.getUserName(), dados.getPassword(), dados.getEmail(), dados.getPhoneNumber(),
				dados.getFristName(), dados.getLastName(), dados.getCountry(), dados.getPostalCode(), dados.getCity(),
				dados.getState(), dados.getAddress());
	}

	@Quando("^preenche formulario de cadastro falha$")
	public void preenche_formulario_de_cadastro_falha() throws Throwable {

		cadastrar.preencherCadastro(dados.getUserNameFalha(), dados.getPassword(), dados.getEmail(),
				dados.getPhoneNumber(), dados.getFristName(), dados.getLastName(), dados.getCountry(),
				dados.getPostalCode(), dados.getCity(), dados.getState(), dados.getAddress());

	}

	@Quando("^Clica no botão de registrar$")
	public void clica_no_botão_de_registrar() throws Throwable {
		cadastrar.clicaBtnRegistrar();
	}

	@Então("^Valida usuário cadastrardo com sucesso$")
	public void valida_usuário_cadastrardo_com_sucesso() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlToBe("http://www.advantageonlineshopping.com/#/"));

		String resposta = driver.getCurrentUrl();

		System.out.println(resposta);
		Assert.assertTrue("Usuário cadastrado com sucesso!!", resposta.equals(Constant.URL));

		home.esperaHome(driver);

		print.takeSnapShot("testeComSucesso");
		DriverFactory.closeBrowser(driver);
	}

	@Então("^valida mensagem de usuário incorreto$")
	public void valida_mensagem_de_usuário_incorreto() throws Throwable {

		String resposta = cadastrar.respostaCadastro();
		System.out.println("Teste mensagem: " + resposta);

		Assert.assertTrue("Login de acesso invalido, mais caracteres do que o permitido",
				resposta.equals("Use maximum 15 character"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0, -500)", "");

		print.takeSnapShot("testeCadastroFalha");
		DriverFactory.closeBrowser(driver);
	}
}
