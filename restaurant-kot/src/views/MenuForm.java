/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entity.Menu;
import java.awt.Color;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import services.CommonService;
import services.MenuService;
import table_models.MenuTableModel;

/**
 *
 * @author ehsas
 */
public class MenuForm extends javax.swing.JInternalFrame {
    private MenuService menuService;
    CommonService commonService;
    /**
     * Creates new form DishesForm
     */
    public MenuForm() {
        initComponents();
        
        this.getContentPane().setBackground(new Color(255, 217, 151));
        setBorder(BorderFactory.createLineBorder(new Color(235, 163, 91)));
        javax.swing.plaf.InternalFrameUI ifu = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);
        
        menuService = new MenuService();
        commonService = new CommonService();
        
        Vector<Menu> vectorMenuitem = commonService.getVectorMenuItem();
        
        MenuTableModel menuTableModel = new MenuTableModel(vectorMenuitem);
        jtMenuItem.setModel(menuTableModel);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tblMenu = new javax.swing.JPanel();
        txtDishName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMenuItem = new javax.swing.JTable();
        tblLebel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 217, 151));
        setTitle("Dishes");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        tblMenu.setBackground(new java.awt.Color(255, 217, 151));
        tblMenu.setForeground(new java.awt.Color(255, 217, 151));
        tblMenu.setPreferredSize(new java.awt.Dimension(800, 800));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Dish Name");

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.setPreferredSize(new java.awt.Dimension(75, 25));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.setPreferredSize(new java.awt.Dimension(75, 25));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dish_label.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Price");

        jtMenuItem.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtMenuItem);

        tblLebel.setFont(new java.awt.Font("Norwester", 0, 24)); // NOI18N
        tblLebel.setForeground(new java.awt.Color(28, 16, 11));
        tblLebel.setText("Available Items");

        javax.swing.GroupLayout tblMenuLayout = new javax.swing.GroupLayout(tblMenu);
        tblMenu.setLayout(tblMenuLayout);
        tblMenuLayout.setHorizontalGroup(
            tblMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tblMenuLayout.createSequentialGroup()
                .addGroup(tblMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tblMenuLayout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addGroup(tblMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tblMenuLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(tblMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDishName, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(tblMenuLayout.createSequentialGroup()
                                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tblMenuLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(tblMenuLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(196, Short.MAX_VALUE))
            .addGroup(tblMenuLayout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(tblLebel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        tblMenuLayout.setVerticalGroup(
            tblMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tblMenuLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tblMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDishName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tblMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(tblMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblLebel, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(tblMenu, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String menuItemName = txtDishName.getText().trim();
        String price = txtPrice.getText().trim();
        int inserted =0;
            Menu menu = new Menu();
            menu.setMenuName(menuItemName);
            menu.setPrice(Integer.parseInt(price));
            inserted = menuService.checkMenuItem(menu);
            txtDishName.setText("");
            txtPrice.setText("");
            if ( inserted == 0) {
                JOptionPane.showMessageDialog(this, "No Data Inserted!");
            } else {
                JOptionPane.showMessageDialog(this, "Data Inserted Successfully!");
            }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtDishName.setText("");
        txtPrice.setText("");
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtMenuItem;
    private javax.swing.JLabel tblLebel;
    private javax.swing.JPanel tblMenu;
    private javax.swing.JTextField txtDishName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}