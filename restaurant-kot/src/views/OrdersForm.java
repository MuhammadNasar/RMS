/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import javax.swing.BorderFactory;

/**
 *
 * @author ehsas
 */
public class OrdersForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form OrdersForm
     */
    public OrdersForm() {
        initComponents();
        
        this.getContentPane().setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(new Color(201, 201, 201)));
        javax.swing.plaf.InternalFrameUI ifu = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setText("Order Form");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
<<<<<<< HEAD
                .addGap(294, 294, 294)
                .addComponent(jLabel1)
                .addContainerGap(295, Short.MAX_VALUE))
=======
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(329, Short.MAX_VALUE))
>>>>>>> master
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
<<<<<<< HEAD
                .addComponent(jLabel1)
                .addGap(0, 358, Short.MAX_VALUE))
=======
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(257, Short.MAX_VALUE))
>>>>>>> master
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
