/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entity.Menu;
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
                waiters.setName(resultSet.getString("name"));
                waiters.setFatherName(resultSet.getString("father_name"));
                waiters.setWaiterNumber(resultSet.getString("waiter_number"));
                waiters.setPhoneNumber(resultSet.getInt("phone_number"));
                waiters.setCnic(resultSet.getString("cnic"));
                waiters.setAddress(resultSet.getString("address"));
                
                vectorwaiters.add(waiters);
            }
        }catch(SQLException ex){
        ex.printStackTrace();
        }
        return vectorwaiters;
    }
    
}
