package com.bridgelabz.pdfdoc;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class InsertImage {

	public static void main(String args[]) throws IOException {
		File file = new File("/home/admin1/Aimage/mydoc.pdf");
		PDDocument document = PDDocument.load(file);
		
		//Retrieving the page
		PDPage page = document.getPage(0);
		
		//Creating PDImageXObject object
		PDImageXObject pdImage = PDImageXObject.createFromFile("/home/admin1/Aimage/download.jpeg", document);
		
		//Create the PDPageContentStream object
		PDPageContentStream contents = new PDPageContentStream(document, page);
		
		//Drawing image in the PDF document
		contents.drawImage(pdImage, 300, 650);
		
		System.out.println("Image inserted");
		
		//Closing the PDPageContentStream object
		contents.close();
		
		document.save(file);
		
		document.close();
	}

}