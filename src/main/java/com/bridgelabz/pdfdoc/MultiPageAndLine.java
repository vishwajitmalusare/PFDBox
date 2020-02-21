package com.bridgelabz.pdfdoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class MultiPageAndLine {
//a source text file 
	public static final String SOURCE_FILE = "/home/admin1/Downloads/Vish/bdzl/MyPDFs/Source.txt";
	public static final String CREATED_PDF = "/home/admin1/Downloads/Vish/bdzl/MyPDFs/Content.pdf";
	static double currentHeight = 0;
	static PDPageContentStream cs = null;

	public static void main(String args[]) {
		try {
			PDDocument pdfDoc = new PDDocument();
			// For text File
			BufferedReader br = new BufferedReader(new FileReader(SOURCE_FILE));
			PDPage page = new PDPage();

			pdfDoc.addPage(page);
			String line;
			cs = new PDPageContentStream(pdfDoc, page);
			cs.beginText();
			cs.setFont(PDType1Font.TIMES_ROMAN, 20);
			cs.newLineAtOffset(20, 750);
			cs.setLeading(12f+20);

			// Read text line by line
			while ((line = br.readLine()) != null) {
				System.out.println("Line-- " + line);
				showMultiLineText(pdfDoc, line, 20, 750, 580, 820, page, PDType1Font.TIMES_ROMAN, 23);
			}
			if (cs != null) {
				cs.endText();
				cs.close();
			}
			pdfDoc.save(CREATED_PDF);
			br.close();
			pdfDoc.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void showMultiLineText(PDDocument pdfDoc, String text, int x, int y, int allowedWidth,
			double allowedHeight, PDPage page, PDFont font, int fontSize) throws IOException {
		List<String> lines = new ArrayList<String>();
		String line = "";

		// splits the text on space
		String[] words = text.split(" ");
		for (String word : words) {
			if (!line.isEmpty()) {
				line += " ";
			}
			// check if adding the word to the line surprass the width of the page
			int size = (int) (fontSize * font.getStringWidth(line + word) / 1000);
			if (size > allowedWidth) {
				// if line + word surprass the width of the page, add the line without the
				// current word
				lines.add(line);
				// Start new line with the current word
				line = word;
			} else {
				// if line + word fits the page width, add the current word to the line
				line += word;
			}
		}
		lines.add(line);

		for (String ln : lines) {
			System.out.println("Line- " + ln);
			// for each line add line height to current height
			// line height = 1.2 * fontsize id taken here
			currentHeight = currentHeight + 1.2 * fontSize;
			System.out.println("currentHeight " + currentHeight);

			if (currentHeight >= allowedHeight) {
				System.out.println("adding new page " + currentHeight);
				// When current height is more than allowes height for the page
				// create new page
				page = new PDPage();
				pdfDoc.addPage(page);
				// reset currentHeight
				currentHeight = 0;
				cs.endText();
				cs.close();
				cs = new PDPageContentStream(pdfDoc, page);
				cs.beginText();
				cs.setFont(PDType1Font.TIMES_ROMAN, 20);
				cs.newLineAtOffset(20, 750);
				cs.setLeading(12+20);

			}
			cs.showText(ln);
			cs.newLine();
		}
	}
}