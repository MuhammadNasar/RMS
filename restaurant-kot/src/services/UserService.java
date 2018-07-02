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
    public int registerUser(User user){
        SQLQueryUtil sql =new SQLQueryUtil();
        System.out.println("0");
        sql.connect(false);
        int rowAffected=0;
        int count=0;
        System.out.println("1");
        if (user.getDisplayName().equals("Display Name")||user.getUserName().equals("User Name")||user.getPassword().equals("Password"))
        {
            JOptionPane.showMessageDialog(null, "Empty data can not be save .");
        }
        else{
            String chekQuery="SELECT COUNT(*) AS `count` FROM `users` WHERE `user_name` LIKE('"+user.getUserName()+"');";
            System.out.println("2");
            try{
                ResultSet rs= sql.executeQuery(chekQuery);
                System.out.println("3");
            rs.next();
            count=rs.getInt("count");
            if(count==0){
                System.out.println("4");
                rowAffected=userDAO.registerUser(user);
            }else{
                JOptionPane.showMessageDialog(null,user.getUserName()+ "Already exists.");
            }
            
            }catch(SQLException e){
                e.printStackTrace();
                
            }finally{
                sql.disconnect();
            }
            
        }
        return rowAffected;
    }

}
