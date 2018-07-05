package services;

import dao.WaitersDAO;
import entity.Waiters;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.SQLQueryUtil;

public class WaitersServices {

    private WaitersDAO waitersDAO;
    
    public WaitersServices() {
        waitersDAO = new WaitersDAO();
    }

    public void waiter(Waiters waiters) {

        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        String queryCheck;
        
        try {
            queryCheck = "select count(*) as count from waiters where"
                    + " waiter_number ='" + waiters.getWaiterNumber() + "'"
                    + " OR cnic ='" + waiters.getCnic() + "';";
            
            ResultSet rs = sql.executeQuery(queryCheck);
            
            rs.next();
            int data = rs.getInt("count");

            if (data == 0) {
                
                waitersDAO.registerWaiters(waiters);
                JOptionPane.showMessageDialog(null,"Waiter register successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Already exists.");
            }

        } catch (SQLException sq) {
            sq.printStackTrace();
        } finally {
            sql.disconnect();
        }
    }
    public int updateWaiters(Waiters waiters){
    waitersDAO.updateWaiters(waiters);
    
    
    return 0;
    }
}
