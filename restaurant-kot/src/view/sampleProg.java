/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class sampleProg extends javax.swing.JFrame {

    /**
     * Creates new form sampleProg
     */
    public sampleProg() {
        initComponents();

    }

    JButton button = new JButton("Result");
    JButton button2 = new JButton("Clear");

    JLabel label = new JLabel("Full Name");
    JLabel label2 = new JLabel("Age");
    JLabel label3 = new JLabel("English");
    JLabel label4 = new JLabel("Mathematics");
    JLabel label5 = new JLabel("Science");
    JLabel label6 = new JLabel("Social Studies");
    JLabel label7 = new JLabel("Height in cm");
    JLabel label8 = new JLabel("Weight in lbs");
    JLabel label9 = new JLabel("Message");
    JLabel label10 = new JLabel("Average");
    JLabel label11 = new JLabel("Remarks");
    JLabel label12 = new JLabel("Laurize Albarracin");

    JTextField text = new JTextField("");
    JTextField text2 = new JTextField("");
    JTextField text3 = new JTextField("");
    JTextField text4 = new JTextField("");
    JTextField text5 = new JTextField("");
    JTextField text6 = new JTextField("");
    JTextField text7 = new JTextField("");
    JTextField text8 = new JTextField("");
    JTextField text9 = new JTextField("");
    JTextField text10 = new JTextField("");
    JTextField text11 = new JTextField("");

    int average;

    JPanel background = new JPanel();
    JFrame frame = new JFrame();

    public sampleProg(String str) {
        super(str);

        background.setLayout(null);
        background.setBounds(30, 50, 90, 20);
        //background.setBounds(30, 50, 90, 20);

        button.setBounds(350, 170, 90, 20);
        button2.setBounds(450, 170, 90, 20);

        label.setBounds(30, 90, 90, 20);
        label2.setBounds(30, 130, 90, 20);
        label3.setBounds(30, 170, 90, 20);
        label4.setBounds(30, 210, 90, 20);
        label5.setBounds(30, 250, 90, 20);
        label6.setBounds(30, 290, 90, 20);
        label7.setBounds(350, 90, 90, 20);
        label8.setBounds(350, 130, 90, 20);
        label9.setBounds(350, 210, 90, 20);
        label10.setBounds(350, 250, 90, 20);
        label11.setBounds(350, 290, 90, 20);
        label12.setBounds(300, 35, 150, 20);

        text.setBounds(130, 90, 190, 20);
        text2.setBounds(130, 130, 190, 20);
        text3.setBounds(130, 170, 190, 20);
        text4.setBounds(130, 210, 190, 20);
        text5.setBounds(130, 250, 190, 20);
        text6.setBounds(130, 290, 190, 20);
        text7.setBounds(450, 90, 250, 20);
        text8.setBounds(450, 130, 250, 20);
        text9.setBounds(450, 210, 250, 20);
        text10.setBounds(450, 250, 250, 20);
        text11.setBounds(450, 290, 250, 20);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                text9.setText("Hi! " + text.getText() + "you are" + text2.getText() + "years of age and now you stand" + text7.getText() + "in cm while you're weight is" + text8.getText() + "in lbs. These are your remark and average");
                int English = Integer.parseInt(text3.getText());
                int Mathematics = Integer.parseInt(text4.getText());
                int Science = Integer.parseInt(text5.getText());
                int SocialStudies = Integer.parseInt(text6.getText());

                average = (English + Mathematics + Science + SocialStudies) / 4;
                text10.setText(Integer.toString(average));

            }
        }
        );

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setText("");
                text2.setText("");
                text3.setText("");
                text4.setText("");
                text5.setText("");
                text6.setText("");
                text7.setText("");
                text8.setText("");
                text9.setText("");
                text10.setText("");
                text11.setText("");

            }
        });

        background.add(button);
        background.add(button2);
        background.add(label);
        background.add(label2);
        background.add(label3);
        background.add(label4);
        background.add(label5);
        background.add(label6);
        background.add(label7);
        background.add(label8);
        background.add(label9);
        background.add(label10);
        background.add(label11);
        background.add(label12);

        background.add(text);
        background.add(text2);
        background.add(text3);
        background.add(text4);
        background.add(text5);
        background.add(text6);
        background.add(text7);
        background.add(text8);
        background.add(text9);
        background.add(text10);
        background.add(text11);

        getContentPane().add(background);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(sampleProg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sampleProg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sampleProg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sampleProg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new sampleProg().setVisible(true);

                sampleProg frame = new sampleProg("Swing Application");
                frame.setSize(730, 350);
                frame.show();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
