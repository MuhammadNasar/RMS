/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
        return canLogin;
    }

    public int registerUser(User user) {

        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);

        int rowAffacted = 0;
        String query = "INSERT INTO `users`(`display_name`,`user_name`,`password`) VALUES ('" + user.getDisplayName() + "'"
                + ",'" + user.getUserName() + "','" + user.getPassword() + "');";

        try {
            rowAffacted = sql.executeUpdate(query);
            sql.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sql.disconnect();
        }
        return rowAffacted;
    }

    public int updateUser(User user) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        int rowAffected = 0;

        String query = "UPDATE `users` SET `display_name`='" + user.getDisplayName() + "'"
                + ",`user_name`='" + user.getUserName() + "',`password`='" + user.getPassword() + "' WHERE `id`='" + user.getUserId() + "';";
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
