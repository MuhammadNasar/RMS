/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.OrderDAO;
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
}
