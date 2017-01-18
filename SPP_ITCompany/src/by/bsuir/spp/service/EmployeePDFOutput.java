package by.bsuir.spp.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import by.bsuir.spp.entities.Employee;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class EmployeePDFOutput {

	public boolean sendDataToPDF(Employee employee) throws DocumentException, FileNotFoundException {
		boolean isOutput = false;
		Document document = new Document();
		PdfWriter.getInstance(document,
		          new FileOutputStream("employeedataoutput.pdf"));
		
		Font fontHeader = new Font(Font.FontFamily.HELVETICA, 30, Font.ITALIC, BaseColor.BLUE);
		Font fontFooter = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLUE);
		Font fontTh = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		Font fontTd = new Font(Font.FontFamily.TIMES_ROMAN, 12);
		
		document.open();
		
	    Paragraph paragraphHeader = new Paragraph();
	    paragraphHeader.setSpacingAfter(50);
	    paragraphHeader.setSpacingBefore(50);
	    paragraphHeader.setAlignment(Element.ALIGN_CENTER);
	    Chunk chunk = new Chunk("Employee Data", fontHeader);
	    paragraphHeader.add(chunk);
	    document.add(paragraphHeader);
	    
	    PdfPTable table = new PdfPTable(2);

	    PdfPCell cellTh = new PdfPCell(new Paragraph("Name", fontTh));
        PdfPCell cellTd = new PdfPCell(new Paragraph(employee.getUsers().getName(), fontTd));
        cellTh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTh.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTh.setPadding(5);
        cellTd.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTd.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTd.setPadding(5);
        table.addCell(cellTh);
        table.addCell(cellTd);
        
        cellTh = new PdfPCell(new Paragraph("Address", fontTh));
        cellTd = new PdfPCell(new Paragraph(employee.getAddress(), fontTd));
        cellTh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTh.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTh.setPadding(5);
        cellTd.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTd.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTd.setPadding(5);
        table.addCell(cellTh);
        table.addCell(cellTd);
        
        cellTh = new PdfPCell(new Paragraph("Phone", fontTh));
        cellTd = new PdfPCell(new Paragraph(employee.getPhone(), fontTd));
        cellTh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTh.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTh.setPadding(5);
        cellTd.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTd.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTd.setPadding(5);
        table.addCell(cellTh);
        table.addCell(cellTd);
        
        cellTh = new PdfPCell(new Paragraph("Passport", fontTh));
        cellTd = new PdfPCell(new Paragraph(employee.getPassport(), fontTd));
        cellTh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTh.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTh.setPadding(5);
        cellTd.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTd.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTd.setPadding(5);
        table.addCell(cellTh);
        table.addCell(cellTd);
        
        cellTh = new PdfPCell(new Paragraph("Credit card", fontTh));
        cellTd = new PdfPCell(new Paragraph(employee.getCreditCard(), fontTd));
        cellTh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTh.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTh.setPadding(5);
        cellTd.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTd.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTd.setPadding(5);
        table.addCell(cellTh);
        table.addCell(cellTd);

        cellTh = new PdfPCell(new Paragraph("Resume", fontTh));
        cellTd = new PdfPCell(new Paragraph(employee.getResume(), fontTd));
        cellTh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTh.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTh.setPadding(5);
        cellTd.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTd.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTd.setPadding(5);
        table.addCell(cellTh);
        table.addCell(cellTd);

        cellTh = new PdfPCell(new Paragraph("Specialization", fontTh));
        cellTd = new PdfPCell(new Paragraph(employee.getSpecialization(), fontTd));
        cellTh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTh.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTh.setPadding(5);
        cellTd.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTd.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTd.setPadding(5);
        table.addCell(cellTh);
        table.addCell(cellTd);
                
        cellTh = new PdfPCell(new Paragraph("Salary", fontTh));
        cellTd = new PdfPCell(new Paragraph(String.valueOf(employee.getSalary()), fontTd));
        cellTh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTh.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTh.setPadding(5);
        cellTd.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTd.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTd.setPadding(5);
        table.addCell(cellTh);
        table.addCell(cellTd);
        
        cellTh = new PdfPCell(new Paragraph("Recruitment date", fontTh));
        cellTd = new PdfPCell(new Paragraph(String.valueOf(employee.getRecruitmentDate()), fontTd));
        cellTh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTh.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTh.setPadding(5);
        cellTd.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTd.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTd.setPadding(5);
        table.addCell(cellTh);
        table.addCell(cellTd);

        cellTh = new PdfPCell(new Paragraph("Contract expiration date", fontTh));
        cellTd = new PdfPCell(new Paragraph(String.valueOf(employee.getContractExpirationDate()), fontTd));
        cellTh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTh.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTh.setPadding(5);
        cellTd.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTd.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTd.setPadding(5);
        table.addCell(cellTh);
        table.addCell(cellTd);

        cellTh = new PdfPCell(new Paragraph("Status", fontTh));
        cellTd = new PdfPCell(new Paragraph(employee.getUsers().getRoles().getRole(), fontTd));
        cellTh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTh.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTh.setPadding(5);
        cellTd.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTd.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTd.setPadding(5);
        table.addCell(cellTh);
        table.addCell(cellTd);
                
        document.add(table);
	    
	    Paragraph paragraphFooter = new Paragraph();
	    paragraphFooter.setSpacingAfter(50);
	    paragraphFooter.setSpacingBefore(50);
	    paragraphFooter.setAlignment(Element.ALIGN_CENTER);
	    chunk = new Chunk("Dream Team", fontFooter);
	    paragraphFooter.add(chunk);
	    document.add(paragraphFooter);
	    
	    document.close();
	    isOutput = true;
	    System.out.println("employeedataoutput.pdf written successfully");
		return isOutput;
	}

}
