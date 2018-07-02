/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.itextpdf.layout.element.Table;
import dao.TablesDAO;
import entity.Tables;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.SQLQueryUtil;

/**
 *
 * @author Muhammad Nasar
 */
public class TableService {
    private TablesDAO tablesDao ;
    
    public TableService(){
        tablesDao = new TablesDAO() ;
    }
    
    public int chickTableNumber(Tables tables){
        SQLQueryUtil sqlutil = new SQLQueryUtil();
        sqlutil.connect(false);

        int rowsAffected = 0;
        int count = 0;
        
        if (tables.getTableNumber().equals("")  ) {
            JOptionPane.showMessageDialog(null, "Empty data can not be saved.");
        } else {

            String queryCheck = "SELECT COUNT(*) AS `count` FROM `tables` WHERE `table_number` LIKE('" + tables.getTableNumber() + "');";
            try {
                ResultSet resultSet = sqlutil.executeQuery(queryCheck);
                resultSet.next();

                count = resultSet.getInt("count");

                if (count == 0) {
                    rowsAffected = tablesDao.registerTablesNumber(tables);
                } else {
                    JOptionPane.showMessageDialog(null, tables.getTableNumber() + " Already exists.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                sqlutil.disconnect();
            }
        }

        return rowsAffected;
        
    }
    
    public int updateTableNumber(Tables tables) {
        int isUpdated =0;
        SQLQueryUtil sql = new SQLQueryUtil();
        sql.connect(false);
        
        if (tables.getTableNumber().equals("")) {
            JOptionPane.showMessageDialog(null, "Empty Data Cant Be Stored!");
        } else {
        int rowsAffected =0;
        int count = 0;
        String queryCheck = "SELECT COUNT(*) AS `count` FROM `tables` WHERE `table_number` LIKE('" + tables.getTableNumber() + "');";
        
        try {
            ResultSet resultSet = sql.executeQuery(queryCheck);
            resultSet.next();
            count = resultSet.getInt("count");
            if (count ==0) {
                isUpdated = tablesDao.updateTableNumber(tables);
                if ( isUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Menu Item Updated Successfully!");
                } else if ( isUpdated ==0 || isUpdated <0) {
                    JOptionPane.showMessageDialog(null, "Operation Failed");
                }
            } else {
                JOptionPane.showMessageDialog(null, tables.getTableNumber()+" Already Existed!");
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sql.disconnect();
        }
        }
        
        return isUpdated;
        
    }
        
       
    
}
