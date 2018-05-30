package services;

import entity.Waiters;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.SQLQueryUtil;

public class WaitersServices {

    private Waiters waiters;
            
    private Component rootPane;
    
    SQLQueryUtil sql = new SQLQueryUtil();
    Sql.connect(false);
    String query, queryCheck;      
   
            
          
                
          
    
        try{
                queryCheck = "select count(*) as count from waiters where"
                + " student_name ='" + waiters.getName() + "'"
                + " and father_name ='" + waiters.getFatherName() + "'"
                + " and address ='" + waiters.getWaiterNumber() + "'"
                + " and nic ='" + waiters.getPhoneNumber() + "'"
                + " and nic ='" + waiters.getCnic() + "'"
                + " and phone_number = '" + waiters.getAddress() + "';";

                ResultSet rs = sql.executeQuery(queryCheck);
                rs.next();
                int data = rs.getInt("count");
        if (data == 0) {
            query = " insert into waiters (name, father_name,waiters_number,phone_number  cnic, address, )"
                    + " values ('" + waiters.getName()+ "','" + waiters.getFatherName() + "','" + waiters.getWaiterNumber()+ "','" + waiters.getPhoneNumber()+ "','" + waiters.getCnic()+ "','" + waiters.getAddress()+ "');";

            int rowAffected = sql.executeUpdate(query);
            if (rowAffected == 1) {
                sql.commit();
                JOptionPane.showMessageDialog(rootPane, "waiters successfully registered");
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Already exists.");

        }

    }catch(SQLException sq) {
         sq.printStackTrace();

    } finally {
                sql.disconnect();
    }
}

