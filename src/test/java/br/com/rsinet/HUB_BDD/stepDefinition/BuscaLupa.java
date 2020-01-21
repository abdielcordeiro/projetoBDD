package br.com.rsinet.HUB_BDD.stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.HUB_BDD.pageFactory.BuscarLupa_Page;
import br.com.rsinet.HUB_BDD.utility.DriverFactory;
import br.com.rsinet.HUB_BDD.utility.DriverFactory.DriverType;
import br.com.rsinet.HUB_BDD.utility.print;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class BuscaLupa {

	private WebDriver driver;
	private BuscarLupa_Page buscarLupa;

	@Dado("^Que o usuário esteja na tela principal$")
	public void que_o_usuário_esteja_na_tela_principal() throws Throwable {
		driver = DriverFactory.openBrowser(DriverType.CHROME, "http://www.advantageonlineshopping.com/#/");
		buscarLupa = PageFactory.initElements(driver, BuscarLupa_Page.class);
	}

	@Quando("^Clica no botão da lupa$")
	public void clica_no_botão_da_lupa() throws Throwable {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		buscarLupa.bntLupa();
	}

	@Quando("^Digita o nome do tipo do produto \"([^\"]*)\"$")
	public void digita_o_nome_do_tipo_do_produto(String tipoProduto) throws Throwable {
		buscarLupa.input_Produto(tipoProduto);
	}

	@Quando("^fecha a lista de sugestões$")
	public void fecha_a_lista_de_sugestões() throws Throwable {
		buscarLupa.bntX(driver);
	}

	@Quando("^seleciona um produto da lista \"([^\"]*)\"$")
	public void seleciona_um_produto_da_lista(String nomeProduto) throws Throwable {
		buscarLupa.pesquisaProdutoTela(driver, nomeProduto);
	}

	@Então("^busca realizada com sucesso produto encontrado \"([^\"]*)\"$")
	public void busca_realizada_com_sucesso_produto_encontrado(String nomeProduto) throws Throwable {
		String resposta = buscarLupa.resultadoProduto();
		System.out.println(resposta);
		System.out.println(nomeProduto.toUpperCase());
		Assert.assertTrue("Produto encontrado com sucesso", resposta.equals(nomeProduto.toUpperCase()));
		print.takeSnapShot("testeBuscaLupaFalha");
		DriverFactory.closeBrowser(driver);
	}

	@Então("^valida mensagem de produto não encontrado \"([^\"]*)\"$")
	public void valida_mensagem_de_produto_não_encontrado(String nomeProduto) throws Throwable {
		String resposta = buscarLupa.label_Respota();
		System.out.println(resposta);
		System.out.println("No results for " + "\"" + nomeProduto + "\"");
		Assert.assertTrue("Produto: " + nomeProduto + "  não encontrado",
				resposta.equals("No results for " + "\"" + nomeProduto + "\""));
		print.takeSnapShot("testeBuscaLupaSucesso");
		DriverFactory.closeBrowser(driver);
	}
}
