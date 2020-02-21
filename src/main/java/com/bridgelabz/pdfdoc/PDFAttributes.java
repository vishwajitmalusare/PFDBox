package com.bridgelabz.pdfdoc;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;

public class PDFAttributes {

	public static void main(String args[]) throws IOException { 
		//Create PDF
		PDDocument document = new PDDocument();
		
		//Create blank page
		PDPage blankPage = new PDPage();
		
		//Add pages to document
		document.addPage(blankPage);
		document.addPage(blankPage);
	
		//Create object
		PDDocumentInformation pdfInfoObject = document.getDocumentInformation();
		
		//Setting author
		pdfInfoObject.setAuthor("Vishwa");
		
		//Setting the title
		pdfInfoObject.setTitle("Experience PDF Properties");
		
		//setting creator of doc
		pdfInfoObject.setCreator("vish");
		
		//Setting subject
		pdfInfoObject.setSubject("To get PDF Properties");
		
		//Setting calendar date of the document
		Calendar date = new GregorianCalendar();
		date.set(2012,20,02);
		pdfInfoObject.setCreationDate(date);
		
		//Setting modified date
		date.set(2013,20,02);
		pdfInfoObject.setModificationDate(date);
		
		//Setting keywords for document
		pdfInfoObject.setKeywords("Attributes, docAttribute");
		
		//Save the document
		document.save("/home/admin1/Aimage/docAttributes.pdf");
		System.out.println("Attributs added to PDF");
		
		//Get all pdf information
		System.out.println("****************************************************");
		System.out.println("Auther = "+pdfInfoObject.getAuthor());
		System.out.println("Title = "+pdfInfoObject.getTitle());
		System.out.println("Cretor = "+pdfInfoObject.getCreator());
		System.out.println("Subject = "+pdfInfoObject.getSubject());
		System.out.println("Cretion Date = "+pdfInfoObject.getCreationDate());
		System.out.println("Last Modified = "+pdfInfoObject.getModificationDate());
		System.out.println("Attributes to Search = "+pdfInfoObject.getKeywords());
		System.out.println("-----------------------------------------------------------");
		//close document
		document.close();
	}
}