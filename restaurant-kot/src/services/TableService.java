/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import dao.TablesDAO;
import entity.Tables;
import java.awt.Desktop;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import util.SQLQueryUtil;

/**
 *
 * @author Muhammad Nasar
 */
public class TableService {
    private TablesDAO tablesDao ;
    
    public TableService(){
        tablesDao = new TablesDAO() ;
    }
    
    public int chickTableNumber(Tables tables){
        SQLQueryUtil sqlutil = new SQLQueryUtil();
        sqlutil.connect(false);

        int rowsAffected = 0;
        int count = 0;
        
        if (tables.getTableNumber().equals("")  ) {
            JOptionPane.showMessageDialog(null, "Empty data can not be saved.");
        } else {

            String queryCheck = "SELECT COUNT(*) AS `count` FROM `tables` WHERE `table_number` LIKE('" + tables.getTableNumber() + "');";
            try {
                ResultSet resultSet = sqlutil.executeQuery(queryCheck);
                resultSet.next();

                count = resultSet.getInt("count");

                if (count == 0) {
                    rowsAffected = tablesDao.registerTablesNumber(tables);
                } else {
                    JOptionPane.showMessageDialog(null, tables.getTableNumber() + " Already exists.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                sqlutil.disconnect();
            }
        }

        return rowsAffected;
        
    }
    
    public int updateTableNumber(Tables tables) {
        int isUpdated =0;
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        
        if (tables.getTableNumber().equals("")) {
            JOptionPane.showMessageDialog(null, "Empty Data Cant Be Stored!");
        } else {
        int rowsAffected =0;
        int count = 0;
        String queryCheck = "SELECT COUNT(*) AS `count` FROM `tables` WHERE `table_number` LIKE('" + tables.getTableNumber() + "');";
        
        try {
            ResultSet resultSet = sql.executeQuery(queryCheck);
            resultSet.next();
            count = resultSet.getInt("count");
            if (count ==0) {
                isUpdated = tablesDao.updateTableNumber(tables);
                if ( isUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Menu Item Updated Successfully!");
                } else if ( isUpdated ==0 || isUpdated <0) {
                    JOptionPane.showMessageDialog(null, "Operation Failed");
                }
            } else {
                JOptionPane.showMessageDialog(null, tables.getTableNumber()+" Already Existed!");
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
        }
        
        return isUpdated;
        
    }
    
    public void printAllTables () {
         CommonService commonService = new CommonService();
         Vector<Tables> tablesNumber = commonService.getVectorTables();
        
         try {
             PdfDocument pdfDocument = new PdfDocument(new PdfWriter("./all_tables_number.pdf"));
             Document layoutDocument = new Document(pdfDocument);
            
             //title
             layoutDocument.add(new Paragraph("ALL Tables Number").setBold().setUnderline()
                    .setTextAlignment(TextAlignment.CENTER));
            
            //other reference information
            layoutDocument.add(new Paragraph("THE WAITERS RESTAURANT")
                    .setTextAlignment(TextAlignment.LEFT).setMultipliedLeading(0.2f).setBold());
            layoutDocument.add(new Paragraph("PESHAWAR").setMultipliedLeading(.2f));
            layoutDocument.add(new Paragraph("Phone# 091-123456789").setMultipliedLeading(.2f));
            
            //create items to add into pdf
            //create a table to display items into tabular form
            
            Table table = new Table(UnitValue.createPointArray(new float[]{60f,180f,60f}));
            
            //headers
            table.addCell(new Paragraph("S.N.O").setBold());
            table.addCell(new Paragraph("Tables Number").setBold());
            table.addCell(new Paragraph("Is Available").setBold());
            
            //Now Add Data Into these table Columns 
            for (Tables tables : tablesNumber) {
                table.addCell(new Paragraph(tables.getTableId()+""));
                table.addCell(new Paragraph(tables.getTableNumber()+""));
                table.addCell(new Paragraph(tables.getAsAvailable()+""));
            }
            
            // add table to pdf
            layoutDocument.add(table);
            
            //close document
            layoutDocument.close();
            
            //now opening it in browser to print
            
            File pdfFile =  new File("./all_tables_number.pdf");
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                    System.out.println("File Has Been Opened Successfully!");   
                } else {
                    System.out.println("Desktop Not Supported!");
                }
            } else {
                System.out.println("File Is Not Generated Successfully");
            }
            
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }        
       
    
}
