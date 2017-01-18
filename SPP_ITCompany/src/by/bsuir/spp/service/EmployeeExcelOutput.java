package by.bsuir.spp.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import by.bsuir.spp.entities.Employee;

public class EmployeeExcelOutput {

	public boolean sendDataToExcel(Employee employee) throws IOException {
		boolean isOutput = false;
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(); 
		CreationHelper createHelper = workbook.getCreationHelper();
		XSSFSheet spreadsheet = workbook.createSheet("employee");
		
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
	    
	    XSSFCellStyle styleTdDate = workbook.createCellStyle();
	    //Set font into style
	    styleTdDate.setFont(fontTd);
	    styleTdDate.setAlignment(XSSFCellStyle.ALIGN_JUSTIFY);
	    styleTdDate.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
	    styleTdDate.setBorderBottom(XSSFCellStyle.BORDER_THIN);
	    styleTdDate.setBorderLeft(XSSFCellStyle.BORDER_THIN);
	    styleTdDate.setBorderRight(XSSFCellStyle.BORDER_THIN);
	    styleTdDate.setBorderTop(XSSFCellStyle.BORDER_THIN);
	      	      
	      XSSFRow row = spreadsheet.createRow(0);
	      // Create a cell with a value and set style to it.
	      XSSFCell cell = row.createCell(1);
	      cell.setCellValue("Employee Data");
	      cell.setCellStyle(styleHeader);
	      
	      row=spreadsheet.createRow(1);
	      row.setHeight((short) 800);
	      cell=row.createCell(1);
	      cell.setCellValue("Name");
	      cell.setCellStyle(styleTh);
	      cell=row.createCell(2);
	      cell.setCellValue(employee.getUsers().getName());
	      cell.setCellStyle(styleTd);
	      
	      row=spreadsheet.createRow(2);
	      row.setHeight((short) 800);
	      cell=row.createCell(1);
	      cell.setCellValue("Address");
	      cell.setCellStyle(styleTh);
	      cell=row.createCell(2);
	      cell.setCellValue(employee.getAddress());
	      cell.setCellStyle(styleTd);
	      
	      row=spreadsheet.createRow(3);
	      row.setHeight((short) 800);
	      cell=row.createCell(1);
	      cell.setCellValue("Phone");
	      cell.setCellStyle(styleTh);
	      cell=row.createCell(2);
	      cell.setCellValue(employee.getPhone());
	      cell.setCellStyle(styleTd);
	      
	      row=spreadsheet.createRow(4);
	      row.setHeight((short) 800);
	      cell=row.createCell(1);
	      cell.setCellValue("Passport");
	      cell.setCellStyle(styleTh);
	      cell=row.createCell(2);
	      cell.setCellValue(employee.getPassport());
	      cell.setCellStyle(styleTd);
	      
	      row=spreadsheet.createRow(5);
	      row.setHeight((short) 800);
	      cell=row.createCell(1);
	      cell.setCellValue("Credit card");
	      cell.setCellStyle(styleTh);
	      cell=row.createCell(2);
	      cell.setCellValue(employee.getCreditCard());
	      cell.setCellStyle(styleTd);
	      
	      row=spreadsheet.createRow(6);
	      row.setHeight((short) 800);
	      cell=row.createCell(1);
	      cell.setCellValue("Resume");
	      cell.setCellStyle(styleTh);
	      cell=row.createCell(2);
	      cell.setCellValue(employee.getResume());
	      cell.setCellStyle(styleTd);
	      
	      row=spreadsheet.createRow(7);
	      row.setHeight((short) 800);
	      cell=row.createCell(1);
	      cell.setCellValue("Specialization");
	      cell.setCellStyle(styleTh);
	      cell=row.createCell(2);
	      cell.setCellValue(employee.getSpecialization());
	      cell.setCellStyle(styleTd);
	      
	      row=spreadsheet.createRow(8);
	      row.setHeight((short) 800);
	      cell=row.createCell(1);
	      cell.setCellValue("Salary");
	      cell.setCellStyle(styleTh);
	      cell=row.createCell(2);
	      cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
	      cell.setCellValue((double)employee.getSalary());
	      cell.setCellStyle(styleTd);

	      row=spreadsheet.createRow(9);
	      row.setHeight((short) 800);
	      cell=row.createCell(1);
	      cell.setCellValue("Recruitment date");
	      cell.setCellStyle(styleTh);
	      cell=row.createCell(2);
	      Date rd = new Date();
	      rd = employee.getRecruitmentDate();
	      styleTdDate.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy"));
	      cell.setCellValue(rd);
	      cell.setCellStyle(styleTdDate);

	      row=spreadsheet.createRow(10);
	      row.setHeight((short) 800);
	      cell=row.createCell(1);
	      cell.setCellValue("Contract expiration date");
	      cell.setCellStyle(styleTh);
	      cell=row.createCell(2);
	      Date ced = new Date();
	      ced = employee.getContractExpirationDate();
	      styleTdDate.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy"));
	      cell.setCellValue(ced);
	      cell.setCellStyle(styleTdDate);

	      row=spreadsheet.createRow(11);
	      row.setHeight((short) 800);
	      cell=row.createCell(1);
	      cell.setCellValue("Status");
	      cell.setCellStyle(styleTh);
	      cell=row.createCell(2);
	      cell.setCellValue(employee.getUsers().getRoles().getRole());
	      cell.setCellStyle(styleTd);
	      	      	      	      
	      row = spreadsheet.createRow(12);
	      cell = row.createCell(1);
	      cell.setCellValue("Dream Team");
	      cell.setCellStyle(styleFooter);
	      
	      FileOutputStream out = new FileOutputStream(
	    	      new File("employeedataoutput.xlsx"));
	      workbook.write(out);
	      out.close();
	      isOutput = true;
	      System.out.println(
	    	      "employeedataoutput.xlsx written successfully");
		return isOutput;
	}

}
