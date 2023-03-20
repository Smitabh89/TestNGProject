package com.UtilityPackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Util 
{
	public static long PAGE_LOAD_TIMEOUT=10;
	  public static long IMPLICIT_WAIT=20;
	  
    DataFormatter formatter=new DataFormatter();
	@Test(dataProvider="Datadriven")
	public void testcase(String EmailId,String Password,String Number)
	{
		System.out.println(EmailId+Password+Number);
	}
	
	@DataProvider(name="Datadriven")
	public Object[][] getdata() throws IOException
  {
	FileInputStream fs=new FileInputStream("C:\\Users\\santo\\OneDrive\\Desktop\\Database1.xlsx");
	XSSFWorkbook xs=new XSSFWorkbook(fs);  //WorkBook
	XSSFSheet sheet=xs.getSheetAt(0);      //select Sheet
	int rowcount=sheet.getPhysicalNumberOfRows(); // Row Count here
	System.out.println(rowcount);
	XSSFRow row=sheet.getRow(0);        // select one Row
	int colcount=row.getLastCellNum();  //Column Count here
	
	Object data[][]=new Object[rowcount-1][colcount];
	for(int i=0;i<rowcount-1;i++)
	{
		row=sheet.getRow(i+1);
		for(int j=0;j<colcount;j++)
		{
			
			XSSFCell cell=row.getCell(j);
			data[i][j]=formatter.formatCellValue(cell);
		}
	}
	return data;
  }
}