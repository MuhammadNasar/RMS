/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;



import entity.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import services.UserService;

public class LoginForm extends JFrame implements ActionListener {

    private UserService userService;
    
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");


    LoginForm() {
        
         JLabel bg_label = new JLabel();

        bg_label.setBorder(new EmptyBorder(5, 5, 5, 5));
        bg_label.setLayout(new BorderLayout(0, 0));
        setContentPane(bg_label);

        userService = new UserService();        
        userLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);
        showPassword.setForeground(Color.WHITE);
        
        
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer(bg_label);
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        
        
        userLabel.setBounds(150, 400, 100, 30);
        passwordLabel.setBounds(150, 470, 100, 30);
        userTextField.setBounds(250, 400, 150, 30);
        passwordField.setBounds(250, 470, 150, 30);
        showPassword.setBounds(250, 500, 150, 30);
        loginButton.setBounds(150, 550, 100, 30);
        resetButton.setBounds(300, 550, 100, 30);
        
      
        
    }

    public void addComponentsToContainer(JLabel container) {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        
        Background background = new Background();
        container.add(background, BorderLayout.CENTER);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userName;
            String password="";
            userName = userTextField.getText();
            char[] passwordArray = passwordField.getPassword();
            for(int i = 0; i < passwordArray.length; i++) {
                password = password + passwordArray[i];
            }
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            
            int canLogin = userService.tryLogin(user);
                    
            if (canLogin == 1) {
                MainForm mainForm = new MainForm();
                mainForm.setVisible(true);
                //this.add(mainForm);
                this.dispose();
               // JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password" + canLogin);
            }

        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }

}



