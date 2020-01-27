package br.com.rsinet.HUB_BDD.stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.HUB_BDD.pageFactory.BuscarLupa_Page;
import br.com.rsinet.HUB_BDD.utility.Constant;
import br.com.rsinet.HUB_BDD.utility.DriverFactory;
import br.com.rsinet.HUB_BDD.utility.DriverFactory.DriverType;
import br.com.rsinet.HUB_BDD.utility.ExcelUtils;
import br.com.rsinet.HUB_BDD.utility.MassaDados;
import br.com.rsinet.HUB_BDD.utility.print;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class BuscaClique {

	private WebDriver driver;
	private BuscarLupa_Page buscarLupa;
	private MassaDados dados;

	@Dado("^O usuário esta na pagina home buscar produto$")
	public void o_usuário_esta_na_pagina_home_buscar_produto() throws Throwable {

		/* Método que inicia o navegador e passa a URL */
		driver = DriverFactory.openBrowser(DriverType.CHROME, Constant.URL);

		/*
		 * Metodo que instancia a o local e a planilha que seram utilizadas junto com a
		 * aba da planilha
		 */
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Pesquisa");

		buscarLupa = PageFactory.initElements(driver, BuscarLupa_Page.class);

		dados = new MassaDados();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Quando("^Clicar na categoria desejada$")
	public void clicar_na_categoria_desejada() throws Throwable {
		buscarLupa.preencherPorduto(dados.getTipoProduto());
	}

	@Quando("^selecionar um produto$")
	public void selecionar_um_produto() throws Throwable {
		buscarLupa.pesquisaProdutoTela(driver, dados.getNomeProduto());
	}

	@Então("^Valida se o produto foi selecionado corretamente$")
	public void valida_se_o_produto_foi_selecionado_corretamente() throws Throwable {

		buscarLupa.pesquisaProdutoTela(driver, dados.getNomeProduto());

		/* Método que valida se o produto busca e o mesmo que foi passado na massa */
		Assert.assertTrue("Produto encontrado com sucesso",
				dados.getNomeProduto().toUpperCase().equals(buscarLupa.labeProduto()));

		print.takeSnapShot("testeBuscaClickSucesso");
	}

	@Quando("^manda varios produtos para o carrinho$")
	public void manda_varios_produtos_para_o_carrinho() throws Throwable {

		/* Laço de repetição para adicionar X quantidade de produtos */
		for (int i = 0; i < dados.getQuantidadeProduto(); i++) {
			buscarLupa.bntAddProduto();
		}

		buscarLupa.bntAddCarinho();
	}

	@Então("^valida se a quantidade que esta no carinho e compativel$")
	public void valida_se_a_quantidade_que_esta_no_carinho_e_compativel() throws Throwable {

		buscarLupa.bntEntrarCarinho();
		print.takeSnapShot("testeBuscaClickFalha");
		/*
		 * É esperado que a quantidade que foi selecionada seja menor que a quantidade
		 * pedida
		 */
		Assert.assertTrue("Quantidade Cadastrada diferente da pedida",
				buscarLupa.respostaQnt() < dados.getQuantidadeProduto());

	}

	@After
	public void finaliza() {
		DriverFactory.closeBrowser(driver);
	}

}