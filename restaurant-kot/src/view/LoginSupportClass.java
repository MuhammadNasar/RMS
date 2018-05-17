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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;

/**
 *
 * @author ibrar
 */
public class LoginSupportClass extends JDesktopPane{
   
    protected void paintComponent(Graphics g){
        Image image = new ImageIcon("src/images/login_bg.jpg").getImage();
        try {
            Graphics2D g2d=(Graphics2D)g;
            double y=image.getHeight(null);
            double x=image.getWidth(null);
            g2d.scale(getWidth()/x, getHeight()/y);
            g2d.drawImage(image, 0, 0, this);
            
         
        } catch (Exception e) {
        }
    }
    
}
