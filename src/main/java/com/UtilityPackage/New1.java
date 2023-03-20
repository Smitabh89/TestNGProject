package com.UtilityPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;








public class New1
{
	
	DataFormatter format=new DataFormatter();
	@Test(dataProvider="DataDriven")
	public void Testcase(String EmailId,String Password,String Number)
	{
		System.out.println(EmailId+Password+Number);
	}
	
	
	@DataProvider(name="DataDriven")
	public Object[][] getdata() throws IOException
	{
		String path="C:\\Users\\santo\\OneDrive\\Desktop\\Database1.xlsx";
		FileInputStream fs=new FileInputStream(path);
		XSSFWorkbook b =new XSSFWorkbook(fs);
		XSSFSheet sheet=b.getSheetAt(0);
		int rowcount=sheet.getPhysicalNumberOfRows();
		XSSFRow row=sheet.getRow(0);
		int columncount=row.getLastCellNum();
		Object data[][]=new Object[rowcount-1][columncount];
		for(int i=0;i<rowcount-1;i++)
		{
			row=sheet.getRow(i+1);
			for(int j=0;j<columncount;j++)
			{
				XSSFCell cell=row.getCell(j);
				data[i][j]=format.formatCellValue(cell);
			}
		}
		return data;
		
	}

}