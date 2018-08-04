/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import dao.OrderDAO;
import entity.Order;
import java.awt.Desktop;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import util.SQLQueryUtil;

/**
 *
 * @author User
 */
public class OrderService {

    private OrderDAO orderDAO;

    public OrderService() {
        orderDAO = new OrderDAO();
    }

    public void ConfirmOrder(Vector<Order> vectorOrder) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        int isNewKot = 0;
        String query = "SELECT COUNT(*) AS `count` FROM `restaurant_kot` "
                + "WHERE `table_id`=" + vectorOrder.get(0).getTable().getTableId()
                + " AND `is_transfered_to_pending_payments`=0 AND `is_pending_payment_closed`=0;";
        ResultSet rs;

        if (vectorOrder.size() <= 0) {
            JOptionPane.showMessageDialog(null, "Empty order can not be placed.");
        } else {
            try {
                rs = sql.executeQuery(query);
                rs.next();
                isNewKot = rs.getInt("count");
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                sql.disconnect();
            }

            orderDAO.ConfirmOrder(vectorOrder, isNewKot);

        }
    }

    public void printCurrentKOT(Vector<Order> vectorOrder, int KotID) {

        String tableNumber = vectorOrder.get(0).getTable().getTableNumber();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
        try {
            PdfWriter writer = new PdfWriter("./print_kot.pdf");
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document layoutDocument = new Document(pdfDocument);
            Rectangle rectangle = new Rectangle(280, 380);
            PageSize pagesize = new PageSize(rectangle);
            pdfDocument.setDefaultPageSize(pagesize);

            String serial = "Serial :       " + KotID;

            Paragraph paragraph1 = new Paragraph(serial).setTextAlignment(TextAlignment.LEFT);
            layoutDocument.add(paragraph1);

            //Date
            String dateDisplay = "Date : " + formatter.format(date);
            layoutDocument.add(new Paragraph(dateDisplay).setTextAlignment(TextAlignment.LEFT));

            //Table Number
            String tableName = "Table : " + vectorOrder.get(0).getTable().getTableNumber();
            layoutDocument.add(new Paragraph(tableName).setTextAlignment(TextAlignment.LEFT));

            String waiterName = "Waiter : " + vectorOrder.get(0).getWaiter().getName() + " ( " + vectorOrder.get(0).getWaiter().getWaiterNumber() + " ) ";
            layoutDocument.add(new Paragraph(waiterName).setTextAlignment(TextAlignment.LEFT));
            
            //New Table
            Table table = new Table(UnitValue.createPointArray(new float[]{60f, 180f, 50f}));

            //headers
            table.addCell(new Paragraph("S.N.O").setBold());
            table.addCell(new Paragraph("Item Name").setBold());
            table.addCell(new Paragraph("Price").setBold());

            //Now Add Data Into these table Columns 
            for (Order order : vectorOrder) {
                table.addCell(new Paragraph(order.getMenuItem().getMenuId() + ""));
                table.addCell(new Paragraph(order.getMenuItem().getMenuName()));
                table.addCell(new Paragraph(order.getMenuItem().getPrice() + ""));
            }

            // add table to pdf
            layoutDocument.add(table);

            //close document
            layoutDocument.close();

            File pdfFile = new File("./print_kot.pdf");
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
