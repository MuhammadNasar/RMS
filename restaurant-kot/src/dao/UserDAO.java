/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Menu;
import entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.SQLQueryUtil;

/**
 *
 * @author User
 */
public class UserDAO {

    public int tryLogin(User user) {
        int canLogin = 0;
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        
        String query = "SELECT COUNT(*) AS `cc` FROM `users` WHERE "
                + "`user_name`='"
                + user.getUserName() + "' AND `password`='"
                + user.getPassword() + "';";
        System.out.println(query);
        try {
            ResultSet resultSet = sql.executeQuery(query);
            resultSet.next();
            
            canLogin = resultSet.getInt("cc");
            
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
        return canLogin;
    }
  public int registerMenuItem (Menu menu) {
   
      int dataInserted = 0;
      String query = "INSERT INTO `menu_items`(`item_name`, `price`) "
              + "VALUES ('" + menu.getMenuName() + "'," + menu.getPrice() + ");";
      return dataInserted;
  }
}








