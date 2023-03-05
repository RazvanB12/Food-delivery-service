package PresentationLayer.Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ReportsView extends JFrame {
    private JTextArea textArea;
    private JButton button1, button2, button3, button4;
    private JTextField start, end, min1, min2, min3, year, month, day;
    private JLabel startL, endL, min1L, min2L, min3L, yearL, monthL, dayL;

    public ReportsView(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("ReportsView");

        button1 = new JButton("GENERATE REPORT");
        button1.setBounds(50, 150, 200, 30);
        button1.setFont(new Font("Calibri", Font.BOLD, 15));

        button2 = new JButton("GENERATE REPORT");
        button2.setBounds(50, 300, 200, 30);
        button2.setFont(new Font("Calibri", Font.BOLD, 15));

        button3 = new JButton("GENERATE REPORT");
        button3.setBounds(50, 450, 200, 30);
        button3.setFont(new Font("Calibri", Font.BOLD, 15));

        button4 = new JButton("GENERATE REPORT");
        button4.setBounds(50, 600, 200, 30);
        button4.setFont(new Font("Calibri", Font.BOLD, 15));

        start = new JTextField();
        start.setBounds(300, 150, 100, 30);
        start.setFont(new Font("Calibri", Font.BOLD, 20));

        end = new JTextField();
        end.setBounds(450, 150, 100, 30);
        end.setFont(new Font("Calibri", Font.BOLD, 20));

        min1 = new JTextField();
        min1.setBounds(300, 300, 100, 30);
        min1.setFont(new Font("Calibri", Font.BOLD, 20));

        min2 = new JTextField();
        min2.setBounds(300, 450, 100, 30);
        min2.setFont(new Font("Calibri", Font.BOLD, 20));

        min3 = new JTextField();
        min3.setBounds(450, 450, 100, 30);
        min3.setFont(new Font("Calibri", Font.BOLD, 20));

        year = new JTextField();
        year.setBounds(300, 600, 100, 30);
        year.setFont(new Font("Calibri", Font.BOLD, 20));

        month = new JTextField();
        month.setBounds(450, 600, 100, 30);
        month.setFont(new Font("Calibri", Font.BOLD, 20));

        day = new JTextField();
        day.setBounds(600, 600, 100, 30);
        day.setFont(new Font("Calibri", Font.BOLD, 20));

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.WHITE);
        textArea.setBounds(800,100, 700, 600);
        textArea.setFont(new Font("Calibri", Font.BOLD, 15));

        startL = new JLabel("START");
        startL.setBounds(335, 120, 100, 30);
        startL.setFont(new Font("Calibri", Font.BOLD, 15));

        endL = new JLabel("END");
        endL.setBounds(490, 120, 100, 30);
        endL.setFont(new Font("Calibri", Font.BOLD, 15));

        min1L = new JLabel("MIN TIMES");
        min1L.setBounds(315, 270, 100, 30);
        min1L.setFont(new Font("Calibri", Font.BOLD, 15));

        min2L = new JLabel("MIN TIMES");
        min2L.setBounds(315, 420, 100, 30);
        min2L.setFont(new Font("Calibri", Font.BOLD, 15));

        min3L = new JLabel("MIN VALUE");
        min3L.setBounds(465, 420, 100, 30);
        min3L.setFont(new Font("Calibri", Font.BOLD, 15));

        yearL = new JLabel("YEAR");
        yearL.setBounds(330, 570, 100, 30);
        yearL.setFont(new Font("Calibri", Font.BOLD, 15));

        monthL = new JLabel("MONTH");
        monthL.setBounds(475, 570, 100, 30);
        monthL.setFont(new Font("Calibri", Font.BOLD, 15));

        dayL = new JLabel("DAY");
        dayL.setBounds(635, 570, 100, 30);
        dayL.setFont(new Font("Calibri", Font.BOLD, 15));

        panel.add(startL);
        panel.add(endL);
        panel.add(min1L);
        panel.add(min2L);
        panel.add(min3L);
        panel.add(yearL);
        panel.add(monthL);
        panel.add(dayL);
        panel.add(textArea);
        panel.add(min1);
        panel.add(min2);
        panel.add(min3);
        panel.add(year);
        panel.add(month);
        panel.add(day);
        panel.add(end);
        panel.add(start);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        this.add(panel);
    }

    public void addButton1Listener (ActionListener listener){button1.addActionListener(listener);}

    public void addButton2Listener (ActionListener listener){button2.addActionListener(listener);}

    public void addButton3Listener (ActionListener listener){button3.addActionListener(listener);}

    public void addButton4Listener (ActionListener listener){button4.addActionListener(listener);}

    public JTextArea getTextArea() {
        return textArea;
    }

    public JTextField getStart() {
        return start;
    }

    public JTextField getEnd() {
        return end;
    }

    public JTextField getMin1() {
        return min1;
    }

    public JTextField getMin2() {
        return min2;
    }

    public JTextField getMin3() {
        return min3;
    }

    public JTextField getYear() {
        return year;
    }

    public JTextField getMonth() {
        return month;
    }

    public JTextField getDay() {
        return day;
    }
}
