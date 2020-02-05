package br.com.rsinet.appium.tdd.utility;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;

	/* Metodo que define o caminho  e abre o arquivo do Excel */
	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {
			/* Abre o arquivo do Excel */
			FileInputStream ExcelFile = new FileInputStream(Path);

			/* Acessa a folha de dados "Aba" */
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {
			throw (e);
		}
	}

	/* Metodo que faz a leitura da celula do arquivo do Excel, para isso deve ser informado os parametros linha e coluna */
	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;

		} catch (Exception e) {
			return "";
		}
	}
}
