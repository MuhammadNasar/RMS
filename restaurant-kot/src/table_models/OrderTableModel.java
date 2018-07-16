/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table_models;

import entity.Order;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class OrderTableModel extends AbstractTableModel{
    public Vector<Order> vectorOrder;

    public OrderTableModel(Vector<Order> vectorOrder) {
        this.vectorOrder = vectorOrder;
    }
    public OrderTableModel() {
    }

    @Override
    public int getRowCount() {
        return vectorOrder.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }
@Override
    public String getColumnName(int columnIndex) {
        String columnName = "";
        
        switch (columnIndex) {
            case 0:
                    columnName = "Menu Item Name";
                    break;
            case 1:
                    columnName = "Quantity";
                    break;
        } 
        return columnName;
    }
    @Override
    public Object getValueAt(int rowsIndex, int columnIndex) {
        Object object ="";
            switch(columnIndex) {
                case 0:
                    object = vectorOrder.get(rowsIndex).getMenuItem().getMenuName();
                    break;
                case 1:
                    object = vectorOrder.get(rowsIndex).getQuantity();
                    
            }
        return object;
    }
    
    
}
