package by.bsuir.spp.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import by.bsuir.spp.entities.Client;

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

public class ClientPDFOutput {

	public boolean sendDataToPDF(Client client) throws DocumentException, FileNotFoundException {
		boolean isOutput = false;
		Document document = new Document();
		PdfWriter.getInstance(document,
		          new FileOutputStream("clientdataoutput.pdf"));
		
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
	    
	    PdfPTable table = new PdfPTable(2);

	    PdfPCell cellTh = new PdfPCell(new Paragraph("Name", fontTh));
        PdfPCell cellTd = new PdfPCell(new Paragraph(client.getUsers().getName(), fontTd));
        cellTh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTh.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTh.setPadding(5);
        cellTd.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTd.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTd.setPadding(5);
        table.addCell(cellTh);
        table.addCell(cellTd);
        
        cellTh = new PdfPCell(new Paragraph("Payment Credentials", fontTh));
        cellTd = new PdfPCell(new Paragraph(client.getPaymentCredentials(), fontTd));
        cellTh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTh.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTh.setPadding(5);
        cellTd.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTd.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTd.setPadding(5);
        table.addCell(cellTh);
        table.addCell(cellTd);
        
        cellTh = new PdfPCell(new Paragraph("Phone", fontTh));
        cellTd = new PdfPCell(new Paragraph(client.getPhone(), fontTd));
        cellTh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTh.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTh.setPadding(5);
        cellTd.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTd.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTd.setPadding(5);
        table.addCell(cellTh);
        table.addCell(cellTd);
        
        cellTh = new PdfPCell(new Paragraph("e-Mail", fontTh));
        cellTd = new PdfPCell(new Paragraph(client.getEmail(), fontTd));
        cellTh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTh.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTh.setPadding(5);
        cellTd.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTd.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTd.setPadding(5);
        table.addCell(cellTh);
        table.addCell(cellTd);
        
        cellTh = new PdfPCell(new Paragraph("Address", fontTh));
        cellTd = new PdfPCell(new Paragraph(client.getAddress(), fontTd));
        cellTh.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTh.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTh.setPadding(5);
        cellTd.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTd.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cellTd.setPadding(5);
        table.addCell(cellTh);
        table.addCell(cellTd);
        
        cellTh = new PdfPCell(new Paragraph("Discount", fontTh));
        cellTd = new PdfPCell(new Paragraph(String.valueOf(client.getDiscount()), fontTd));
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
	    System.out.println("clientdataoutput.pdf written successfully");
		return isOutput;
	}

}
