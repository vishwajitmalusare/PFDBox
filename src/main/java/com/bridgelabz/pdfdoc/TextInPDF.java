package com.bridgelabz.pdfdoc;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class TextInPDF {

	public static void main(String args[]) throws IOException {
		
		//Loading existing document
		File file = new File("/home/admin1/Aimage/mydoc.pdf");
		PDDocument document = PDDocument.load(file);
		
		//Retrieving page in PDF
		PDPage page = document.getPage(2);
		System.out.println("After get all pages");
		PDPageContentStream contentStream = new PDPageContentStream(document,page);
		
		//Begin the Content stream
		contentStream.beginText();
		
		//Setting the font the Content stream
		contentStream.setFont( PDType1Font.TIMES_ROMAN, 16);
		
		//Setting leading
		contentStream.setLeading(20.5f);
		
		//Setting the position for the line
		contentStream.newLineAtOffset(100,750);
		// try it contentStream.setLineWidth(0);
		
		String text = "Hello World......!";
		 String textOne = "This is an example of adding text to a page in the pdf document."
		 		+ "we can add as many lines";
		      String textTwo = "as we want like this using the ShowText() method of the "
		      		+ "ContentStream class";
		
		//Adding text in the form of string
		contentStream.showText(text);
		contentStream.newLine();
		contentStream.showText(textOne);
		//new Line
		contentStream.newLine();
		contentStream.showText(textTwo);
		
		//Ending content stream
		contentStream.endText();
		
		System.out.println("Content Added.. in PDF");
		
		//Closing content stream
		contentStream.close();
		
		document.save(new File("/home/admin1/Aimage/mydoc.pdf"));
		
		document.close();
	}
}
