package br.com.rsinet.HUB_BDD.pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home_Page {

	@FindBy(how = How.ID, using = "menuUser")
	private WebElement bnt_Login;

	@FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/a[2]")
	private WebElement bnt_Cadastrar;

	public void executaHomeCadastro(WebDriver driver) {
		PageFactory.initElements(driver, Home_Page.class);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement bntLogar = wait.until(ExpectedConditions.elementToBeClickable(bnt_Login));
		bntLogar.click();

		WebElement bntCadastrar = wait.until(ExpectedConditions.elementToBeClickable(bnt_Cadastrar));
		bntCadastrar.sendKeys(Keys.ENTER);

	}

}
