/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entity.PendingBill;
import entity.PendingBillUpdate;
import java.util.Vector;
import javax.swing.JOptionPane;
import services.CommonService;
import services.PendingPaymentService;
import table_models.PendingPaymentTableModel;

/**
 *
 * @author itsSa
 */
public class PendingPaymentsForm extends javax.swing.JInternalFrame {
    private CommonService commonService;
    private Vector<PendingBill> vectorPendingPayments;
    private Vector<PendingBillUpdate> vectorSelectedDetails;
    private PendingPaymentService pendingPaymentService;
    /**
     * Creates new form PendingPaymentsForm
     */
    public PendingPaymentsForm() {
        initComponents();
        
        commonService = new CommonService();
        vectorPendingPayments = commonService.getVectorPendingPayment();
        
        PendingPaymentTableModel pendingPaymentModel = new PendingPaymentTableModel(vectorPendingPayments);
        tblPendingPayments.setModel(pendingPaymentModel);
        
        
        rbtnCash.setActionCommand("CASH");
        rbtnCheque.setActionCommand("CHEQUE");
        rbtnCreditCard.setActionCommand("CREDIT_CARD");
        radioButtonGrp.add(rbtnCash);
        radioButtonGrp.add(rbtnCheque);
        radioButtonGrp.add(rbtnCreditCard);
        rbtnCash.setSelected(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioButtonGrp = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPendingPayments = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTotalAmount = new javax.swing.JTextField();
        txtDiscount = new javax.swing.JTextField();
        txtDiscountedAmount = new javax.swing.JTextField();
        txtNextToPay = new javax.swing.JTextField();
        rbtnCash = new javax.swing.JRadioButton();
        rbtnCreditCard = new javax.swing.JRadioButton();
        rbtnCheque = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        lblKotID = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 217, 151));

        jPanel1.setBackground(new java.awt.Color(255, 217, 151));

        tblPendingPayments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPendingPayments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPendingPaymentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPendingPayments);

        jLabel1.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        jLabel1.setText("Pending Payments");

        jPanel2.setBackground(new java.awt.Color(255, 217, 151));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Confirm Payment Method", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Open Sans", 1, 24))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Total Amount");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Discount %");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Discounted Amount");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Next To Pay");

        txtTotalAmount.setEditable(false);
        txtTotalAmount.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalAmount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtDiscount.setEditable(false);
        txtDiscount.setBackground(new java.awt.Color(255, 255, 255));
        txtDiscount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtDiscountedAmount.setEditable(false);
        txtDiscountedAmount.setBackground(new java.awt.Color(255, 255, 255));
        txtDiscountedAmount.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        txtNextToPay.setEditable(false);
        txtNextToPay.setBackground(new java.awt.Color(255, 255, 255));
        txtNextToPay.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        radioButtonGrp.add(rbtnCash);
        rbtnCash.setText("Cash");

        radioButtonGrp.add(rbtnCreditCard);
        rbtnCreditCard.setText("Credit Card");

        radioButtonGrp.add(rbtnCheque);
        rbtnCheque.setText("Cheque");

        jLabel6.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel6.setText("Bill ID#");

        lblKotID.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblKotID.setText("001");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(lblKotID))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(rbtnCash)
                            .addGap(18, 18, 18)
                            .addComponent(rbtnCheque)
                            .addGap(18, 18, 18)
                            .addComponent(rbtnCreditCard))
                        .addComponent(txtNextToPay)
                        .addComponent(txtDiscount)
                        .addComponent(txtDiscountedAmount)
                        .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblKotID))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiscountedAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNextToPay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnCash)
                    .addComponent(rbtnCheque)
                    .addComponent(rbtnCreditCard))
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(258, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(157, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 86, 86))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPendingPaymentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPendingPaymentsMouseClicked
        int SelectedRow = tblPendingPayments.getSelectedRow();
        PendingPaymentTableModel pendingpaymentModel = (PendingPaymentTableModel) tblPendingPayments.getModel();
        String kot_id = pendingpaymentModel.getValueAt(SelectedRow, 0).toString();
        
        vectorSelectedDetails = commonService.getVectorOfSelectedDetails(kot_id);
        
        txtDiscount.setText(vectorSelectedDetails.get(0).getDiscount()+"");
        txtDiscountedAmount.setText(vectorSelectedDetails.get(0).getDiscountAmount()+"");
        txtTotalAmount.setText(vectorSelectedDetails.get(0).getTotal()+"");
        txtNextToPay.setText(vectorSelectedDetails.get(0).getNetAmount()+"");
        lblKotID.setText(kot_id);
    }//GEN-LAST:event_tblPendingPaymentsMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are You Sure? To Confirm The Payment? ");
        if (confirm == 0){
        pendingPaymentService = new PendingPaymentService();
        
        String paymentMethod = "";
        int selectedBill_ID = 0;
        
        paymentMethod = radioButtonGrp.getSelection().getActionCommand();
        selectedBill_ID = Integer.parseInt(lblKotID.getText());
        
        pendingPaymentService.confirmPaymentMethod(paymentMethod,selectedBill_ID);
        
        //Table Refresh
        vectorPendingPayments = commonService.getVectorPendingPayment();
        PendingPaymentTableModel pendingPaymentModel = new PendingPaymentTableModel(vectorPendingPayments);
        tblPendingPayments.setModel(pendingPaymentModel);
        
        JOptionPane.showMessageDialog(this, "Payment Confirmed Successfully Through: "+paymentMethod);
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKotID;
    private javax.swing.ButtonGroup radioButtonGrp;
    private javax.swing.JRadioButton rbtnCash;
    private javax.swing.JRadioButton rbtnCheque;
    private javax.swing.JRadioButton rbtnCreditCard;
    private javax.swing.JTable tblPendingPayments;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtDiscountedAmount;
    private javax.swing.JTextField txtNextToPay;
    private javax.swing.JTextField txtTotalAmount;
    // End of variables declaration//GEN-END:variables
}
