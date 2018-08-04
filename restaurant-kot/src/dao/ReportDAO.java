/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Phrase;
import entity.Report;
import java.awt.Desktop;
import java.io.File;
import java.util.Vector;
import javax.swing.JOptionPane;
import services.ReportService;

/**
 *
 * @author itsSa
 */
public class ReportDAO {
    private ReportService reportService;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    public ReportDAO() {
    }

    public void printCashReport(Vector<Report> vectorCashReport, String toDate, String fromDate) {
            reportService = new ReportService();
            Vector<Report> vectorOfTotalCash = reportService.getOfTotalCashVector(fromDate, toDate);
        try {
            PdfWriter writer = new PdfWriter("./from " + fromDate + " To " + toDate + " Sales On Cash Report.pdf");
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document layoutDocument = new Document(pdfDocument);
            pdfDocument.setDefaultPageSize(PageSize.A4);
            PdfPage pdfPage = pdfDocument.addNewPage();
            // Creating a PdfCanvas object       
            PdfCanvas canvas = new PdfCanvas(pdfPage);

            // Initial point of the line1       
            canvas.moveTo(0, 780);
            // Drawing the line 1      
            canvas.lineTo(700, 780);

            layoutDocument.add(new Paragraph("Sales Report").setTextAlignment(TextAlignment.CENTER));
            layoutDocument.add(new Paragraph("THE WAITERS RESTAURENT").setBold().setTextAlignment(TextAlignment.CENTER));
            layoutDocument.add(new Paragraph("Deans Trade Centre Peshawar").setTextAlignment(TextAlignment.CENTER));
            layoutDocument.add(new Paragraph("CASH Sales").setTextAlignment(TextAlignment.CENTER));

            //New Table
            Table table = new Table(UnitValue.createPointArray(new float[]{60f, 160f, 110f, 80f, 80f}));
            table.setTextAlignment(TextAlignment.CENTER);
            table.setHorizontalAlignment(HorizontalAlignment.CENTER);
            table.setBorder(new SolidBorder(2));
            
            //headers
            table.addCell(new Paragraph("S.N.O").setBold());
            table.addCell(new Paragraph("Total Amount Receivable").setBold());
            table.addCell(new Paragraph("Discount Amount").setBold());
            table.addCell(new Paragraph("Net Amount").setBold());
            table.addCell(new Paragraph("Date").setBold());
            int serial =1;
            //Now Add Data Into these table Columns 
            for (Report report : vectorCashReport) {
                
                table.addCell(new Paragraph(serial+""));
                table.addCell(new Paragraph(report.getTotalAmountReceivable()));
                table.addCell(new Paragraph(report.getDiscountAmount()));
                table.addCell(new Paragraph(report.getNetAmount()));
                table.addCell(new Paragraph(report.getBillDate()));
                serial++;
            }
            table.addCell(new Cell().add(new Paragraph("Total:")).setTextAlignment(TextAlignment.RIGHT).setBold().setBorder(Border.NO_BORDER));
            table.addCell(new Cell().add(new Paragraph(vectorOfTotalCash.get(0).getTotalOf_recieveable())).setTextAlignment(TextAlignment.CENTER).setBold().setBorder(Border.NO_BORDER));
            table.addCell(new Cell().add(new Paragraph(vectorOfTotalCash.get(0).getTotalOf_discountAmount())).setTextAlignment(TextAlignment.CENTER).setBold().setBorder(Border.NO_BORDER));
            table.addCell(new Cell().add(new Paragraph(vectorOfTotalCash.get(0).getTotalOf_netAmount())).setTextAlignment(TextAlignment.CENTER).setBold().setBorder(Border.NO_BORDER));
            table.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
            layoutDocument.add(table);
            
            layoutDocument.add(new Paragraph("\n Bill Number: _____________").setTextAlignment(TextAlignment.RIGHT));
            layoutDocument.add(new Paragraph("\n\n\n"));
            layoutDocument.add(new Paragraph("Signature: _________________").setBold());
            
            
            
            
            
            // Closing the path stroke       
            canvas.closePathStroke();
            layoutDocument.close();

            File pdfFile = new File("./from " + fromDate + " To " + toDate + " Sales On Cash Report.pdf");
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                    System.out.println("File Has Been Opened Successfully!");
                } else {
                    System.out.println("Desktop Not Supported!");
                }
            } else {
                System.out.println("PDF File Is Not Generated");
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

}
