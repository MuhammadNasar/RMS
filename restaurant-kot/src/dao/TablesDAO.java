/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entity.Tables;
import java.sql.SQLException;
import util.SQLQueryUtil;

/**
 *
 * @author Muhammad Nasar
 */
public class TablesDAO {
    public int registerTablesNumber(Tables table){
    
    
     SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        int rowsAffected = 0;
        String query = "INSERT INTO `tables`( `table_number` ,`as_available` )" +
                "VALUES (' " + table.getTableNumber() + "' ," + table.getAsAvailable()+  ");";
               
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
    
    public int updateTableNumber (Tables table) {
        int isUpdated =0;
        
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        
        String query = "INSERT INTO `tables`( `table_number` ,`as_available` )" +
                "VALUES (' " + table.getTableNumber() + "' ," + table.getAsAvailable()+  ");";
        System.out.println(query);
        
        try {
            isUpdated =  sql.executeUpdate(query);
            sql.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
        return isUpdated;
    }
} 

