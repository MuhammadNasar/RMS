/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table_models;

import entity.PendigBillUpdate;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ibrar
 */
public class PendingBillDetailTableModel extends AbstractTableModel {

    private Vector<PendigBillUpdate> vectorpPandigBillUpdates;

    public PendingBillDetailTableModel(Vector<PendigBillUpdate> vectorpPandigBillUpdates) {
        this.vectorpPandigBillUpdates = vectorpPandigBillUpdates;
    }

    @Override
    public int getRowCount() {
        return vectorpPandigBillUpdates.size();
    }

    @Override
    public int getColumnCount() {
        return 4;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object object = null;
        switch (columnIndex) {
            case 0:
                object = vectorpPandigBillUpdates.get(rowIndex).getMenu().getMenuName();
                break;
            case 1:
                object = vectorpPandigBillUpdates.get(rowIndex).getQuantity();
                break;
            case 2:
                object = vectorpPandigBillUpdates.get(rowIndex).getAmount();
                break;
            case 3:
                object = vectorpPandigBillUpdates.get(rowIndex).getSum();
                break;
        }
        return object;
    }

    @Override
    public String getColumnName(int column) {
        String name="";
        switch(column){
            case 0:
               name="Item Name";
                break;
            case 1:
                name="Qantity";
                break;
            case 2:
                name="Price";
                break;
            case 3:
                name="sum";
                break;
                        
        }return name;
   }
    

}
