/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import util.SQLQueryUtil;

/**
 *
 * @author itsSa
 */
public class PendingPaymentDAO {

    public PendingPaymentDAO() {
    }

    public void confirmPaymentMethod(String paymentMethod,int selectedBill_ID) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        
        String query = "UPDATE `restaurant_kot` SET "
                + "`is_pending_payment_closed`=1,"
                + "`payment_method`='" + paymentMethod + "' "
                + "WHERE `id` = " + selectedBill_ID + ";";
        
        try {
            
            sql.executeUpdate(query);
            sql.commit();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            sql.disconnect();
        }
    }
    
}
