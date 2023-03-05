package PresentationLayer.Views;

import DataLayer.Roles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JLabel titleLabel;
    private JLabel typeLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel registerLabel;
    private JComboBox comboBox;
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton;
    private JButton registerButton;

    public LoginView(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setTitle("LOGIN");

        titleLabel = new JLabel("FOOD DELIVERY");
        titleLabel.setBounds(100,30, 300, 50);
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 30));

        typeLabel = new JLabel("USER TYPE");
        typeLabel.setBounds(50,80, 200, 50);
        typeLabel.setFont(new Font("Calibri", Font.BOLD, 20));

        usernameLabel = new JLabel("USERNAME");
        usernameLabel.setBounds(50,130, 200, 50);
        usernameLabel.setFont(new Font("Calibri", Font.BOLD, 20));

        passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setBounds(50,180, 200, 50);
        passwordLabel.setFont(new Font("Calibri", Font.BOLD, 20));

        comboBox = new JComboBox(Roles.values());
        comboBox.setBounds(180, 90, 100, 25);
        comboBox.setFont(new Font("Calibri", Font.BOLD, 15));

        username = new JTextField();
        username.setBounds(180, 140, 150, 25);
        username.setFont(new Font("Calibri", Font.BOLD, 15));

        password = new JPasswordField();
        password.setBounds(180, 190, 150, 25);
        password.setFont(new Font("Calibri", Font.BOLD, 15));

        loginButton = new JButton("LOGIN");
        loginButton.setBounds(215, 240, 80, 25);
        loginButton.setFont(new Font("Calibri", Font.BOLD, 15));

        registerLabel = new JLabel("New client? Create an account here!");
        registerLabel.setBounds(50, 320, 200, 25);
        registerLabel.setFont(new Font("Calibri", Font.BOLD, 12));

        registerButton = new JButton("REGISTER");
        registerButton.setBounds(250, 320, 80, 20);
        registerButton.setFont(new Font("Calibri", Font.BOLD, 12));

        panel.add(titleLabel);
        panel.add(typeLabel);
        panel.add(usernameLabel);
        panel.add(passwordLabel);
        panel.add(comboBox);
        panel.add(username);
        panel.add(password);
        panel.add(loginButton);
        panel.add(registerLabel);
        panel.add(registerButton);
        this.add(panel);
    }

    public void addLoginListener (ActionListener listener){loginButton.addActionListener(listener);}

    public void addRegisterListener (ActionListener listener){registerButton.addActionListener(listener);}

    public JComboBox getComboBox() {return comboBox;}

    public JTextField getUsername() {
        return username;
    }

    public JPasswordField getPassword() {
        return password;
    }
}
