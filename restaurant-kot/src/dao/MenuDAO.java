/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Menu;
import java.sql.SQLException;
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
}
