package PresentationLayer.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame {
    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField username;
    private JTextField password;
    private JButton createButton;

    public RegisterView (){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.setSize(400,280);
        this.setTitle("REGISTER");

        titleLabel = new JLabel("CLIENT REGISTRATION");
        titleLabel.setBounds(50,30, 300, 50);
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 30));

        usernameLabel = new JLabel("USERNAME");
        usernameLabel.setBounds(50,80, 200, 50);
        usernameLabel.setFont(new Font("Calibri", Font.BOLD, 20));

        passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setBounds(50,130, 200, 50);
        passwordLabel.setFont(new Font("Calibri", Font.BOLD, 20));

        username = new JTextField();
        username.setBounds(180, 90, 150, 25);
        username.setFont(new Font("Calibri", Font.BOLD, 15));

        password = new JTextField();
        password.setBounds(180, 140, 150, 25);
        password.setFont(new Font("Calibri", Font.BOLD, 15));

        createButton = new JButton("CREATE ACCOUNT");
        createButton.setBounds(180, 190, 150, 25);
        createButton.setFont(new Font("Calibri", Font.BOLD, 15));

        panel.add(titleLabel);
        panel.add(usernameLabel);
        panel.add(passwordLabel);
        panel.add(username);
        panel.add(password);
        panel.add(createButton);
        this.add(panel);
    }

    public void addCreateListener (ActionListener listener){createButton.addActionListener(listener);}

    public JTextField getUsername() {
        return username;
    }

    public JTextField getPassword() {
        return password;
    }
}
