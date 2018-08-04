/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.PaymentMethod;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import util.SQLQueryUtil;

/**
 *
 * @author Salman Khan
 * 
 */
public class PaymentMethodtService {
    public Vector<PaymentMethod> getvectorPaymentMethod () {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        
        Vector<PaymentMethod> vectorPaymentMethod = new Vector<>();
        
        String query = "SELECT `id`,`title`from `payment_methods` ORDER BY `id` ASC;";
        
        ResultSet resultSet;
        PaymentMethod paymentMethod;
        try {
            resultSet = sql.executeQuery(query);
            while (resultSet.next()) {
                paymentMethod = new PaymentMethod();
                paymentMethod.setId(resultSet.getString("id"));
                paymentMethod.setPaymentMethod(resultSet.getString("title"));
                vectorPaymentMethod.add(paymentMethod);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            sql.disconnect();
        }
        
        return vectorPaymentMethod;
    }
}
