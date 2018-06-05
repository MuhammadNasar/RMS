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
import dao.MenuDAO;

/**
 *
 * @author User
 */
public class MenuService {

    private MenuDAO menuDao;

    public MenuService() {
        menuDao = new MenuDAO();
    }

    public int registerMenuItem(Menu menu) {

        SQLQueryUtil sqlutil = new SQLQueryUtil();
        sqlutil.connect(false);

        int rowsAffected = 0;
        int count = 0;
        
        if (menu.getMenuName().equals("") || menu.getPrice() < 0) {
            JOptionPane.showMessageDialog(null, "Empty data can not be saved.");
        } else {

            String queryCheck = "SELECT COUNT(*) AS `count` FROM `menu_items` WHERE `item_name` LIKE('" + menu.getMenuName() + "');";
            try {
                ResultSet resultSet = sqlutil.executeQuery(queryCheck);
                resultSet.next();

                count = resultSet.getInt("count");

                if (count == 0) {
                    rowsAffected = menuDao.registerMenuItem(menu);
                } else {
                    JOptionPane.showMessageDialog(null, menu.getMenuName() + " Already exists.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                sqlutil.disconnect();
            }
        }

        return rowsAffected;
        
    }
}
