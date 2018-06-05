package services;

import dao.WaitersDAO;
import entity.Waiters;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.SQLQueryUtil;

public class WaitersServices {

    private WaitersDAO waitersDAO;
    private Component rootPane;

    public WaitersServices() {
        waitersDAO = new WaitersDAO();
    }

    public void waiter(Waiters waiters) {

        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        String query, queryCheck;
        String queryString;
        int canInserted = 0;

        try {
            queryCheck = "select count(*) as count from waiters where"
                    + " waiter_number ='" + waiters.getWaiterNumber() + "'"
                    + " OR cnic ='" + waiters.getCnic() + "';";

            System.out.println("i am here");
            
            ResultSet rs = sql.executeQuery(queryCheck);
            
            rs.next();
            int data = rs.getInt("count");
            

            if (data == 0) {
                
                
                System.out.println("inside if");
                
                waitersDAO.registerWaiters(waiters);
                JOptionPane.showMessageDialog(rootPane,"Waiter register successfully");
                
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
