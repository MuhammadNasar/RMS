/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Menu;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.SQLQueryUtil;

/**
 *
 * @author User
 */
public class MenuDAO {

    public MenuDAO() {
    }

    public int registerMenuItem(Menu menu) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        int rowsAffected = 0;
        String query = "INSERT INTO `menu_items`(`item_name`, `price`) "
                + "VALUES ('" + menu.getMenuName() + "'," + menu.getPrice() + ");";
        try {
            rowsAffected = sql.executeUpdate(query);
            
            sql.commit();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }

        return rowsAffected;

    } 
    public int updateMenuItem (Menu menu) {
        int isUpdated =0;
        
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        
        String query ="UPDATE `menu_items` SET `item_name`='" + menu.getMenuName() + "',"
                + "`price`=" + menu.getPrice() + " WHERE `id` =" + menu.getMenuId() + ";";
        System.out.println(query);
        
        try {
            isUpdated =  sql.executeUpdate(query);
            sql.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
        return isUpdated;
    }
}
