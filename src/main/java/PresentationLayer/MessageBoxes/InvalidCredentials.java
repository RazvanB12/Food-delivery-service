package PresentationLayer.MessageBoxes;

import javax.swing.*;

public class InvalidCredentials extends JFrame {
    private JLabel label;

    public InvalidCredentials(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.setSize(260,100);

        label = new JLabel("INVALID CREDENTIALS!");
        label.setBounds(50,5, 200, 50);

        panel.add(label);
        this.add(panel);
    }
}
