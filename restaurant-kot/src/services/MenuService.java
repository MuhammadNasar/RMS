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
import entity.Menu;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.SQLQueryUtil;
import dao.MenuDAO;
import java.awt.Desktop;
import java.io.File;
import java.util.Vector;




/**
 *
 * @author User
 */
public class MenuService {

    private MenuDAO menuDao;

    public MenuService() {
        menuDao = new MenuDAO();
    }

    public int registerMenuItem(Menu menu) {

        SQLQueryUtil sqlutil = new SQLQueryUtil();
        sqlutil.connect(false);

        int rowsAffected = 0;
        int count = 0;
        
            String queryCheck = "SELECT COUNT(*) AS `count` FROM `menu_items` WHERE `item_name` LIKE('" + menu.getMenuName() + "');";
            try {
                ResultSet resultSet = sqlutil.executeQuery(queryCheck);
                resultSet.next();

                count = resultSet.getInt("count");
                System.out.print("\n Count is =" +count);
                if (count == 0) {
                    rowsAffected = menuDao.registerMenuItem(menu);
                } else {
                    JOptionPane.showMessageDialog(null, menu.getMenuName() + " Already exists.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                sqlutil.disconnect();
            }
        return rowsAffected;
        
    }
    public int updateMenuItem (Menu menu) {
        int isUpdated =0;
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        
        if (menu.getMenuName().equals("") || menu.getPrice() < 0 ) {
            JOptionPane.showMessageDialog(null, "Empty Data Cant Be Stored!");
        } else {
        int rowsAffected =0;
        int count = 0;
        String queryCheck = "SELECT COUNT(*) AS `count` FROM `menu_items` WHERE `item_name` LIKE('" + menu.getMenuName() + "') AND `price` LIKE(" + menu.getPrice() + ");";
        try {
            ResultSet resultSet = sql.executeQuery(queryCheck);
            resultSet.next();
            count = resultSet.getInt("count");
            if (count ==0) {
                isUpdated = menuDao.updateMenuItem(menu);
                if ( isUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Menu Item Updated Successfully!");
                } else if ( isUpdated ==0 || isUpdated <0) {
                    JOptionPane.showMessageDialog(null, "Operation Failed");
                }
            } else {
                JOptionPane.showMessageDialog(null, menu.getMenuName()+" Already Existed!");
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
        }
        
        return isUpdated;
        
    }
    public void printAllMenuItems () {
        CommonService commonService = new CommonService();
        Vector<Menu> menuItemList = commonService.getVectorMenuItem();
        
        try {
            PdfDocument pdfDocument = new PdfDocument(new PdfWriter("./all_menu_items.pdf"));
            Document layoutDocument = new Document(pdfDocument);
            
            //title
            layoutDocument.add(new Paragraph("ALL MENU ITEMS").setBold().setUnderline()
                    .setTextAlignment(TextAlignment.CENTER));
            
            //other reference information
            layoutDocument.add(new Paragraph("THE WAITERS RESTAURANT")
                    .setTextAlignment(TextAlignment.LEFT).setMultipliedLeading(0.2f).setBold());
            layoutDocument.add(new Paragraph("PESHAWAR").setMultipliedLeading(.2f));
            layoutDocument.add(new Paragraph("Phone# 091-123456789").setMultipliedLeading(.2f));
            
            //create items to add into pdf
            //create a table to display items into tabular form
            
            Table table = new Table(UnitValue.createPointArray(new float[]{60f,180f,50f}));
            
            //headers
            table.addCell(new Paragraph("S.N.O").setBold());
            table.addCell(new Paragraph("Item Name").setBold());
            table.addCell(new Paragraph("Price").setBold());
            
            //Now Add Data Into these table Columns 
            for (Menu menu : menuItemList) {
                table.addCell(new Paragraph(menu.getMenuId()+""));
                table.addCell(new Paragraph(menu.getMenuName()));
                table.addCell(new Paragraph(menu.getPrice()+""));
            }
            
            // add table to pdf
            layoutDocument.add(table);
            
            //close document
            layoutDocument.close();
            
            //now opening it in browser to print
            
            File pdfFile =  new File("./all_menu_items.pdf");
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
