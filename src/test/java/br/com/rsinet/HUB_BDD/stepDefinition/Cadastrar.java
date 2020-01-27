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
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class Cadastrar {

	private WebDriver driver;
	private Cadastrar_Page cadastrar;
	private Home_Page home;
	private MassaDados dados;

	@Before
	public void inicializa() throws Exception {

		/* Método que inicia o navegador e passa a URL */
		driver = DriverFactory.openBrowser(DriverType.CHROME, Constant.URL);

	}

	@Dado("^O usuário esta na pagina home para cadastro$")
	public void o_usuário_esta_na_pagina_home_para_cadastro() throws Throwable {

		/*
		 * Metodo que instancia a o local e a planilha que seram utilizadas junto com a
		 * aba da planilha
		 */
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

		/* Metodo que inseri nos campos os valores retornados da planilha de excel */
		cadastrar.preencherCadastro(dados.getUserName(), dados.getPassword(), dados.getEmail(), dados.getPhoneNumber(),
				dados.getFristName(), dados.getLastName(), dados.getCountry(), dados.getPostalCode(), dados.getCity(),
				dados.getState(), dados.getAddress());
	}

	@Quando("^preenche formulario de cadastro falha$")
	public void preenche_formulario_de_cadastro_falha() throws Throwable {

		/* Metodo que inseri nos campos os valores retornados da planilha de excel */
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

		/* Método que valida se esta na URL correta depois de cadastrar */
		Assert.assertTrue("Usuário cadastrado com sucesso!!", driver.getCurrentUrl().equals(Constant.URL));

		home.esperaHome(driver);
		print.takeSnapShot("testeComSucesso");
	}

	@Então("^valida mensagem de usuário incorreto$")
	public void valida_mensagem_de_usuário_incorreto() throws Throwable {

		/* Método que valida se o o usuário digitou mais que 15 caracteres no usuário */
		Assert.assertTrue("Login de acesso invalido, mais caracteres do que o permitido",
				cadastrar.respostaCadastro().equals("Use maximum 15 character"));

		/* Método para rolar a tela para cima para printar o erro */
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0, -500)", "");

		print.takeSnapShot("testeCadastroFalha");
	}

	@After
	public void finaliza() {
		DriverFactory.closeBrowser(driver);
	}
}
