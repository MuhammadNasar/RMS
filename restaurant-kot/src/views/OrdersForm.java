/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.itextpdf.layout.element.Table;
import entity.Menu;
import entity.Order;
import entity.Tables;
import entity.TotalPrice;
import entity.Waiters;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import services.CommonService;
import services.OrderService;
import table_models.OrderTableModel;



/**
 *
 * @author ehsas
 */
public class OrdersForm extends javax.swing.JInternalFrame {
    private CommonService commonService;
    private Vector<Tables> vectorTable;
    private Vector<Menu> vectorMenu;
    private Vector<Waiters> vectorWaiter;
    private Vector<Order> vectorOrder;
    private OrderService orderService;
    
    private TotalPrice totalPriceSave;
    
    public OrdersForm() {
        initComponents();
        
        this.getContentPane().setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(new Color(201, 201, 201)));
        javax.swing.plaf.InternalFrameUI ifu = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);
        
        commonService = new CommonService();
        
        vectorTable = new Vector<>();
        vectorMenu = new Vector<>();
        vectorWaiter = new Vector<>();
        vectorOrder = new Vector<>();
        
        orderService = new OrderService();
        totalPriceSave = new TotalPrice();
        
        
        vectorTable = commonService.getVectorTables();
        vectorMenu = commonService.getVectorMenuItem();
        vectorWaiter = commonService.getVectorWaiters();
        orderService = new OrderService();
        
        DefaultComboBoxModel tableModel = new DefaultComboBoxModel(vectorTable);
        cmbTable.setModel(tableModel);
        
        DefaultComboBoxModel waiterModel = new DefaultComboBoxModel(vectorWaiter);
        cmbWaiter.setModel(waiterModel);
        
        DefaultComboBoxModel menuModel = new DefaultComboBoxModel(vectorMenu);
        cmbMenuItem.setModel(menuModel);
        //tableDesin();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        saveOrder = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbMenuItem = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbTable = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        totalPrice = new javax.swing.JLabel();
        cmbWaiter = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jsQuantity = new javax.swing.JSpinner();
        btnAddToList = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 217, 151));
        setTitle("Orders");

        jPanel1.setBackground(new java.awt.Color(255, 217, 151));

        saveOrder.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        saveOrder.setText("Save");
        saveOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveOrderActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Select Menu Item");

        cmbMenuItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMenuItemActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Select Table");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Total Price Rs:");

        cmbTable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
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
        orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(orderTable);

        totalPrice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalPrice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalPrice.setText("1");
        totalPrice.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        cmbWaiter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Quantity");

        jsQuantity.setValue(1);

        btnAddToList.setText("+");
        btnAddToList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToListActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Select Waiter");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/order_label.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Click On Row To remove Menu Item ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(cmbTable, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbMenuItem, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel5))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(cmbWaiter, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(totalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jsQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnAddToList, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(saveOrder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(248, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbWaiter)
                    .addComponent(cmbTable, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbMenuItem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddToList, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jsQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(totalPrice)
                            .addComponent(jLabel6))))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void cmbMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMenuItemActionPerformed

    private void btnAddToListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToListActionPerformed
        Tables table = (Tables) cmbTable.getSelectedItem();
        Waiters waiter = (Waiters) cmbWaiter.getSelectedItem();
        Menu menuItem = (Menu) cmbMenuItem.getSelectedItem();
        int quantity = Integer.parseInt(jsQuantity.getValue().toString());
        if (!(quantity < 0 || quantity == 0)) {
        Order order = new Order();
        order.setTable(table);
        order.setWaiter(waiter);
        order.setMenuItem(menuItem);
        order.setQuantity(quantity);
        if (quantity > 1) {
            int counted1 =0;
            counted1 = totalPriceSave.getTotalPrice()+ menuItem.getPrice() * quantity;
            totalPriceSave.setTotalPrice(counted1);
            totalPrice.setText(totalPriceSave.getTotalPrice()+"");
        } else {
            int counted2 =0;
            counted2 = menuItem.getPrice()+totalPriceSave.getTotalPrice();
            totalPriceSave.setTotalPrice(counted2);
            totalPrice.setText(counted2+"");
        }
        vectorOrder.add(order);
        
        OrderTableModel orderModel = new OrderTableModel(vectorOrder);
        orderTable.setModel(orderModel);   
        } else {
            JOptionPane.showMessageDialog(this, "Quantity Cant be 0 or Less then 0");
        }
    }//GEN-LAST:event_btnAddToListActionPerformed

    private void orderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderTableMouseClicked
        int selectedRow = orderTable.getSelectedRow();
        int choice = JOptionPane.showConfirmDialog(this, "Are You Sure You want To Remove This Item?");
        
        if ( choice == 0) {
            int minus =0;
            int newPrice =0;
            int selectItemPrice = vectorOrder.get(selectedRow).getMenuItem().getPrice();
            int quantity = vectorOrder.get(selectedRow).getQuantity();
            
            if(quantity > 1) {
                int quantityMultiplyselectItemPrice = 0;
                quantityMultiplyselectItemPrice = selectItemPrice * quantity;
                newPrice = totalPriceSave.getTotalPrice() - quantityMultiplyselectItemPrice;
                totalPriceSave.setTotalPrice(newPrice);
                totalPrice.setText(newPrice+"");
                
            }else {
                newPrice = totalPriceSave.getTotalPrice()- selectItemPrice;
            }
            
            
            totalPriceSave.setTotalPrice(newPrice);
            totalPrice.setText(newPrice+"");
            
            
            System.out.println(selectItemPrice);
            vectorOrder.removeElementAt(selectedRow);
            OrderTableModel orderModel = new OrderTableModel(vectorOrder);
            orderTable.setModel(orderModel);
        }
    }//GEN-LAST:event_orderTableMouseClicked

    private void saveOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveOrderActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Are You Sure The Order Is Confirmed?");
        if( choice == 0) {
            orderService.ConfirmOrder(vectorOrder);
        }
    }//GEN-LAST:event_saveOrderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToList;
    private javax.swing.JComboBox<String> cmbMenuItem;
    private javax.swing.JComboBox<String> cmbTable;
    private javax.swing.JComboBox<String> cmbWaiter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jsQuantity;
    private javax.swing.JTable orderTable;
    private javax.swing.JButton saveOrder;
    private javax.swing.JLabel totalPrice;
    // End of variables declaration//GEN-END:variables

public void tableDesin(){
        JTableHeader header = orderTable.getTableHeader();
        header.setPreferredSize(new Dimension(150, 50));
        //  header.setBorder(new DropShadowBorder());
        header.setBounds(20, 20, 30, 30);
        header.setFont(new Font("Tahoma", Font.BOLD, 15));
        header.setBackground(Color.red);

        orderTable.setBackground(Color.red);
        ((DefaultTableCellRenderer) orderTable.getDefaultRenderer(Object.class)).setBackground(new Color(255, 255, 204));
        
        orderTable.setRowHeight(1, 30);
        orderTable.setGridColor(Color.red);
        orderTable.setForeground(Color.black);
        jScrollPane1.setBackground(Color.red);
        orderTable.setOpaque(false);
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        orderTable.setFont(new Font("Tahome", Font.PLAIN, 20));

        jScrollPane1.getViewport().setOpaque(false);
        orderTable.setShowGrid(true);
    }
}
