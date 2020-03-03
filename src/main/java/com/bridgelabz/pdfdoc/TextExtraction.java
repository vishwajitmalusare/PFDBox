package com.bridgelabz.pdfdoc;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class TextExtraction {

	public static void main(String args[]) throws IOException {
		
		File file = new File("/home/admin1/Aimage/Resume.pdf");
		PDDocument document = PDDocument.load(file);
		
		//Instantiate PDFTextStripper class
		PDFTextStripper pdfStripper = new PDFTextStripper();
		
		// set number of pages to read specfic page
		pdfStripper.setStartPage(3);
		pdfStripper.setEndPage(3);
		
		//Retrieving text from PDF document
		String text = pdfStripper.getText(document);
		System.out.println();
		System.out.println(text);
		System.out.println();
				
		document.close();
	}
}
