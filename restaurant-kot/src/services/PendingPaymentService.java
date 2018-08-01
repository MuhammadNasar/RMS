/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.PendingPaymentDAO;
import javax.swing.JOptionPane;
import util.SQLQueryUtil;

/**
 *
 * @author itsSa
 */
public class PendingPaymentService {
    private PendingPaymentDAO pendingPaymentDAO;
    public PendingPaymentService() {
        
    }
    
    public void confirmPaymentMethod(String paymentMethod, int selectedBill_ID) {
        if (paymentMethod.equals("") || selectedBill_ID < 0){
            JOptionPane.showMessageDialog(null, "Something Went Wrong!");
        } else {
            pendingPaymentDAO = new PendingPaymentDAO();
            pendingPaymentDAO.confirmPaymentMethod( paymentMethod,selectedBill_ID);
        }
    }
    
    
}
