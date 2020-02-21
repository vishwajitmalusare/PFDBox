package com.bridgelabz.pdfdoc;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class CreateDoc {

	public static void main(String[] args) throws IOException {
	
		// Creating pdf document
		//PDDocument document = new PDDocument();
		
		// Creating page
		PDPage blankPage = new PDPage();
		System.out.println("PDF Successfully Created.....");

		//Load the document
		File file = new File("/home/admin1/Aimage/mydoc.pdf");
		PDDocument document = PDDocument.load(file);
		System.out.println("Document loaded....");
		
		// Add a blank page in doc
		document.addPage(blankPage);
		document.addPage(blankPage);
		document.addPage(blankPage);
		System.out.println("Page added to document successfully....");

		//get the number of pages in doc
		int numberOfPages = document.getNumberOfPages();
		System.out.println("Number of pages in document is = "+numberOfPages);
		//removing page from loaded doc
		
		//document.removePage(1);
		//System.out.println("page number 5 removed");
		
		// saving document
		document.save("/home/admin1/Aimage/mydoc.pdf");
		System.out.println("Document saved...");

		// cloSEe doc
		document.close();
	}
}