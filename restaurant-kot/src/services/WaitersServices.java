package services;

import entity.Waiters;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.SQLQueryUtil;

public class WaitersServices {
   
   private Component rootPane;
    
    public void waiter(Waiters waiters){
        
    SQLQueryUtil sql= new SQLQueryUtil();
    sql.connect(false);
    String query,queryCheck;
    
    try {
                queryCheck = "select count(*) as count from waiters where"
                        + " waiter_number ='" + waiters.getWaiterNumber()+ "'"
                        + " OR cnic ='" + waiters.getCnic()+ "';";
                       
    System.out.println("i am here");
    ResultSet rs = sql.executeQuery(queryCheck);
                rs.next();
                int data = rs.getInt("count");
                
                    query = " INSERT INTO `waiters`(`full_name`, `father_name`, `waiter_number`, `phone_number`, `cnic`, `address`) "
                            + " VALUES ('"+waiters.getName()+"','"+waiters.getFatherName()+"','"+waiters.getWaiterNumber()+"','"+waiters.getPhoneNumber()+"','"+waiters.getCnic()+"','"+waiters.getAddress()+"');";
                    System.out.println(query);
                       if (data == 0) {
                    System.out.println("inside if");
                    int rowAffected = sql.executeUpdate(query);
                    if (rowAffected == 1) {
                                            System.out.println("before commit");
                        sql.commit();
                                            System.out.println("after commit");
                        JOptionPane.showMessageDialog(rootPane, "waiters successfully registered");
                    }

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Already exists.");

                }

            } catch (SQLException sq) {
                sq.printStackTrace();

            } finally {
                sql.disconnect();
            }
    }
}
    
    
   
       
    
 
    
    
    
        
   
            
          
                
     