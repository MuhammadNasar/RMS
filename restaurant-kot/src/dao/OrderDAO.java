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
        int bulkId = 0;
        String queryKotId = "";
        String queryKot = "INSERT INTO `restaurant_kot`(`table_id`, "
                + "`total_amount_receivable`, `total_received_amount`, `discount_percentage`, "
                + "`discount_amount`, `net_amount`, `payment_method`, `waiter_id`) "
                + "VALUES (" + vectorOrder.get(0).getTable().getTableId() + ", 0, 0, "
                + "0, 0, 0, 'PENDING', " + vectorOrder.get(0).getWaiter().getWaiterId() + ")";
        String queryKotDetails = "";
        String queryBulkId = "";

        ResultSet rs;
        ResultSet resultMaxId;
        ResultSet resultBulkId;

        try {
            if (isNewKot == 0) {
                sql.executeUpdate(queryKot);
            }
            
            queryKotId = "SELECT IFNULL(MAX(`id`), 0) AS `max_kot_id` FROM "
                    + "`restaurant_kot` WHERE `table_id`="
                    + vectorOrder.get(0).getTable().getTableId() + " AND `is_transfered_to_pending_payments`"
                    + " = 0 AND `is_pending_payment_closed`=0;";
            resultMaxId = sql.executeQuery(queryKotId);
            resultMaxId.next();
            kotId = resultMaxId.getInt("max_kot_id");
            

            //details
            queryBulkId = "SELECT IFNULL(MAX(`bulk_id`), 0) AS `max_bulk_id` "
                    + "WHERE `kot_id`=" + kotId + ";";
            resultBulkId = sql.executeQuery(queryBulkId);
            resultBulkId.next();
            bulkId = resultBulkId.getInt("max_bulk_id");
            
            for(int i = 0; i < vectorOrder.size(); i++) {
                queryKotDetails = "";
                sql.executeUpdate(queryKotDetails);
            }
            
            sql.commit();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
    }
}
