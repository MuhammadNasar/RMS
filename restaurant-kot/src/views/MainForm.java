
package views;

import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicDesktopPaneUI;

public class MainForm extends javax.swing.JFrame {
    private MenuForm dish;
    private WaitersFormNew waiters;
    private ReportsForm reports;
    private OrdersForm  orders;
    private TablesForm  tables;
            
    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        
        
        
        desktopPane.setUI(new BasicDesktopPaneUI() {
            public void paint(Graphics g, JComponent c) {
                //c.setSize(1500, 1500);
                g.setColor(c.getBackground());
               //g.setColor(new Color(252, 242, 209));
                g.fillRect(0, 0, c.getWidth(), c.getHeight());
            }
        });
        
        
        //setIconImage(Toolkit.getDefaultToolkit().getClass().getResource("/images/logo_round.png"));
        //ImageIcon icon = new ImageIcon("");
        
        
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
        jPanel2 = new javax.swing.JPanel();
        btnHome = new javax.swing.JLabel();
        activeTab = new javax.swing.JLabel();
        btnDishes = new javax.swing.JLabel();
        btnWaiters = new javax.swing.JLabel();
        btnReports = new javax.swing.JLabel();
        btnOrders = new javax.swing.JLabel();
        btnTable = new javax.swing.JLabel();
        btnUser = new javax.swing.JLabel();
        desktopPane = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Form | KOT");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(28, 16, 11));
        jPanel1.setPreferredSize(new java.awt.Dimension(1075, 684));

