package com.BankingFramework.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell col;
	public static FileOutputStream fo;

	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		sheet = wb.getSheet(xlsheet);
		int RowCount = sheet.getLastRowNum();
		wb.close();
		fi.close();
		return RowCount;
	}
	public static int getCellCount(String xlfile,String xlsheet,int rowNum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		row=sheet.getRow(rowNum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	public static String getCellData(String xlfile,String xlsheet,int rowNum,int colNum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		row=sheet.getRow(rowNum);
		col=row.getCell(colNum);
		String data;
		try
		{
		DataFormatter df=new DataFormatter();
		String cellData=df.formatCellValue(col);
		return cellData;
		}
		catch (Exception e) {
			data="";
			// TODO: handle exception
		}
		wb.close();
		fi.close();
		return data;
		
	}
	public static void setCellData(String xlfile,String xlsheet,int rowNum,int colNum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(xlsheet);
		row=sheet.getRow(rowNum);
		col=row.getCell(colNum);
		col.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	
}
