/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Order;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import util.SQLQueryUtil;

/**
 *
 * @author User
 */
public class OrderDAO {

    public OrderDAO() {
        
    }

    public void ConfirmOrder(Vector<Order> vectorOrder, int isNewKot) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        
        int kotId = 0;
        String queryKotId = "";
        String queryKot = "INSERT INTO `restaurant_kot`(`table_id`, `total_amount_receivable`, `total_received_amount`, `discount_percentage`, `discount_amount`, `net_amount`, `is_transfered_to_pending_payments`, `is_pending_payment_closed`, `payment_method`, `bill_date_time`, `waiter_id`) " +
"VALUES ()";
        String queryKotDetails = "";
        
        ResultSet rs;
        
        try {
            if(isNewKot == 0) {
                sql.executeQuery(queryKot);
            } else {
                
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
    }
}
