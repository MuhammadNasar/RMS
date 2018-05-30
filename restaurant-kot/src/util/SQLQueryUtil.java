/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class SQLQueryUtil {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    
    public void connect ( boolean autoCommit) {
        String driver = "com.mysql.jdbc.driver";
        String connectionString = "jdbc:mysql://localhost:3306/restaurant_kot";
        String user = "root";
        String password = "";
        
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionString, user, password);
            connection.setAutoCommit(autoCommit);
            statement = connection.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    public ResultSet executeQuery (String query) throws SQLException {
        resultSet = statement.executeQuery(query);
        return resultSet;
    }
    public int executeUpdate (String query) throws SQLException {
        int rowsAffected = 0;
        rowsAffected = statement.executeUpdate(query);
        return rowsAffected;
    }
    public void commit () {
        try {
            if(!(connection.isClosed() || connection == null)) {
                connection.commit();
            }
        }catch (SQLException ex) {
                    ex.printStackTrace();
        }
    }
    public void disconnect () {
        try {
            if(!(connection.isClosed() || connection == null)) {
                 connection.rollback();
                 connection.close();
        } } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void printStackTrace() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
