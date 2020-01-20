package br.com.rsinet.HUB_BDD.pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuscarLupa_Page {

	@FindBy(how = How.ID, using = "menuSearch")
	private WebElement bnt_lupa;

	@FindBy(how = How.ID, using = "autoComplete")
	private WebElement input_buscar;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPage\"]/div[3]/div/label/span")
	private WebElement label_resposta;

	@FindBy(how = How.XPATH, using = "//*[@id=\"Description\"]/h1")
	private WebElement label_nomeProduto;

	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/div/img")
	private WebElement bnt_X;

	@FindBy(how = How.ID, using = "speakersImg")
	private WebElement bnt_categoria;

	@FindBy(how = How.ID, using = "19")
	private WebElement bnt_produto;

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/section/article[1]/div[2]/div[2]/div/div[2]/e-sec-plus-minus/div/div[3]")
	private WebElement bnt_addProduto;

	@FindBy(how = How.NAME, using = "save_to_cart")
	private WebElement bnt_salvarCarrinho;

	@FindBy(how = How.ID, using = "menuCart")
	private WebElement bnt_entrarCarrinho;

	@FindBy(how = How.XPATH, using = "//*[@id=\"shoppingCart\"]/table/tbody/tr/td[4]/label[2]")
	private WebElement label_quantidade;

	public void pesquisaProdutoTela(WebDriver driver, String produto) {
		WebElement element = driver.findElement(By.xpath("//*[. ='" + produto + "']"));
		WebDriverWait wait = new WebDriverWait(driver, 80);
		WebElement bntProduto = wait.until(ExpectedConditions.elementToBeClickable(element));
		bntProduto.click();
	}

	public void preencherPorduto(String produto) {
		input_buscar.sendKeys(produto + Keys.ENTER);
	}

	public void bntLupa() {
		bnt_lupa.click();
	}

	public void bntX(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement bntX = wait.until(ExpectedConditions.elementToBeClickable(bnt_X));
		bntX.click();
	}

	public String label_Respota() {
		return label_resposta.getText();
	}

	public int respostaQnt() {
		int testaQuantidade = Integer.parseInt(label_quantidade.getText());
		return testaQuantidade;
	}

	public void bntAddProduto() {
		bnt_addProduto.click();
	}

	public void bntAddCarinho() {
		bnt_salvarCarrinho.click();
	}

	public void bntEntrarCarinho() {
		bnt_entrarCarrinho.click();
	}

	public void input_Produto(String produto) {
		input_buscar.sendKeys(produto + Keys.ENTER);
	}

	public String resultadoProduto() {
		return label_nomeProduto.getText();
	}


}
