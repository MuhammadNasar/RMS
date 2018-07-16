/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Order;
import java.util.Vector;
import util.SQLQueryUtil;

/**
 *
 * @author User
 */
public class OrderService {

    public OrderService() {
    }
    public void ConfirmOrder(Vector<Order> vectorOrder) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        
        int rowsAffected =0;
        int count = 0;
        
        
    }
}
