package com.bridgelabz.pdfdoc;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class AdvanceParsing {

	public static void main(String args[]) throws IOException {
		File file = new File("/home/admin1/Aimage/Resume.pdf");
		PDDocument document = PDDocument.load(file);
		PDPage page = document.getPage(0);

		PDFStreamParser parser = new PDFStreamParser(page);
		parser.parse();
		List<Object> tokens = parser.getTokens();

		for (Object token : tokens) {
			System.out.println("Token " + token.toString());
		}
	}
}