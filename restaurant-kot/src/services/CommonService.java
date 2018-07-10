/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Menu;
import entity.Tables;
import entity.User;
import entity.Waiters;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import util.SQLQueryUtil;

/**
 *
 * @author User
 */
public class CommonService {

    public CommonService() {
    }
    
    public Vector<Menu> getVectorMenuItem () {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        
        String query = "SELECT * FROM `menu_items` ORDER BY `id` ASC;";
        Vector<Menu> vectorMenuItem = new Vector<>();
        
        ResultSet resultSet;
        Menu menu;
        try {
            resultSet = sql.executeQuery(query);
            while (resultSet.next()) {
                menu = new Menu();
                menu.setMenuId(resultSet.getInt("id"));
                menu.setMenuName(resultSet.getString("item_name"));
                menu.setPrice(resultSet.getInt("price"));
                
                vectorMenuItem.add(menu);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
        
        return vectorMenuItem;
    }
    
    public Vector<Waiters> getVectorWaiters(){
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        
        String query = "SELECT * FROM `waiters` ORDER BY `id` ASC;";
        Vector<Waiters> vectorwaiters = new Vector<>();
        
        ResultSet resultSet;
        Waiters waiters;
        
        try{
            
            resultSet = sql.executeQuery(query);
            while (resultSet.next()) {
                waiters = new Waiters();
                waiters.setWaiterId(resultSet.getInt("id"));
                waiters.setName(resultSet.getString("full_name"));
                waiters.setFatherName(resultSet.getString("father_name"));
                waiters.setWaiterNumber(resultSet.getString("waiter_number"));
                waiters.setPhoneNumber(resultSet.getString("phone_number"));
                waiters.setCnic(resultSet.getString("cnic"));
                waiters.setAddress(resultSet.getString("address"));
                
                vectorwaiters.add(waiters);
            }
        }catch(SQLException ex){
        ex.printStackTrace();
        }
        return vectorwaiters;
    }
    
     public Vector<Tables> getVectorTables () {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        
        String query = "SELECT * FROM `tables` ORDER BY `id` ASC;";
        Vector<Tables> vectorTables = new Vector<>();
        
        ResultSet resultSet;
        Tables tables ;
        try {
            resultSet = sql.executeQuery(query);
            while (resultSet.next()) {
                tables = new Tables();
                tables.setTableId(resultSet.getInt("id"));
                tables.setAsAvailable(resultSet.getInt("is_available"));
                tables.setTableNumber(resultSet.getString("table_number"));
                
                vectorTables.add(tables);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
        
        return vectorTables;
    }

    public Vector<User> getVectorUser() {
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        
        String query = "SELECT * FROM `users` ORDER BY `id` ASC;";
        Vector<User> vectorUsers = new Vector<>();
        
        ResultSet rs; 
        User user;
         try {
            rs = sql.executeQuery(query);
            while (rs.next()) {
               user=new User();
               user.setUserId(rs.getInt("id"));
               user.setDisplayName(rs.getString("display_name"));
               user.setUserName(rs.getString("user_name"));
               user.setPassword(rs.getString("password"));
               vectorUsers.add(user);
                
            }
         }catch(Exception e){
            e.printStackTrace();
         }
         return vectorUsers;
   }
    
}
