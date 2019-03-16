package utils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		ExcelUtils excelUtils = new ExcelUtils(projectPath + "/excel/data.xlsx", "Sheet1");
		
		excelUtils.getRowCount();
		excelUtils.getCellDataString(0, 0);
		excelUtils.getCellDataNumber(1, 1);

	}

}
