package br.com.rsinet.hub.bdd.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Cadastrar_Page {

	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	private WebElement input_userName;

	@FindBy(how = How.NAME, using = "emailRegisterPage")
	private WebElement input_email;

	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	private WebElement input_senha;

	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	private WebElement input_confirmaSenha;

	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	private WebElement input_fristName;

	@FindBy(how = How.NAME, using = "last_nameRegisterPage")
	private WebElement input_lastName;

	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")
	private WebElement input_phoneNumber;

	@FindBy(how = How.NAME, using = "cityRegisterPage")
	private WebElement input_city;

	@FindBy(how = How.NAME, using = "addressRegisterPage")
	private WebElement input_address;

	@FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage")
	private WebElement input_state;

	@FindBy(how = How.NAME, using = "postal_codeRegisterPage")
	private WebElement input_cep;

	@FindBy(how = How.NAME, using = "i_agree")
	private WebElement bnt_concordar;

	@FindBy(how = How.ID, using = "register_btnundefined")
	private WebElement bnt_registrar;

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[1]/div[1]/sec-view[1]/div/label")
	private WebElement resposta;

	@FindBy(how = How.NAME, using = "countryListboxRegisterPage")
	private WebElement input_country;


	public void preencherCadastro(String userName, String password, String userEmail, String phoneNumber,
			String fristName, String lastName, String country, String cep, String city, String state, String address) {

		this.input_userName.sendKeys(userName);
		this.input_email.sendKeys(userEmail);
		this.input_senha.sendKeys(password);
		this.input_confirmaSenha.sendKeys(password);
		this.input_fristName.sendKeys(fristName);
		this.input_lastName.sendKeys(lastName);
		this.input_phoneNumber.sendKeys(phoneNumber);
		this.input_country.sendKeys(country);
		this.input_city.sendKeys(city);
		this.input_address.sendKeys(address);
		this.input_state.sendKeys(state);
		this.input_cep.sendKeys(cep);
		this.bnt_concordar.click();

	}

	public void clicaBtnRegistrar() {
		bnt_registrar.click();
	}

	public String respostaCadastro() {
		return resposta.getText();
	}

}