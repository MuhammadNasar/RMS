/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import util.SQLQueryUtil;

/**
 *
 * @author Salman Khan
 * 
 */
public class ReportService {

    public void printCashMethod(String fromDate, String toDate, String paymentMethid) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        
        String cashQuery = "SELECT `id` AS `bill_number`, `total_amount_receivable`, `discount_amount`, "
                + "`net_amount`, `payment_method`, "
                + "DATE_FORMAT(`bill_date_time`, '%d %b %Y') AS `bill_date` "
                + "FROM `restaurant_kot` WHERE DATE_FORMAT(`bill_date_time`, '%Y-%m-%d')"
                + " BETWEEN '2018-07-25' AND '2018-08-03' AND `payment_method` ='CASH'" +
                    "ORDER BY `id` ASC;";
        
        
        
        
        
        
    }

    public void printChequeMethod(String fromDate, String toDate, String paymentMethid) {
        
    }

    public void printCreditCardMethod(String fromDate, String toDate, String paymentMethid) {
        
    }
    
}
