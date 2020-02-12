package br.com.rsinet.appium.tdd.utility;

public class Constant {
	
	/* Configuracao do caminho e arquivo Excel */
	private static final String Path_TestData = "./src/main/java/br/com/rsinet/appium/tdd/testdata/";
	private static final String File_TestData = "TestData.xlsx";

	/* Metodo que recebe o arquivo do Excel e informa qual planilha contem a Massa de Dados */
	public static void recebeDadosDoExcel(String planilha) throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, planilha);
	}

	/* Dados extraidos do Excel e utilizados no Cadastro de Usuario */
	public static String apelido() throws Exception {
		return ExcelUtils.getCellData(1, 1);
	}

	public static String senha() throws Exception {
		return ExcelUtils.getCellData(2, 1);
	}

	public static String confirmaSenha() throws Exception {
		return ExcelUtils.getCellData(3, 1);
	}

	public static String email() throws Exception {
		return ExcelUtils.getCellData(4, 1);
	}
	
	public static String primeiroNome() throws Exception {
		return ExcelUtils.getCellData(5, 1);
	}
	
	public static String ultimoNome() throws Exception {
		return ExcelUtils.getCellData(6, 1);
	}
	
	public static String telefone() throws Exception {
		return ExcelUtils.getCellData(7, 1);
	}
	
	public static String pais() throws Exception {
		return ExcelUtils.getCellData(8, 1);
	}
	
	public static String cidade() throws Exception {
		return ExcelUtils.getCellData(9, 1);
	}
	
	public static String endereco()throws Exception {
		return ExcelUtils.getCellData(10, 1);
	}
	
	public static String estado() throws Exception {
		return ExcelUtils.getCellData(11, 1);
	}
	
	public static String cep() throws Exception {
		return ExcelUtils.getCellData(12, 1);
	}
	
	public static String usuarioJaExistente() throws Exception {
		return ExcelUtils.getCellData(13,1);
	}
	
	/* Dados extraidos do Excel e utilizados no Campo de Pesquisa e Tela Principal */
	public static String categoria() throws Exception {
		return ExcelUtils.getCellData(3, 0);
	}
	
	public static String produtoValido() throws Exception {
		return ExcelUtils.getCellData(3, 1);
	}
	
	public static String produtoInvalido() throws Exception {
		return ExcelUtils.getCellData(11, 0);
	}
	
	public static String mensagemEsperadaParaProdutoInvalidoObtido() throws Exception {
		return ExcelUtils.getCellData(11, 1);
	}
	
	public static String quantidadeDeProdutosDoCarrinho() throws Exception {
		return ExcelUtils.getCellData(7, 0);
	}
	
	public static String mensagemEsperadaParaQuantidadeDeProdutosInvalidos() throws Exception {
		return ExcelUtils.getCellData(7, 1);
	}
}
