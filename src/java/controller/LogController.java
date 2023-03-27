package controller;

import model.DBConnection;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import model.Footer;
import model.User;
/**
 *
 * @author Thomas Jefferson Qiu
 */
@WebServlet(name = "GenerateReportPage.jsp")
public class LogController extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection connection;
        
        HttpSession session = request.getSession();
        User name = (User) session.getAttribute("user"); 
        
        String select = request.getParameter("select");
        String Generate = request.getParameter("Generate");
        
        switch(select) {
            case "students":
            if(Generate.equals("Generate")){
                try {
                    String timestart = request.getParameter("start");
                    String timeend = request.getParameter("end"); 
                    
                    
                    response.setContentType("application/pdf");
                    response.setHeader("Content-disposition", "inline; filename=Generated Visitors.pdf");
                    //OutputStream files = new FileOutputStream(new File("C:/Users/Thomas Jefferson Qiu/Documents/zzzz/Generated Visitors.pdf"));
                    Document documents = new Document();
                    PdfWriter writers = PdfWriter.getInstance(documents, response.getOutputStream());
                    documents.open();
                
                    if(timestart != null && timeend != null){
                                    
                        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                        TemporalAccessor start = format.parse(timestart);
                        TemporalAccessor end = format.parse(timeend);
                
                        DateTimeFormatter output = DateTimeFormatter.ofPattern("MM/dd/uuuu hh:mm a");
                        String formattedstart = output.format(start);
                        String formattedend = output.format(end);
                
                        connection = DBConnection.getConnection();
                        String entry = "SELECT * FROM studententrylog WHERE timestamp BETWEEN ? AND ?";
                        String exit = "SELECT * FROM studentexitlog WHERE timestamp BETWEEN ? AND ?";
                        String ssl = "SELECT * FROM sslog WHERE timestamp BETWEEN ? AND ?";
                        String al = "SELECT * FROM adminlog WHERE timestamp BETWEEN ? AND ?";
                
                        PreparedStatement stmte = connection.prepareStatement(entry);
                        stmte.setString(1, formattedstart);
                        stmte.setString(2, formattedend);
                        ResultSet rse = stmte.executeQuery();
                
                        PreparedStatement stmtx = connection.prepareStatement(exit);
                        stmtx.setString(1, formattedstart);
                        stmtx.setString(2, formattedend);
                        ResultSet rsx = stmtx.executeQuery();
                
                        PreparedStatement stmtsl = connection.prepareStatement(ssl);
                        stmtsl.setString(1, formattedstart);
                        stmtsl.setString(2, formattedend);
                        ResultSet rssl = stmtsl.executeQuery();
                
                        PreparedStatement stmtal = connection.prepareStatement(al);
                        stmtal.setString(1, formattedstart);
                        stmtal.setString(2, formattedend);
                        ResultSet rsal = stmtal.executeQuery();
                
                        String localDateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/uuuu hh:mm a"));
                        Paragraph title = new Paragraph();
                        documents.add(new Paragraph(" "));
                        title.add(new Paragraph("Visitor Log Report"));
                        documents.add(new Paragraph(" "));
                        title.add(new Paragraph("Report generated on " + localDateString + " - " + name.getUsername()));
                
                
                        documents.add(title);
                
                
                        PdfPTable tablee = new PdfPTable(3);
                        documents.add(new Paragraph("Student Entry Logs"));
                        documents.add(new Paragraph(" "));
                        PdfPCell headerCelle1 = new PdfPCell(new Phrase("Student Number"));
                        PdfPCell headerCelle2 = new PdfPCell(new Phrase("Entry Type"));
                        PdfPCell headerCelle3 = new PdfPCell(new Phrase("Timestamp"));
                        tablee.addCell(headerCelle1);
                        tablee.addCell(headerCelle2);
                        tablee.addCell(headerCelle3);

                        while (rse.next()) {
                        String column1 = rse.getString("SN");
                        String column2 = rse.getString("ENTRYTYPE");
                        String column3 = rse.getString("TIMESTAMP");

                        PdfPCell cell1 = new PdfPCell(new Paragraph(column1));
                        PdfPCell cell2 = new PdfPCell(new Paragraph(column2));
                        PdfPCell cell3 = new PdfPCell(new Paragraph(column3));
                        tablee.addCell(cell1);
                        tablee.addCell(cell2);
                        tablee.addCell(cell3);
                    }
                        documents.add(tablee);

                        PdfPTable tablex = new PdfPTable(4);
                        documents.add(new Paragraph("Student Exit Logs"));
                        documents.add(new Paragraph(" "));
                        PdfPCell headerCellx1 = new PdfPCell(new Phrase("Student Number"));
                        PdfPCell headerCellx2 = new PdfPCell(new Phrase("Entry Type"));
                        PdfPCell headerCellx3 = new PdfPCell(new Phrase("Timestamp"));
                        PdfPCell headerCellx4 = new PdfPCell(new Phrase("Equipments"));
                        tablex.addCell(headerCellx1);
                        tablex.addCell(headerCellx2);
                        tablex.addCell(headerCellx3);
                        tablex.addCell(headerCellx4);

                        while (rsx.next()){
                        String column1 = rsx.getString("SN");
                        String column2 = rsx.getString("ENTRYTYPE");
                        String column3 = rsx.getString("TIMESTAMP");
                        String column4 = rsx.getString("EQUIPMENTS");

                        PdfPCell cell1 = new PdfPCell(new Paragraph(column1));
                        PdfPCell cell2 = new PdfPCell(new Paragraph(column2));
                        PdfPCell cell3 = new PdfPCell(new Paragraph(column3));
                        PdfPCell cell4 = new PdfPCell(new Paragraph(column4));
                        tablex.addCell(cell1);
                        tablex.addCell(cell2);
                        tablex.addCell(cell3);
                        tablex.addCell(cell4);
                    }
                        documents.add(tablex);

                        PdfPTable tablesl = new PdfPTable(3);
                        documents.add(new Paragraph("Support Staff Logs"));
                        documents.add(new Paragraph(" "));
                        PdfPCell headerCellsl1 = new PdfPCell(new Phrase("Name"));
                        PdfPCell headerCellsl2 = new PdfPCell(new Phrase("Timestamp"));
                        PdfPCell headerCellsl3 = new PdfPCell(new Phrase("Edit History"));
                        tablesl.addCell(headerCellsl1);
                        tablesl.addCell(headerCellsl2);
                        tablesl.addCell(headerCellsl3);

                        while (rssl.next()){
                        String column1 = rssl.getString("NAME");
                        String column2 = rssl.getString("TIMESTAMP");
                        String column3 = rssl.getString("EDIT_HISTORY");

                        PdfPCell cell1 = new PdfPCell(new Paragraph(column1));
                        PdfPCell cell2 = new PdfPCell(new Paragraph(column2));
                        PdfPCell cell3 = new PdfPCell(new Paragraph(column3));
                        tablesl.addCell(cell1);
                        tablesl.addCell(cell2);
                        tablesl.addCell(cell3);
                    }
                        documents.add(tablesl);

                        PdfPTable tableal = new PdfPTable(3);
                        documents.add(new Paragraph("Administrator Logs"));
                        documents.add(new Paragraph(" "));
                        PdfPCell headerCellal1 = new PdfPCell(new Phrase("Name"));
                        PdfPCell headerCellal2 = new PdfPCell(new Phrase("Timestamp"));
                        PdfPCell headerCellal3 = new PdfPCell(new Phrase("Edit History"));
                        tableal.addCell(headerCellal1);
                        tableal.addCell(headerCellal2);
                        tableal.addCell(headerCellal3);

                        while (rsal.next()){
                        String column1 = rsal.getString("NAME");
                        String column2 = rsal.getString("TIMESTAMP");
                        String column3 = rsal.getString("EDIT_HISTORY");

                        PdfPCell cell1 = new PdfPCell(new Paragraph(column1));
                        PdfPCell cell2 = new PdfPCell(new Paragraph(column2));
                        PdfPCell cell3 = new PdfPCell(new Paragraph(column3));
                        tableal.addCell(cell1);
                        tableal.addCell(cell2);
                        tableal.addCell(cell3);
                    }
                        documents.add(tableal); 

                    Footer event = new Footer();
                    writers.setPageEvent(event);

                    documents.close();
                    //files.close();
                    rse.close();
                    rsx.close();
                    rssl.close();
                    rsal.close();
                    connection.close();


                    }
                    else{
                        response.sendRedirect("505error.jsp");
                    }
                } catch (DocumentException e) {
                } catch (SQLException ex) {
                Logger.getLogger(LogController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else{
                response.sendRedirect("505error.jsp");
            }
            break;
            
            case "trainers":
                if(Generate.equals("Generate")){
                    try {
                    
                    response.setContentType("application/pdf");
                    response.setHeader("Content-disposition", "inline; filename=Generated Trainers.pdf");
                    //OutputStream filet = new FileOutputStream(new File("C:/Users/Thomas Jefferson Qiu/Documents/zzzz/Generated Trainers.pdf"));
                    Document documentt = new Document();
                    PdfWriter writert = PdfWriter.getInstance(documentt, response.getOutputStream());
                    documentt.open();

                    connection = DBConnection.getConnection();

                    String trainers = "SELECT * FROM trainers";

                    PreparedStatement stmtt = connection.prepareStatement(trainers);
                    ResultSet rst = stmtt.executeQuery();


                    String localDateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/uuuu hh:mm a"));
                    Paragraph title = new Paragraph();
                    documentt.add(new Paragraph(" "));
                    title.add(new Paragraph("Trainer Log Report"));
                    documentt.add(new Paragraph(" "));
                    title.add(new Paragraph("Report generated on " + localDateString + " - "+ name.getUsername()));


                    documentt.add(title);

                    // Add report data to PDF document

                        PdfPTable tablet = new PdfPTable(3);
                        documentt.add(new Paragraph("Trainers"));
                        documentt.add(new Paragraph(" "));
                        PdfPCell headerCell1 = new PdfPCell(new Phrase("Name"));
                        PdfPCell headerCell2 = new PdfPCell(new Phrase("Specialty"));
                        PdfPCell headerCell3 = new PdfPCell(new Phrase("Sport"));
                        tablet.addCell(headerCell1);
                        tablet.addCell(headerCell2);
                        tablet.addCell(headerCell3);

                        while (rst.next()) {
                        String column1 = rst.getString("NAME");
                        String column2 = rst.getString("SPECIALTY");
                        String column3 = rst.getString("SPORT");

                        PdfPCell cell1 = new PdfPCell(new Paragraph(column1));
                        PdfPCell cell2 = new PdfPCell(new Paragraph(column2));
                        PdfPCell cell3 = new PdfPCell(new Paragraph(column3));
                        tablet.addCell(cell1);
                        tablet.addCell(cell2);
                        tablet.addCell(cell3);
                    }
                        documentt.add(tablet);

                    Footer event = new Footer();
                    writert.setPageEvent(event);

                    documentt.close();
                    //filet.close();
                    rst.close();
                    connection.close();


                } catch (DocumentException e) {
                } catch (SQLException ex) {
                Logger.getLogger(LogController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }else{
                    response.sendRedirect("505error.jsp");
                }
            break;
            
            case "equipments":
                if(Generate.equals("Generate")){
                try {
                    
                    response.setContentType("application/pdf");
                    response.setHeader("Content-disposition", "inline; filename=Generated Equipments.pdf");
                    //OutputStream filee = new FileOutputStream(new File("C:/Users/Thomas Jefferson Qiu/Documents/zzzz/Generated Equipments.pdf"));
                    Document documente = new Document();
                    PdfWriter writere =PdfWriter.getInstance(documente, response.getOutputStream());
                    documente.open();

                    connection = DBConnection.getConnection();

                    String equipment = "SELECT * FROM equipments";

                    PreparedStatement stmteq = connection.prepareStatement(equipment);
                    ResultSet rseq = stmteq.executeQuery();


                    String localDateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/uuuu hh:mm a"));
                    Paragraph title = new Paragraph();
                    documente.add(new Paragraph(" "));
                    title.add(new Paragraph("Equipment Log Report"));
                    documente.add(new Paragraph(" "));
                    title.add(new Paragraph("Report generated on " + localDateString + " - "+ name.getUsername()));


                    documente.add(title);

                    // Add report data to PDF document

                        PdfPTable tableeq = new PdfPTable(3);
                        documente.add(new Paragraph("Equipments"));
                        documente.add(new Paragraph(" "));
                        PdfPCell headerCell1 = new PdfPCell(new Phrase("Name"));
                        PdfPCell headerCell2 = new PdfPCell(new Phrase("Recommendation"));
                        PdfPCell headerCell3 = new PdfPCell(new Phrase("Quantity"));
                        tableeq.addCell(headerCell1);
                        tableeq.addCell(headerCell2);
                        tableeq.addCell(headerCell3);

                        while (rseq.next()) {
                        String column1 = rseq.getString("NAME");
                        String column2 = rseq.getString("RECOMMENDATION");
                        String column3 = rseq.getString("QUANTITY");

                        PdfPCell cell1 = new PdfPCell(new Paragraph(column1));
                        PdfPCell cell2 = new PdfPCell(new Paragraph(column2));
                        PdfPCell cell3 = new PdfPCell(new Paragraph(column3));
                        tableeq.addCell(cell1);
                        tableeq.addCell(cell2);
                        tableeq.addCell(cell3);
                    }
                        documente.add(tableeq);

                    Footer event = new Footer();
                    writere.setPageEvent(event);

                    documente.close();
                    //filee.close();
                    rseq.close();
                    connection.close();


                } catch (DocumentException e) {
                } catch (SQLException ex) {
                Logger.getLogger(LogController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }else{
                response.sendRedirect("505error.jsp");
                }
            break;
            
            default:
            response.sendRedirect("505error.jsp");
            break;
        }
    }
}