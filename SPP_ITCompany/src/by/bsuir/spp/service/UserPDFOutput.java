package by.bsuir.spp.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

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

import by.bsuir.spp.entities.Users;

public class UserPDFOutput {

	public boolean sendDataToPDF(List<Users> userList) throws DocumentException, FileNotFoundException {
		boolean isOutput = false;
		Document document = new Document();
		PdfWriter.getInstance(document,
		          new FileOutputStream("userlistoutput.pdf"));
		
		Font fontHeader = new Font(Font.FontFamily.HELVETICA, 30, Font.ITALIC, BaseColor.BLUE);
		Font fontFooter = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.BLUE);
		Font fontTh = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		Font fontTd = new Font(Font.FontFamily.TIMES_ROMAN, 12);
		
		document.open();
		
	    Paragraph paragraphHeader = new Paragraph();
	    paragraphHeader.setSpacingAfter(50);
	    paragraphHeader.setSpacingBefore(50);
	    paragraphHeader.setAlignment(Element.ALIGN_CENTER);
	    Chunk chunk = new Chunk("Client Data", fontHeader);
	    paragraphHeader.add(chunk);
	    document.add(paragraphHeader);
	    
	    PdfPTable table = new PdfPTable(3);
	    
	    PdfPCell cellTh = new PdfPCell(new Paragraph("ID", fontTh));
	    cellTh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTh.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTh.setPadding(5);
        table.addCell(cellTh);
        
        cellTh = new PdfPCell(new Paragraph("User", fontTh));
	    cellTh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTh.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTh.setPadding(5);
        table.addCell(cellTh);

        cellTh = new PdfPCell(new Paragraph("Status", fontTh));
	    cellTh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTh.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTh.setPadding(5);
        table.addCell(cellTh);
        
        PdfPCell cellTd = new PdfPCell();
        if (!userList.isEmpty()) {
	    	  for (Users user: userList) {
	    		  cellTd = new PdfPCell(new Paragraph(String.valueOf(user.getId()), fontTd));
	    		  cellTd.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	      cellTd.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    	      cellTd.setPadding(5);
	    	      table.addCell(cellTd);
	    	      
	    	      cellTd = new PdfPCell(new Paragraph(user.getName(), fontTd));
	    		  cellTd.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	      cellTd.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    	      cellTd.setPadding(5);
	    	      table.addCell(cellTd);
	    	      
	    	      cellTd = new PdfPCell(new Paragraph(user.getRoles().getRole(), fontTd));
	    		  cellTd.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	      cellTd.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    	      cellTd.setPadding(5);
	    	      table.addCell(cellTd);
	    	  }
        }

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
	    System.out.println("userlistoutput.pdf written successfully");
		return isOutput;
	}

}
