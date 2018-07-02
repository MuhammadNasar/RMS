/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table_models;

import entity.User;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ibrar
 */
public class UserTableModel extends AbstractTableModel {

    private Vector<User> vectorUser;

    public UserTableModel(Vector<User> vectorUser) {
        this.vectorUser = vectorUser;
    }

    @Override
    public int getRowCount() {
        return this.vectorUser.size();

    }

    @Override
    public int getColumnCount() {

        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object object = null;
        switch(columnIndex){
            case 0:
                //object=vectorUser.get(rowIndex).
        
    }
return object;
    }

    @Override
    public String getColumnName(int column) {
        String name = "";
        switch (column) {
            case 0:
                name = "ID";
                break;
            case 1:
                name = "Display Name";
                break;
            case 2:
                name = "User Name";
                break;
            case 3:
                name = "Password";
                break;

        }
        return name;
    }

}
