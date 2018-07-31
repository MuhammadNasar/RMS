/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.PendigBillUpdate;
import util.SQLQueryUtil;

/**
 *
 * @author ibrar
 */
public class PendingBillDAO {

    public int generatPandingBill(PendigBillUpdate billUpdate) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        int rowAffected = 0;
        String query = "UPDATE`restaurant_kot`SET`total_amount_receivable`='" + billUpdate.getTotal() + "',"
                + "`total_received_amount`='" + billUpdate.getTotalRecievabelAmount() + "',"
                + "`discount_percentage`='" + billUpdate.getDiscount() + "',"
                + "`discount_amount`='" + billUpdate.getDiscountAmount() + "',"
                + "`net_amount`='" + billUpdate.getNetAmount() + "',`is_transfered_to_pending_payments`=1,"
                + "`bill_date_time`=`getCurrentDateTime`()" + " WHERE `id`='" + billUpdate.getId() + "';";
        try {
            rowAffected = sql.executeUpdate(query);
            sql.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sql.disconnect();
        }
        return rowAffected;
    }

}
