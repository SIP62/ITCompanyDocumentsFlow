package by.bsuir.spp.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import by.bsuir.spp.entities.Client;

public class ClientExcelOutput {

	public boolean sendDataToExcel(Client client) throws IOException {
		boolean isOutput = false;
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		XSSFSheet spreadsheet = workbook.createSheet("client");
	    spreadsheet.setColumnWidth(1, 8000);
	    spreadsheet.setColumnWidth(2, 8000);
	      
	    XSSFCellStyle styleHeader = workbook.createCellStyle();
	    //Create a new font for header and alter it.
	    XSSFFont fontHeader = workbook.createFont();
	    fontHeader.setFontHeightInPoints((short) 30);
	    fontHeader.setFontName("IMPACT");
	    fontHeader.setItalic(true);
	    fontHeader.setColor(HSSFColor.BLUE.index);
	    //Set font into style
	    styleHeader.setFont(fontHeader);
	      
	    XSSFCellStyle styleFooter = workbook.createCellStyle();
		//Create a new font for header and alter it.
	    XSSFFont fontFooter = workbook.createFont();
	    fontFooter.setFontHeightInPoints((short) 18);
	    fontFooter.setFontName("Comic Sans MS");
	    fontFooter.setBold(true);
	    fontFooter.setColor(HSSFColor.BLUE.index);    
		//Set font into style
		styleFooter.setFont(fontFooter);   
		      
		XSSFCellStyle styleTh = workbook.createCellStyle();
	    //Create a new font for header and alter it.
	    XSSFFont fontTh = workbook.createFont();
	    fontTh.setFontHeightInPoints((short) 12);
	    fontTh.setFontName("ARIAL");
	    fontTh.setBold(true);
	    fontTh.setColor(HSSFColor.BLACK.index);
	    //Set font into style
	    styleTh.setFont(fontTh);
	    styleTh.setAlignment(XSSFCellStyle.ALIGN_CENTER);
	    styleTh.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
	    styleTh.setBorderBottom(XSSFCellStyle.BORDER_THIN);
	    styleTh.setBorderLeft(XSSFCellStyle.BORDER_THIN);
	    styleTh.setBorderRight(XSSFCellStyle.BORDER_THIN);
	    styleTh.setBorderTop(XSSFCellStyle.BORDER_THIN);
	    
	    XSSFCellStyle styleTd = workbook.createCellStyle();
	    //Create a new font for header and alter it.
	    XSSFFont fontTd = workbook.createFont();
	    fontTd.setFontHeightInPoints((short) 12);
	    fontTd.setFontName("ARIAL");
	    fontTd.setColor(HSSFColor.BLACK.index);
	    //Set font into style
	    styleTd.setFont(fontTd);
	    styleTd.setAlignment(XSSFCellStyle.ALIGN_JUSTIFY);
	    styleTd.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
	    styleTd.setBorderBottom(XSSFCellStyle.BORDER_THIN);
	    styleTd.setBorderLeft(XSSFCellStyle.BORDER_THIN);
	    styleTd.setBorderRight(XSSFCellStyle.BORDER_THIN);
	    styleTd.setBorderTop(XSSFCellStyle.BORDER_THIN);
	      
	      XSSFRow row = spreadsheet.createRow(0);
	      // Create a cell with a value and set style to it.
	      XSSFCell cell = row.createCell(1);
	      cell.setCellValue("Client Data");
	      cell.setCellStyle(styleHeader);
	      
	      row=spreadsheet.createRow(1);
	      row.setHeight((short) 800);
	      cell=row.createCell(1);
	      cell.setCellValue("Name");
	      cell.setCellStyle(styleTh);
	      cell=row.createCell(2);
	      cell.setCellValue(client.getUsers().getName());
	      cell.setCellStyle(styleTd);
	      
	      row=spreadsheet.createRow(2);
	      row.setHeight((short) 800);
	      cell=row.createCell(1);
	      cell.setCellValue("Payment Credentials");
	      cell.setCellStyle(styleTh);
	      cell=row.createCell(2);
	      cell.setCellValue(client.getPaymentCredentials());
	      cell.setCellStyle(styleTd);
	      
	      row=spreadsheet.createRow(3);
	      row.setHeight((short) 800);
	      cell=row.createCell(1);
	      cell.setCellValue("Phone");
	      cell.setCellStyle(styleTh);
	      cell=row.createCell(2);
	      cell.setCellValue(client.getPhone());
	      cell.setCellStyle(styleTd);
	      
	      row=spreadsheet.createRow(4);
	      row.setHeight((short) 800);
	      cell=row.createCell(1);
	      cell.setCellValue("e-Mail");
	      cell.setCellStyle(styleTh);
	      cell=row.createCell(2);
	      cell.setCellValue(client.getEmail());
	      cell.setCellStyle(styleTd);
	      
	      row=spreadsheet.createRow(5);
	      row.setHeight((short) 800);
	      cell=row.createCell(1);
	      cell.setCellValue("Address");
	      cell.setCellStyle(styleTh);
	      cell=row.createCell(2);
	      cell.setCellValue(client.getAddress());
	      cell.setCellStyle(styleTd);
	      
	      row=spreadsheet.createRow(6);
	      row.setHeight((short) 800);
	      cell=row.createCell(1);
	      cell.setCellValue("Discount");
	      cell.setCellStyle(styleTh);
	      cell=row.createCell(2);
	      cell.setCellValue(client.getDiscount());
	      cell.setCellStyle(styleTd);
	      
	      row = spreadsheet.createRow(7);
	      cell = row.createCell(1);
	      cell.setCellValue("Dream Team");
	      cell.setCellStyle(styleFooter);
	      
	      FileOutputStream out = new FileOutputStream(
	    	      new File("clientdataoutput.xlsx"));
	      workbook.write(out);
	      out.close();
	      isOutput = true;
	      System.out.println(
	    	      "clientdataoutput.xlsx written successfully");
		return isOutput;
	}

}
