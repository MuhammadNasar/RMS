package dao;

import entity.Waiters;
import java.sql.SQLException;
import util.SQLQueryUtil;

public class WaitersDAO {

    public WaitersDAO() {
    }

    public int registerWaiters(Waiters waiters) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        
        int dataInserted = 0;
       String  query = " INSERT INTO `waiters`(`full_name`, `father_name`, `waiter_number`, `phone_number`, `cnic`, `address`)"
                + " VALUES ('" + waiters.getName() 
                + "','" + waiters.getFatherName() 
                + "','" + waiters.getWaiterNumber() 
                + "','" + waiters.getPhoneNumber() 
                + "','" + waiters.getCnic() + "','" 
                + waiters.getAddress() + "');";
       
       try {
           dataInserted = sql.executeUpdate(query);
           sql.commit();
       } catch(SQLException ex) {
           ex.printStackTrace();
       } finally {
           sql.disconnect();
       }
       return dataInserted;

    }

}
