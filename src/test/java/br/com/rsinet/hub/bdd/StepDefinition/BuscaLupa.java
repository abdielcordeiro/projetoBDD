package br.com.rsinet.hub.bdd.StepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub.bdd.PageFactory.BuscarLupa_Page;
import br.com.rsinet.hub.bdd.Utility.Constant;
import br.com.rsinet.hub.bdd.Utility.DriverFactory;
import br.com.rsinet.hub.bdd.Utility.ExcelUtils;
import br.com.rsinet.hub.bdd.Utility.MassaDados;
import br.com.rsinet.hub.bdd.Utility.print;
import br.com.rsinet.hub.bdd.Utility.DriverFactory.DriverType;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class BuscaLupa {

	private WebDriver driver;
	private BuscarLupa_Page buscarLupa;
	private MassaDados dados;

	@Dado("^Que o usuário esteja na tela principal$")
	public void que_o_usuário_esteja_na_tela_principal() throws Throwable {

		/* Método que inicia o navegador e passa a URL */
		driver = DriverFactory.openBrowser(DriverType.CHROME, "http://www.advantageonlineshopping.com/#/");

		/*
		 * Metodo que instancia a o local e a planilha que seram utilizadas junto com a
		 * aba da planilha
		 */
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Pesquisa");

		buscarLupa = PageFactory.initElements(driver, BuscarLupa_Page.class);
		dados = new MassaDados();
	}

	@Quando("^Clica no botão da lupa$")
	public void clica_no_botão_da_lupa() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		buscarLupa.bntLupa();
	}

	@Quando("^fecha a lista de sugestões$")
	public void fecha_a_lista_de_sugestões() throws Throwable {
		buscarLupa.bntX(driver);
	}

	@Quando("^Digita o nome do tipo do produto$")
	public void digita_o_nome_do_tipo_do_produto() throws Throwable {
		buscarLupa.input_Produto(dados.getTipoProduto());
	}

	@Quando("^seleciona um produto da lista$")
	public void seleciona_um_produto_da_lista() throws Throwable {
		buscarLupa.pesquisaProdutoTela(driver, dados.getNomeProduto());
	}

	@Quando("^Digita o nome do tipo do produto inexistente$")
	public void digita_o_nome_do_tipo_do_produto_inexistente() throws Throwable {
		buscarLupa.input_Produto(dados.getNomeProdutoFalha());
	}

	@Então("^busca realizada com sucesso produto encontrado$")
	public void busca_realizada_com_sucesso_produto_encontrado() throws Throwable {

		/* Método que valida se a mensagem de produto não encontrado esta retornando */
		Assert.assertTrue("Produto encontrado com sucesso",
				buscarLupa.resultadoProduto().equals(dados.getNomeProduto().toUpperCase()));
		print.takeSnapShot("testeBuscaLupaFalha");
	}

	@Então("^valida mensagem de produto não encontrado$")
	public void valida_mensagem_de_produto_não_encontrado() throws Throwable {

		/*
		 * Método que valida se o produto buscado na lupa é o mesmo que esta sendo
		 * apresentado
		 */
		Assert.assertTrue("Produto: " + dados.getNomeProdutoFalha() + "  não encontrado",
				buscarLupa.label_Respota().contains("No results for " + "\"" + dados.getNomeProdutoFalha() + "\""));
		print.takeSnapShot("testeBuscaLupaSucesso");

	}

	@After
	public void finaliza() {
		DriverFactory.closeBrowser(driver);
	}
}
