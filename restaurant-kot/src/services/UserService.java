/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.UserDAO;
import entity.User;
import javax.swing.JOptionPane;

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

}
