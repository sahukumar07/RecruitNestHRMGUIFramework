package com.hrm.generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
		public String getDataFromExcelFile(String sheetName, int rowNum, int celNum) throws Throwable {
			FileInputStream fis = new FileInputStream("./TestData/HRMTestScriptData.xlsx");

			Workbook wb = WorkbookFactory.create(fis);
			String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
			wb.close();
			return data;
		}

		public int getRowcount(String sheetName) throws Throwable {
			FileInputStream fis = new FileInputStream("./TestData/HRMTestScriptData.xlsx");

			Workbook wb = WorkbookFactory.create(fis);
			int rowNum = wb.getSheet(sheetName).getLastRowNum();
			wb.close();
			return rowNum;

		}

		public void setDataIntoExcel(String sheetName, int rowNum, int celNum, String data) throws Throwable {
			FileInputStream fis = new FileInputStream("./TestData/HRMTestScriptData.xlsx");

			Workbook wb = WorkbookFactory.create(fis);
			wb.getSheet(sheetName).getRow(rowNum).getCell(celNum);

			FileOutputStream fos = new FileOutputStream("./TestData/HRMTestScriptData.xlsx");
			wb.write(fos);
			wb.close();

		}

	}



