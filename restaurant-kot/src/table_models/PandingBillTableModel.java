/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table_models;

import entity.PandingBill;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ibrar
 */
public class PandingBillTableModel extends AbstractTableModel {

    private Vector<PandingBill> vectorPandingBills;

    public PandingBillTableModel(Vector<PandingBill> vectorPandingBills) {
        this.vectorPandingBills = vectorPandingBills;
    }

    @Override
    public int getRowCount() {
        return vectorPandingBills.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        String name = "";
        switch (column) {
            case 0:
                name = "Bill Number";
                break;
            case 1:
                name = "Table Number";
                break;
            case 2:
                name = "Waiter Name";
                break;
        }
        return name;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object object = null;
        switch (columnIndex) {
            case 0:
                object = vectorPandingBills.get(rowIndex).getId();
                break;
            case 1:
                object = vectorPandingBills.get(rowIndex).getTables().getTableNumber();
                break;
            case 2:
                object = vectorPandingBills.get(rowIndex).getWaiter().getName();
                break;
        }
        return object;

    }

}
