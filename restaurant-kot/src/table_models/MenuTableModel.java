
package table_models;

import entity.Menu;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class MenuTableModel extends AbstractTableModel {
    private Vector<Menu> vectorMenuItem;

    public MenuTableModel() {
    }

    public MenuTableModel(Vector<Menu> vectorMenuItem) {
        this.vectorMenuItem = vectorMenuItem;
    }
    
    @Override
    public int getRowCount() {
            return this.vectorMenuItem.size();
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
                columnName = "Name";
                break;
            case 2:
                columnName = "Price";
                break;
        }
        return columnName;
    }
    
    @Override
    public Object getValueAt(int rowsIndex, int columnIndex) {
       Object object = null;
       
       switch (columnIndex) {
           case 0:
               object = vectorMenuItem.get(rowsIndex).getMenuId();
               break;
           case 1:
               object = vectorMenuItem.get(rowsIndex).getMenuName();
               break;
           case 2:
               object = vectorMenuItem.get(rowsIndex).getPrice();
               break;
       }
       return object;
    }
    
    
}
