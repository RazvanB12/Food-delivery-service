package PresentationLayer.MessageBoxes;

import javax.swing.*;

public class OrderCreated extends JFrame {
    private JLabel label;

    public OrderCreated(int id){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.setSize(260,100);

        label = new JLabel("ORDER NO " + id + " WAS PLACED!");
        label.setBounds(50,5, 200, 50);

        panel.add(label);
        this.add(panel);
    }
}
