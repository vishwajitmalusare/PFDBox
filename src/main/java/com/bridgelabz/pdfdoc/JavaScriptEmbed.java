package com.bridgelabz.pdfdoc;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;

public class JavaScriptEmbed {
	public static void main(String args[]) throws IOException {
		
		File file = new File("/home/admin1/Aimage/jsdoc.pdf");
		PDDocument document = PDDocument.load(file);
		
		String javascript = "app.alert ( {cMsg: 'this is an example' , "
				+ "nIcon: 3, nType: 0, cTitle: 'PDFBox javaScript Example,} ); ";
		
		//CreatingPDActionJavaScript obj
		PDActionJavaScript pDAjavaJavaScript = new PDActionJavaScript(javascript);
		
		//Embed java script
		document.getDocumentCatalog().setOpenAction(pDAjavaJavaScript);
		
		document.save( new File("/home/admin1/Aimage/jsdoc.pdf"));
		System.out.println("JS Inserted");
		
		document.close();
	}
}