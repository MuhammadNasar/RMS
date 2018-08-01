/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table_models;

import entity.PendingBill;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import views.PendingBillsForm;

/**
 *
 * @author itsSa
 */
public class PendingPaymentTableModel extends AbstractTableModel{
    private Vector<PendingBill> vectorPendingPayments;

    public PendingPaymentTableModel(Vector<PendingBill> vectorPendingPayments) {
        this.vectorPendingPayments = vectorPendingPayments;
    }

    public PendingPaymentTableModel() {
    }
    @Override
    public int getRowCount() {
        return vectorPendingPayments.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object object = null;
        switch (columnIndex) {
            case 0:
                object = vectorPendingPayments.get(rowIndex).getId();
                break;
            case 1:
                object = vectorPendingPayments.get(rowIndex).getTables().getTableNumber();
                break;
            case 2:
                object = vectorPendingPayments.get(rowIndex).getWaiter().getName();
                break;
        }
        return object;

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
}