        jPanel2.setBackground(new java.awt.Color(28, 16, 11));

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_home_normal.png"))); // NOI18N
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });

        btnDishes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_dishes_normal.png"))); // NOI18N
        btnDishes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDishesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDishesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDishesMouseExited(evt);
            }
        });

        btnWaiters.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_waiters_normal.png"))); // NOI18N
        btnWaiters.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnWaitersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnWaitersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnWaitersMouseExited(evt);
            }
        });

        btnReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_reports_normal.png"))); // NOI18N
        btnReports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportsMouseExited(evt);
            }
        });

        btnOrders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_orders_normal.png"))); // NOI18N
        btnOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrdersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOrdersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOrdersMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(activeTab, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnWaiters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDishes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 60, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(activeTab, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDishes, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnWaiters)
                .addGap(18, 18, 18)
                .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOrders)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_table_normal.png"))); // NOI18N
        btnTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTableMouseExited(evt);
            }
        });

        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_user_normal.png"))); // NOI18N
        btnUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUserMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(btnUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTable)
                .addGap(18, 18, 18)
                .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        desktopPane.setBackground(new java.awt.Color(255, 217, 151));
        desktopPane.setForeground(new java.awt.Color(255, 217, 151));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1007, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(desktopPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_home_mhover.png"));
        btnHome.setIcon(btnimage);
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_home_normal.png"));
        btnHome.setIcon(btnimage);
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_home_clicked.png"));
        btnHome.setIcon(btnimage);
        ImageIcon btnimage2 = new ImageIcon(getClass().getResource("/images/home_icon.png"));
        activeTab.setIcon(btnimage2);
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnDishesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDishesMouseEntered
        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_dishes_mhover.png"));
        btnDishes.setIcon(btnimage);
    }//GEN-LAST:event_btnDishesMouseEntered

    private void btnDishesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDishesMouseExited
       ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_dishes_normal.png"));
        btnDishes.setIcon(btnimage);
    }//GEN-LAST:event_btnDishesMouseExited

    private void btnDishesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDishesMouseClicked
        
        dish = new MenuForm();
        desktopPane.add(dish);
            dish.setVisible(true);
            try {
            dish.setMaximum(true);
        } catch (Exception ex) {
            
        }
        System.out.print("Am here 1");
        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_dishes_clicked.png"));
        btnDishes.setIcon(btnimage);
        ImageIcon btnimage2 = new ImageIcon(getClass().getResource("/images/dishes_icon.png"));
        activeTab.setIcon(btnimage2);
        
    }//GEN-LAST:event_btnDishesMouseClicked

    private void btnWaitersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWaitersMouseEntered
        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_waiters_mhover.png"));
        btnWaiters.setIcon(btnimage);
    }//GEN-LAST:event_btnWaitersMouseEntered

    private void btnWaitersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWaitersMouseExited
        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_waiters_normal.png"));
        btnWaiters.setIcon(btnimage);
    }//GEN-LAST:event_btnWaitersMouseExited

    private void btnWaitersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnWaitersMouseClicked
       
        waiters = new WaitersFormNew();
        desktopPane.add(waiters);
        waiters.setVisible(true);
             try {
            waiters.setMaximum(true);
        } catch (Exception ex) {
            
        }
        
        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_waiters_clicked.png"));
        btnWaiters.setIcon(btnimage);
        ImageIcon activeTabicon = new ImageIcon(getClass().getResource("/images/waiters_icon.png"));
        activeTab.setIcon(activeTabicon);
    }//GEN-LAST:event_btnWaitersMouseClicked

    private void btnReportsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportsMouseEntered
        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_reports_mhover.png"));
        btnReports.setIcon(btnimage);
    }//GEN-LAST:event_btnReportsMouseEntered

    private void btnReportsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportsMouseExited
        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_reports_normal.png"));
        btnReports.setIcon(btnimage);
    }//GEN-LAST:event_btnReportsMouseExited

    private void btnReportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportsMouseClicked
        reports= new ReportsForm();
        desktopPane.add(reports);
        reports.setVisible(true);
           try {
            reports.setMaximum(true);
        } catch (Exception ex) {
            
        }

        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_reports_clicked.png"));
        btnReports.setIcon(btnimage);
        ImageIcon activeTabicon = new ImageIcon(getClass().getResource("/images/reports_icon.png"));
        activeTab.setIcon(activeTabicon);
    }//GEN-LAST:event_btnReportsMouseClicked

    private void btnOrdersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdersMouseEntered
        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_orders_mhover.png"));
        btnOrders.setIcon(btnimage);
    }//GEN-LAST:event_btnOrdersMouseEntered

    private void btnOrdersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdersMouseExited
        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_orders_normal.png"));
        btnOrders.setIcon(btnimage);
    }//GEN-LAST:event_btnOrdersMouseExited

    private void btnOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdersMouseClicked

        
        orders = new OrdersForm();
        desktopPane.add(orders);
        orders.setVisible(true);
          try {
            orders.setMaximum(true);
        } catch (Exception ex) {
            
        }
        
        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_orders_clicked.png"));
        btnOrders.setIcon(btnimage);
        ImageIcon activeTabicon = new ImageIcon(getClass().getResource("/images/orders_icon.png"));
        activeTab.setIcon(activeTabicon);
        
    }//GEN-LAST:event_btnOrdersMouseClicked

    private void btnTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTableMouseEntered
        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_table_mhover.png"));
        btnTable.setIcon(btnimage);
    }//GEN-LAST:event_btnTableMouseEntered

    private void btnTableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTableMouseExited
        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_table_normal.png"));
        btnTable.setIcon(btnimage);
    }//GEN-LAST:event_btnTableMouseExited

    private void btnTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTableMouseClicked
        
        tables = new TablesForm();
        desktopPane.add(tables);
        tables.setVisible(true);
          try {
            tables.setMaximum(true);
        } catch (Exception ex) {
            
        }
        
        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_table_clicked.png"));
        btnTable.setIcon(btnimage);
        ImageIcon activeTabicon = new ImageIcon(getClass().getResource("/images/table_icon.png"));
        activeTab.setIcon(activeTabicon);
    }//GEN-LAST:event_btnTableMouseClicked

    private void btnUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserMouseEntered
        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_user_mhover.png"));
        btnUser.setIcon(btnimage);
    }//GEN-LAST:event_btnUserMouseEntered

    private void btnUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserMouseExited
        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_user_normal.png"));
        btnUser.setIcon(btnimage);
    }//GEN-LAST:event_btnUserMouseExited

    private void btnUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserMouseClicked
        ImageIcon btnimage = new ImageIcon(getClass().getResource("/images/btn_user_clicked.png"));
        btnUser.setIcon(btnimage);
        ImageIcon activeTabicon = new ImageIcon(getClass().getResource("/images/user_icon.png"));
        activeTab.setIcon(activeTabicon);
    }//GEN-LAST:event_btnUserMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activeTab;
    private javax.swing.JLabel btnDishes;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnOrders;
    private javax.swing.JLabel btnReports;
    private javax.swing.JLabel btnTable;
    private javax.swing.JLabel btnUser;
    private javax.swing.JLabel btnWaiters;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
