/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Menu;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.SQLQueryUtil;

/**
 *
 * @author User
 */
public class MenuService {

    public MenuService() {
    }

    public void registerMenuItem(Menu menu) {
        System.out.print("i am here 4");
        SQLQueryUtil sqlutil = new SQLQueryUtil();
        sqlutil.connect(false);

        String query = "INSERT INTO `menu_items`(`item_name`, `price`) VALUES ('" + menu.getMenuName() + "'," + menu.getPrice() + ");";

        int rowsAffected = 0;
        int count = 0;

        String queryCheck = "SELECT COUNT(*) AS `count` FROM `menu_items` WHERE `item_name` LIKE('" + menu.getMenuName() + "');";
        System.out.println("i am here 5");
        try {
            ResultSet resultSet = sqlutil.executeQuery(queryCheck);
            resultSet.next();

            count = resultSet.getInt("count");

            if (count == 0) {
                rowsAffected = sqlutil.executeUpdate(query);
                sqlutil.commit();
                JOptionPane.showMessageDialog(null, rowsAffected + " Rows inserted successfully.");
            } else if (count > 0) {
                JOptionPane.showMessageDialog(null, menu.getMenuName() + menu.getMenuName() + " already exists.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sqlutil.disconnect();
        }
    }
}
