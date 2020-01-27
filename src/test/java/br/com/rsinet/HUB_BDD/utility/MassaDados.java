package br.com.rsinet.HUB_BDD.utility;

public class MassaDados {

	private static int linha = 1;
	private static int linhaFalha = 6;

	public String getUserName() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.UserName);
	}

	public String getUserNameFalha() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.UserNameFalha);
	}

	public String getPassword() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.UserPass);
	}

	public String getEmail() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.Email);
	}

	public String getFristName() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.FristName);
	}

	public String getLastName() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.LastName);
	}

	public String getPhoneNumber() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.PhoneNumber);
	}

	public String getCity() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.City);
	}

	public String getAddress() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.Address);
	}

	public String getState() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.State);
	}

	public String getPostalCode() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.PostalCode);
	}

	public String getCountry() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.Country);
	}

	public String getTipoProduto() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.TipoProduto);
	}

	public String getNomeProduto() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.NomeProduto);
	}

	public String getNomeProdutoFalha() throws Exception {
		return ExcelUtils.getCellDataString(linhaFalha, Constant.NomeProdutoFalha);
	}

	public Integer getQuantidadeProduto() throws Exception {
		return Integer.valueOf(ExcelUtils.getCellDataNumber(linha, Constant.QuantidadeProduto));
	}

}
