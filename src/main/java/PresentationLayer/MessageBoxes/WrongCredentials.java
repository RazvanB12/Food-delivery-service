package PresentationLayer.MessageBoxes;

import javax.swing.*;

public class WrongCredentials extends JFrame {
    private JLabel label;

    public WrongCredentials(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.setSize(260,100);

        label = new JLabel("WRONG CREDENTIALS!");
        label.setBounds(50,5, 200, 50);

        panel.add(label);
        this.add(panel);
    }
}
