package model;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class Footer extends PdfPageEventHelper {
    public void onEndPage(PdfWriter writer, Document document) {
    // Create a Phrase object with the text to add to the footer
    Phrase footer = new Phrase("Page " + writer.getPageNumber());

    // Add the text to the center of the footer
    float x = (document.right() - document.left()) / 2 + document.leftMargin();
    float y = document.bottomMargin() - 10;
    ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, footer, x, y, 0);
  }
}