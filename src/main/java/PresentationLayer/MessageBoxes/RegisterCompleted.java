package PresentationLayer.MessageBoxes;

import javax.swing.*;

public class RegisterCompleted extends JFrame {
    private JLabel label;

    public RegisterCompleted(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.setSize(260,100);

        label = new JLabel("REGISTER COMPLETED!");
        label.setBounds(50,5, 200, 50);

        panel.add(label);
        this.add(panel);
    }
}
