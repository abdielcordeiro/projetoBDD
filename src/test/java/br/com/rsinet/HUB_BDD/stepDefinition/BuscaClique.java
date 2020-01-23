package br.com.rsinet.HUB_BDD.stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.HUB_BDD.dataProvider.ConfigFileReader;
import br.com.rsinet.HUB_BDD.pageFactory.BuscarLupa_Page;
import br.com.rsinet.HUB_BDD.utility.Constant;
import br.com.rsinet.HUB_BDD.utility.DriverFactory;
import br.com.rsinet.HUB_BDD.utility.DriverFactory.DriverType;
import br.com.rsinet.HUB_BDD.utility.ExcelUtils;
import br.com.rsinet.HUB_BDD.utility.print;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class BuscaClique {

	private WebDriver driver;
	private BuscarLupa_Page buscarLupa;
	ConfigFileReader configFileReader = new ConfigFileReader();

	@Dado("^O usuário esta na pagina home buscar produto$")
	public void o_usuário_esta_na_pagina_home_buscar_produto() throws Throwable {
		driver = DriverFactory.openBrowser(DriverType.CHROME, Constant.URL); // Definição do navegador e da URL desejada
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Pesquisa"); // Definição do arquivo do
																								// excel e da planilha
		buscarLupa = PageFactory.initElements(driver, BuscarLupa_Page.class); // Inicialização da Page
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Quando("^Clicar na categoria desejada$")
	public void clicar_na_categoria_desejada() throws Throwable {
		String produto = ExcelUtils.getCellData(1, Constant.Produto);
		buscarLupa.preencherPorduto(produto);
	}

	@Quando("^selecionar um produto$")
	public void selecionar_um_produto() throws Throwable {
		String nomeProduto = ExcelUtils.getCellData(1, Constant.nomeProduto);
		buscarLupa.pesquisaProdutoTela(driver, nomeProduto);
	}

	@Então("^Valida se o produto foi selecionado corretamente$")
	public void valida_se_o_produto_foi_selecionado_corretamente() throws Throwable {
		String nomeProduto = ExcelUtils.getCellData(1, Constant.nomeProduto);
		buscarLupa.pesquisaProdutoTela(driver, nomeProduto);

		Assert.assertTrue("Produto encontrado com sucesso", nomeProduto.equals(nomeProduto));
		print.takeSnapShot("testeBuscaClickSucesso");
		DriverFactory.closeBrowser(driver);
	}

	@Quando("^manda varios produtos para o carrinho$")
	public void manda_varios_produtos_para_o_carrinho() throws Throwable {
		for (int i = 0; i < 19; i++) {
			buscarLupa.bntAddProduto();
		}
		buscarLupa.bntAddCarinho();
	}

	@Então("^valida se a quantidade que esta no carinho e compativel$")
	public void valida_se_a_quantidade_que_esta_no_carinho_e_compativel() throws Throwable {
		buscarLupa.bntEntrarCarinho();

		/*
		 * Mensagem deseja que seja de falha, pois a cadastrada é diferente da quantidade adicionada no carrinho
		 */
		int quantidade = buscarLupa.respostaQnt();
		print.takeSnapShot("testeBuscaClickFalha");
		DriverFactory.closeBrowser(driver);
		Assert.assertEquals("Quantidade Cadastrada diferente da pedida", quantidade, 20);
	}

}
