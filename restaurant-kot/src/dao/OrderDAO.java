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
import services.OrderService;
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
                + "0, 0, 0, 'PENDING', " + vectorOrder.get(0).getWaiter().getWaiterId() + ");";
        System.out.println(queryKot);
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
            System.out.println(queryKotId);
            resultMaxId = sql.executeQuery(queryKotId);
            resultMaxId.next();
            kotId = resultMaxId.getInt("max_kot_id");
            

            //details
            queryBulkId = "SELECT IFNULL(MAX(`bulk_id`), 0) AS `max_bulk_id` "
                    + "FROM `restaurant_kot_details` WHERE `kot_id`=" + kotId + ";";
            System.out.println(queryBulkId);
            resultBulkId = sql.executeQuery(queryBulkId);
            resultBulkId.next();
            bulkId = resultBulkId.getInt("max_bulk_id");
            bulkId = bulkId + 1;
            for(int i = 0; i < vectorOrder.size(); i++) {
                queryKotDetails = "INSERT INTO `restaurant_kot_details`(`kot_id`, "
                        + "`item_id`, `quantity`, `rate`, `bulk_id`, "
                        + "`insertion_date_time`) VALUES ("
                        + kotId +", " +vectorOrder.get(i).getMenuItem().getMenuId()
                        +", " + vectorOrder.get(i).getQuantity() + ", "
                        + vectorOrder.get(i).getMenuItem().getPrice() + ", "
                        + bulkId + ", `getCurrentDateTime`());";
                System.out.println(queryKotDetails);
                sql.executeUpdate(queryKotDetails);
            }
            
            sql.commit();
            JOptionPane.showMessageDialog(null, "Kot generated successfully");
             OrderService orderService = new OrderService();
            orderService.printCurrentKOT(vectorOrder,kotId);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
    }
}
