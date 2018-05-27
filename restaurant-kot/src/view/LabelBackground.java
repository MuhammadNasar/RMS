/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author User
 */
public class LabelBackground {
    
    public static void main(String[] args) {
        new LabelBackground();
    }

    public LabelBackground() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                try {
                    // Load the background image
                    BufferedImage img = ImageIO.read(new File("src/images/login_bg.jpg"));

                    // Create the frame...
                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    // Set the frames content pane to use a JLabel
                    // whose icon property has been set to use the image
                    // we just loaded                        
                    frame.setContentPane(new JLabel(new ImageIcon(img)));

                    // Supply a layout manager for the body of the content
                    frame.setLayout(new GridBagLayout());
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridwidth = GridBagConstraints.ABOVE_BASELINE;
                    //gbc.gridheight = GridBagConstraints.VERTICAL;
                    // Add stuff...
                    //frame.add(new JLabel("Hello world"), gbc);
                    //frame.add(new JLabel("I'm on top"), gbc);
                    //frame.add(new JButton("Clickity-clackity"), gbc);
                    frame.setExtendedState(6);
                    JTextField txtUserName = new JTextField("username");
                    txtUserName.setSize(200, 200);
                    //txtUserName.setBounds(50, 50, 200, 200);
                    //txtUserName.setLocation(100, 100);
                    frame.add(txtUserName, gbc);

                    frame.pack();
                    //frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }
}
