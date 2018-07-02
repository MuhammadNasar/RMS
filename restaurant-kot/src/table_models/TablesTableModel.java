/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table_models;


import entity.Tables;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Muhammad Nasar
 */
public class TablesTableModel extends AbstractTableModel{
    private Vector<Tables> vectorTables;

    public TablesTableModel() {
    }

    public TablesTableModel(Vector<Tables> vectorTables) {
        this.vectorTables = vectorTables;
    }
    
    @Override
    public int getRowCount() {
            return this.vectorTables.size();
    }

    @Override
    public int getColumnCount() {
            return 3;
    }

    @Override
    public String getColumnName ( int columnIndex) {
        String columnName = "";
        
        switch(columnIndex) {
            case 0:
                columnName = "ID";
                break;
            case 1:
                columnName = "Table_Number";
                break;
            case 2:
                columnName = "As_Available";
                break;
        }
        return columnName;
    }
    
    @Override
    public Object getValueAt(int rowsIndex, int columnIndex) {
       Object object = null;
       
       switch (columnIndex) {
           case 0:
               object = vectorTables.get(rowsIndex).getTableId();
               break;
           case 1:
               object = vectorTables.get(rowsIndex).getTableNumber();
               break;
           case 2:
               object = vectorTables.get(rowsIndex).getAsAvailable();
               break;
       }
       return object;
    }
    
}
