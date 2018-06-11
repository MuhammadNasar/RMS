/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

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
        int canInserted =0;
        String queryCheck = "SELECT COUNT(*) AS `count` FROM `tables` WHERE `table_number` LIKE('" + tables.getTableNumber() + "');";
        try {
            ResultSet resultSet = sqlutil.executeQuery(queryCheck);
            resultSet.next();

            count = resultSet.getInt("count");

            if (count == 0) {
                if(tables.getTableNumber().equals("") ) {
                    JOptionPane.showMessageDialog(null, "Empty Data Cant Be Stored!");
                } else {
                    canInserted = tablesDao.registerTablesNumber(tables);
                }
            } else{
                JOptionPane.showMessageDialog(null, tables.getTableNumber() + " Already exists.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            sqlutil.disconnect();
        }
        return canInserted;
    }
}
