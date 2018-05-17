/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ibrar
 */
public class LoginSupportClass extends JDesktopPane{
    private JTextField txtUserName;
    private JPasswordField txtPasswordField;
    private JButton btnLOgIn;
   
    protected void paintComponent(Graphics g){
        Image image = new ImageIcon("src/images/login_bg.jpg").getImage();
        try {
            Graphics2D g2d=(Graphics2D)g;
            double y=image.getHeight(null);
            double x=image.getWidth(null);
            g2d.scale(getWidth()/x, getHeight()/y);
            g2d.drawImage(image, 0, 0, this);
            
            txtUserName=new JTextField();
            txtPasswordField =new JPasswordField();
            btnLOgIn=new JButton();
            
            btnLOgIn.setSize(200, 100);
            
            txtUserName.setSize(500, 100);
            txtUserName.setLocation(100, 550);
            txtUserName.setVisible(true);
            txtPasswordField.setSize(500, 100);
            txtPasswordField.setLocation(100,680);
            txtPasswordField.setVisible(true);
            btnLOgIn.setLocation(250, 800);
            btnLOgIn.setText("Log In");
            btnLOgIn.setForeground(Color.white);
            btnLOgIn.setFont(btnLOgIn.getFont().deriveFont(40.0f));
            btnLOgIn.setBackground(new Color(210, 84, 0));
            
            btnLOgIn.setVisible(true);
           this. add(txtUserName);
            add(txtPasswordField);
            add(btnLOgIn);
            
         
        } catch (Exception e) {
        }
    }
    
}
