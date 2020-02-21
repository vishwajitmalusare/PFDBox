package com.bridgelabz.pdfdoc;

import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class MultiplelinesInPDF {

	public static void main(String args[]) {
		PDDocument document = new PDDocument();
		
		PDPage page = new PDPage();
		document.addPage(page);
	String text = "Anyone, anywhere can open a PDF file."
			+ "All you need is the free Adobe Acrobat Reader."
			+ "Recipient of other file formats sometimes can't open files"
			+ "because they don't have the applications "
			+ "used to create the documents.";	
	
	//Define useful contenets
	int cursorX = 25;
	int cursorY = 700;
	PDFont font = PDType1Font.TIMES_ROMAN;
	int fontSize = 12;
	int margin = 50;
	
	//Using the PDRectangle class get the printableWidth
	PDRectangle mediabox = page.getMediaBox();
	float printableWidth = mediabox.getWidth() - (2 * margin) - cursorX;
	
	//We will caonvert the string content into an array of string/lines
	List<String> finalLines = new ArrayList<>();
	
	try {
// Inside a While loop, check the length of the content Vs the Printable width. If content length is greater,
//then cut the length into the printable width allowed. Add that to the array.Process the remaining content 
//again in loop.
		
		boolean convertContent = true;
		while(convertContent) {
			int contentSize = (int)(fontSize * font.getStringWidth(text)/1000);
			if(contentSize > printableWidth) {
				int contentLength = text.length();
				float rem = contentSize / printableWidth;
				float lenForSubString = contentLength / rem;
				int lenForSubStringInt = (int) Math.floor(lenForSubString);
				finalLines.add(text.substring(0,lenForSubStringInt));
				text = text.substring(lenForSubStringInt);
			}
			else {
				finalLines.add(text);
				convertContent = false;
			}
		}
		
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		contentStream.beginText();
		contentStream.newLineAtOffset(cursorX, cursorY);
		contentStream.setFont(font, fontSize);
		
		//Setting a leading while avoid the overlapping of text.
		contentStream.setLeading(15f);
		
		//Loop the array and print the lines one by one
		
		for(String str : finalLines) {
			contentStream.showText(str);
			contentStream.newLine();
		}
		contentStream.endText();
		contentStream.close();
		
		document.save("/home/admin1/Downloads/Vish/bdzl/MyPDFs/MultilinePDF.pdf");
		System.out.println("PDF saved at provided path ...");
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error while saving PDF"+e.getMessage());
	}
	}
}
