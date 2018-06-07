package table_models;

import entity.Menu;
import entity.Waiters;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

public class WaitersTableModel extends AbstractTableModel{
    private Vector<Waiters> vectorwaiters;

    public WaitersTableModel() {
    }
    
    public WaitersTableModel(Vector<Waiters> vectorwaiter) {
        this.vectorwaiters = vectorwaiter;
    }

    @Override
    public int getRowCount() {
    return this.vectorwaiters.size();  
    }

    @Override
    public int getColumnCount() {
        return 6;
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
                columnName = "Father Name";
                break;
            case 3:
                columnName = "Waiter Number";
                break;
            case 4:
                columnName = "Phone Number";
                break;
            case 5:
                columnName = "cnic";
                break;
            case 6:
                columnName = "Address";
                break;
            
        }
        return columnName;
    }
    @Override
     public Object getValueAt(int rowsIndex, int columnIndex) {
       Object object = null;
       
       switch (columnIndex) {
           case 0:
               object = vectorwaiters.get(rowsIndex).getWaiterId();
               break;
           case 1:
               object = vectorwaiters.get(rowsIndex).getName();
               break;
           case 2:
               object = vectorwaiters.get(rowsIndex).getFatherName();
               break;
           case 3:
               object = vectorwaiters.get(rowsIndex).getWaiterNumber();
               break;
           case 4:
               object = vectorwaiters.get(rowsIndex).getPhoneNumber();
               break;
           case 5:
               object = vectorwaiters.get(rowsIndex).getCnic();
               break;
           case 6:
               object = vectorwaiters.get(rowsIndex).getAddress();
               break;
       }
       return object;
    }
    
}
