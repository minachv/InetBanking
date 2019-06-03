package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils 
{
	public static FileInputStream fs;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile,String xlsheet) throws IOException
	{
		fs=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fs);
		ws=wb.getSheet(xlsheet);
		int rowCount;
		rowCount=ws.getLastRowNum();
		
		wb.close();
		fs.close();
		return rowCount;
		
	}
	
	public static int getCellCount(String xlfile,String xlsheet,int rowNum) throws IOException
	{
		fs=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fs);
		ws=wb.getSheet(xlsheet);
		int cellCount;
		cellCount=ws.getRow(rowNum).getLastCellNum();
		wb.close();
		fs.close();
		return cellCount;
		
	}
	
	public static String getCellData(String xlfile,String xlsheet,int rowNum, int column) throws IOException
	{
		fs=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fs);
		row=ws.getRow(rowNum);
		cell=row.getCell(column);
		String data;
		try
		{
		DataFormatter formatter= new DataFormatter();
		String CellData=formatter.formatCellValue(cell);
		return CellData;
		}
		catch (Exception e)
		{
			data="";
		}
		
		wb.close();
		fs.close();
		return data;
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rowNum, int column,String data) throws IOException
	{
		fs=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fs);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rowNum);
		cell=row.createCell(column);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fs.close();
		fo.close();
		
		
	}

}
