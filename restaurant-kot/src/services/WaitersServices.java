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
                JOptionPane.showMessageDialog(null, "Waiter registered successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Already exists.");
            }

        } catch (SQLException sq) {
            sq.printStackTrace();
        } finally {
            sql.disconnect();
        }
    }

    public int updateWaiters(Waiters waiters) {

        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        String queryCheck;

        try {
            queryCheck = "select count(*) as count from waiters where"
                    + " waiter_number ='" + waiters.getWaiterNumber() + "'"
                    + "and full_name ='" + waiters.getWaiterNumber() + "'"
                    + "and father_name ='" + waiters.getWaiterNumber() + "'"
                    + "and phone_number ='" + waiters.getWaiterNumber() + "'"
                    + "and address ='" + waiters.getWaiterNumber() + "'"
                    + "and waiter_number ='" + waiters.getWaiterNumber() + "'"
                    + " and cnic ='" + waiters.getCnic() + "';";

            ResultSet rs = sql.executeQuery(queryCheck);

            rs.next();
            int data = 0;
            data = rs.getInt("count");

            if (data == 0) {
                waitersDAO.updateWaiters(waiters);

                JOptionPane.showMessageDialog(null, "Waiter updated successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Already exists.");
            }

        } catch (SQLException sq) {
            sq.printStackTrace();
        } finally {
            sql.disconnect();
        }
        return 0;

    }
}
