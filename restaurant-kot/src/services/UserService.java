/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.UserDAO;
import entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.SQLQueryUtil;

/**
 *
 * @author User
 */
public class UserService {

    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    public int tryLogin(User user) {
        int canLogin = 0;
        if (user.getUserName().equals("") || user.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill the form properly.");
        } else {
            canLogin = userDAO.tryLogin(user);
        }

        return canLogin;
    }

    public int registerUser(User user) {
        SQLQueryUtil sql = new SQLQueryUtil();
        System.out.println("0");
        sql.connect(false);
        int rowAffected = 0;
        int count = 0;

        if (user.getDisplayName().equals("Display Name") || user.getDisplayName().equals("")
                || user.getUserName().equals("User Name") || user.getUserName().equals("")
                || user.getPassword().equals("Password") || user.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, " Empty data can not be save .");
        } else {
            String chekQuery = "SELECT COUNT(*) AS `count` FROM `users` WHERE `user_name` LIKE('" + user.getUserName() + "');";

            try {
                ResultSet rs = sql.executeQuery(chekQuery);

                rs.next();
                count = rs.getInt("count");
                if (count == 0) {

                    rowAffected = userDAO.registerUser(user);
                    if (rowAffected == 0) {
                        JOptionPane.showMessageDialog(null, " Please Choos Another Admin Name .");
                    } else {
                        JOptionPane.showMessageDialog(null, " New Admin  added successfully!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, user.getUserName() + " Already exists.");
                }

            } catch (SQLException e) {
                e.printStackTrace();

            } finally {
                sql.disconnect();
            }

        }
        return rowAffected;
    }

    public void updateUser(User user) {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        if (user.getDisplayName().equals("Update Display Name") || user.getDisplayName().equals("")
                || user.getUserName().equals("Update User Name") || user.getUserName().equals("")
                || user.getPassword().equals("Update Password") || user.getPassword().equals("")) {
            JOptionPane.showMessageDialog(null, " Empty data can not to be save");

        } else {
            String query = "SELECT COUNT(*) AS `count` FROM  `users` WHERE `id` !=" + user.getUserId()
                    + " AND `user_name`='" + user.getUserName() + "';";
            try {
                int rowAffected = 0;
                int count = 0;

                ResultSet rs = sql.executeQuery(query);
                rs.next();

                count = rs.getInt("count");

                if (count == 0) {
                    rowAffected = userDAO.updateUser(user);
                    if (rowAffected > 0) {
                        JOptionPane.showMessageDialog(null, "User Detail Update Successsful ");
                    } else if (rowAffected == 0 || rowAffected < 0) {
                        JOptionPane.showMessageDialog(null, "Operation field");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "  This User information Already Existed");

                }
            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                sql.disconnect();
            }
        }

    }

}
