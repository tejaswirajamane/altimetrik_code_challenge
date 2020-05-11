package com.altimetrik.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestDataUtil {
	XSSFWorkbook wb;
	XSSFSheet sheet1;

	public TestDataUtil() {
		{
			File src = new File("./src/test/resources/testdata/LoginTestData.xlsx");
			try {
				FileInputStream fis = new FileInputStream(src);
				wb = new XSSFWorkbook(fis);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	public String getStringData(String sheetName, int row, int column) {

		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();

	}
	
	public JSONObject getJsonData() throws IOException, ParseException
	{
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("./src/test/resources/testdata/jsontestdata.json");
		Object obj = jsonParser.parse(reader);
		JSONObject user = (JSONObject) obj;
		return user;
	}

}