/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import entity.Menu;
import entity.PendingBillUpdate;
import entity.PendingBill;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import services.CommonService;
import services.PandingBillService;
import table_models.PendingBillDetailTableModel;
import table_models.PendingBillTableModel;

/**
 *
 * @author ibrar
 */
public class PendingBillsForm extends javax.swing.JInternalFrame {

    private Vector<PendingBill> vectorPandingBills;
    private CommonService commonService;
    private Vector<PendingBillUpdate> pendigBillUpdate;
    private PandingBillService pendingBillService;

    /**
     * Creates new form PandingBills
     */
    public PendingBillsForm() {
        initComponents();

        design();
        commonService = new CommonService();
        vectorPandingBills = commonService.getVectorPangdingBill();
        PendingBillTableModel pandingBillTableModel = new PendingBillTableModel(vectorPandingBills);
        tblPendingBill.setModel(pandingBillTableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPendingBill = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPendingBill1 = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        txtDiscount = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtNetToPay = new javax.swing.JTextField();
        txtDiscountAmount = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 217, 151));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));

        tblPendingBill.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPendingBill.setRowHeight(20);
        tblPendingBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPendingBillMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPendingBill);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 10, 0, 0);
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(255, 217, 151));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));

        tblPendingBill1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item Name", "Quantity", "Price", "Total"
            }
        ));
        tblPendingBill1.setRowHeight(20);
        jScrollPane2.setViewportView(tblPendingBill1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 0, 0);
        getContentPane().add(jPanel2, gridBagConstraints);

        btnSave.setText("Ganrate Bill");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridheight = 9;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.ipady = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 18, 31, 27);
        getContentPane().add(btnSave, gridBagConstraints);

        txtDiscount.setText("0");
        txtDiscount.setToolTipText("Enter Only Digit Data");
        txtDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtDiscountMouseExited(evt);
            }
        });
        txtDiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiscountActionPerformed(evt);
            }
        });
        txtDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiscountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiscountKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 105;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 18, 0, 27);
        getContentPane().add(txtDiscount, gridBagConstraints);

        txtTotal.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 105;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 18, 0, 27);
        getContentPane().add(txtTotal, gridBagConstraints);

        txtNetToPay.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 105;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 18, 0, 27);
        getContentPane().add(txtNetToPay, gridBagConstraints);

        txtDiscountAmount.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 105;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 18, 0, 27);
        getContentPane().add(txtDiscountAmount, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Discount");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.ipady = 29;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 18, 0, 0);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Total Amount");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 18, 0, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Discount Amount");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 29;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 18, 0, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Net To PAy");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 29;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 18, 0, 0);
        getContentPane().add(jLabel4, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPendingBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPendingBillMouseClicked
        int index = tblPendingBill.getSelectedRow();
        PendingBillTableModel pandingBillTableModel = (PendingBillTableModel) tblPendingBill.getModel();
        String kot_id = pandingBillTableModel.getValueAt(index, 0).toString();
        pendigBillUpdate = pendigBillUpdate = commonService.getVectorPandingBill(kot_id);
        PendingBillDetailTableModel billDetailTableModel = new PendingBillDetailTableModel(pendigBillUpdate);
        tblPendingBill1.setModel(billDetailTableModel);
        txtTotal.setText(commonService.total + "");
        devision();


    }//GEN-LAST:event_tblPendingBillMouseClicked

    private void txtDiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiscountActionPerformed
        devision();
    }//GEN-LAST:event_txtDiscountActionPerformed

    private void txtDiscountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscountKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtDiscountKeyTyped

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            int choic = JOptionPane.showConfirmDialog(null, "Are you Sure to Generate Bill");
            if (choic == 0) {
                int index = tblPendingBill.getSelectedRow();
                PendingBillTableModel billTableModel = (PendingBillTableModel) tblPendingBill.getModel();
                String kot_id = billTableModel.getValueAt(index, 0).toString();

                PendingBillUpdate billUpdate = new PendingBillUpdate();
                billUpdate.setId(Integer.parseInt(kot_id));
                billUpdate.setTotal(Integer.parseInt(txtTotal.getText()));
                billUpdate.setTotalRecievabelAmount(Integer.parseInt(txtNetToPay.getText()));
                billUpdate.setDiscount(Integer.parseInt(txtDiscount.getText()));
                billUpdate.setDiscountAmount(Integer.parseInt(txtDiscountAmount.getText()));
                billUpdate.setNetAmount(Integer.parseInt(txtNetToPay.getText()));
                pendingBillService = new PandingBillService();
                pendingBillService.generatePandingbill(billUpdate);
                printAllMenuItems();

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Empty Result");
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtDiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscountKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiscountKeyReleased

    private void txtDiscountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDiscountMouseExited
        devision();
    }//GEN-LAST:event_txtDiscountMouseExited
    public void devision() {
        try {
            int total = Integer.parseInt(txtTotal.getText());
            int discount = Integer.parseInt(txtDiscount.getText());
            int discAmount = total * discount / 100;
            total = total - discAmount;
            txtDiscountAmount.setText(discAmount + "");
            txtNetToPay.setText(total + "");
        } catch (Exception e) {

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblPendingBill;
    private javax.swing.JTable tblPendingBill1;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtDiscountAmount;
    private javax.swing.JTextField txtNetToPay;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
private void design() {

        this.getContentPane().setBackground(new Color(255, 217, 151));
        setBorder(BorderFactory.createLineBorder(new Color(235, 163, 91)));
        javax.swing.plaf.InternalFrameUI ifu = this.getUI();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) ifu).setNorthPane(null);
        JTableHeader header = tblPendingBill.getTableHeader();
        header.setPreferredSize(new Dimension(150, 50));
        //  header.setBorder(new DropShadowBorder());
        header.setBounds(20, 20, 30, 30);
        header.setFont(new Font("Tahoma", Font.BOLD, 15));
        header.setBackground(Color.red);

        tblPendingBill.setBackground(Color.red);
        ((DefaultTableCellRenderer) tblPendingBill.getDefaultRenderer(Object.class)).setBackground(new Color(255, 255, 204));

        tblPendingBill.setGridColor(Color.red);
        tblPendingBill.setForeground(Color.black);
        jScrollPane1.setBackground(Color.red);
        tblPendingBill.setOpaque(false);
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        tblPendingBill.setFont(new Font("Tahome", Font.PLAIN, 20));

        jScrollPane1.getViewport().setOpaque(false);
        tblPendingBill.setShowGrid(true);

        JTableHeader heade = tblPendingBill1.getTableHeader();
        heade.setPreferredSize(new Dimension(150, 50));
        //  header.setBorder(new DropShadowBorder());
        heade.setBounds(20, 20, 30, 30);
        heade.setFont(new Font("Tahoma", Font.BOLD, 15));
        heade.setBackground(Color.red);

        tblPendingBill1.setBackground(Color.red);
        ((DefaultTableCellRenderer) tblPendingBill1.getDefaultRenderer(Object.class)).setBackground(new Color(255, 255, 204));

        tblPendingBill1.setGridColor(Color.red);
        tblPendingBill1.setForeground(Color.black);
        jScrollPane1.setBackground(Color.red);
        tblPendingBill1.setOpaque(false);
        ((DefaultTableCellRenderer) heade.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        tblPendingBill1.setFont(new Font("Tahome", Font.ITALIC, 12));

        jScrollPane1.getViewport().setOpaque(false);
        tblPendingBill1.setShowGrid(true);

    }

    public void printAllMenuItems() {
        int index = tblPendingBill.getSelectedRow();
        PendingBillTableModel pandingBillTableModel = (PendingBillTableModel) tblPendingBill.getModel();
        try {
            PdfDocument pdfDocument = new PdfDocument(new PdfWriter("./panding_bill.pdf"));
            Document layoutDocument = new Document(pdfDocument);

            //title
            layoutDocument.add(new Paragraph("THE WAITERS RESTAURANT").setBold().setUnderline()
                    .setTextAlignment(TextAlignment.CENTER));

            //other reference information
            layoutDocument.add(new Paragraph("Bill")
                    .setTextAlignment(TextAlignment.LEFT).setMultipliedLeading(0.2f).setBold());
            layoutDocument.add(new Paragraph("Bill Number       :" + pandingBillTableModel.getValueAt(index, 0).toString())
                    .setTextAlignment(TextAlignment.LEFT).setMultipliedLeading(0.2f));
            layoutDocument.add(new Paragraph("Table Name      :" + pandingBillTableModel.getValueAt(index, 1).toString())
                    .setTextAlignment(TextAlignment.LEFT).setMultipliedLeading(0.2f));
            layoutDocument.add(new Paragraph("Wainter Name    :" + pandingBillTableModel.getValueAt(index, 2).toString())
                    .setTextAlignment(TextAlignment.LEFT).setMultipliedLeading(0.2f));

            //create items to add into pdf
            //create a table to display items into tabular form
            Table table = new Table(UnitValue.createPointArray(new float[]{80f, 180f, 100f, 100f, 100f}));
            table.setTextAlignment(TextAlignment.CENTER);
            table.setHorizontalAlignment(HorizontalAlignment.CENTER);
            //headers
            table.addCell(new Paragraph("S.N.O").setBold());
            table.addCell(new Paragraph("Item Name").setBold());
            table.addCell(new Paragraph("Quantity").setBold());
            table.addCell(new Paragraph("Rate").setBold());
            table.addCell(new Paragraph("Total").setBold());
            String kot_id = pandingBillTableModel.getValueAt(index, 0).toString();

            //Now Add Data Into these table Columns
            int a = 1;
            Vector<PendingBillUpdate> pandigBillUpdates = commonService.getVectorPandingBill(kot_id + "");
            for (PendingBillUpdate menu : pandigBillUpdates) {

                table.addCell(new Paragraph(a + ""));
                table.addCell(new Paragraph(menu.getMenu().getMenuName() + ""));
                table.addCell(new Paragraph(menu.getQuantity() + ""));
                table.addCell(new Paragraph(menu.getMenu().getPrice() + ""));
                table.addCell(new Paragraph(menu.getSum() + ""));
                a = a + 1;
            }

            // add table to pdf
            layoutDocument.add(table);

            String totalAmmount = "Total =      " + txtTotal.getText().trim();
            String discounRate = "Discount Rate =      " + txtDiscount.getText().trim();
            String discountAmmount = "Discount Ammount =      " + txtDiscountAmount.getText().trim();
            String netToPay = "Net To Pay =      " + txtNetToPay.getText().trim();
            layoutDocument.add(new Paragraph("    ").setTextAlignment(TextAlignment.RIGHT));
            layoutDocument.add(new Paragraph(totalAmmount).setTextAlignment(TextAlignment.RIGHT));
            layoutDocument.add(new Paragraph(discounRate).setTextAlignment(TextAlignment.RIGHT));
            layoutDocument.add(new Paragraph(discountAmmount).setTextAlignment(TextAlignment.RIGHT));
            layoutDocument.add(new Paragraph(netToPay).setTextAlignment(TextAlignment.RIGHT));

            //close document
            layoutDocument.close();

            //now opening it in browser to print
            File pdfFile = new File("./panding_bill.pdf");
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                    System.out.println("File Has Been Opened Successfully!");
                } else {
                    System.out.println("Desktop Not Supported!");
                }
            } else {
                System.out.println("File Is Not Generated Successfully");
            }

        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
