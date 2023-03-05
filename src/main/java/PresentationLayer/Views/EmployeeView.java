package PresentationLayer.Views;

import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import DataLayer.Serializator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class EmployeeView extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private JScrollPane scroll;
    private HashMap<Order, List<MenuItem>> orders;
    private JButton refresh, confirm;

    public EmployeeView(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("EMPLOYEE");

        String[] columns = {"ORDER","CLIENT", "PRODUCTS", "TOTAL"};
        Serializator serializator = new Serializator();
        orders = serializator.deserializeOrders();
        int i = 100;
        int j = 4;
        var ref = new Object() {
            int k = 0;
        };
        String[][] rows = new String[i][j];
        orders.forEach((key, value) ->{
            if (!key.isDelivered()){
                String idOrder = String.valueOf(key.getOrderID());
                String idClient = key.getClientID();
                String products = "";
                int total = 0;
                for (MenuItem item : value){
                    products = products + item.getTitle() + " + ";
                    total = total + item.getPrice();
                }
                products = products.substring(0, products.length()-2);
                rows[ref.k][0] = idOrder;
                rows[ref.k][1] = idClient;
                rows[ref.k][2] = products;
                rows[ref.k][3] = String.valueOf(total);
                ref.k++;
            }
        });
        tableModel = new DefaultTableModel(rows, columns);
        table = new JTable(tableModel);
        table.getColumnModel().getColumn(2).setPreferredWidth(1050);
        scroll = new JScrollPane(table);
        scroll.setBounds(100, 100, 1100, 600);

        confirm = new JButton("FINISH ORDER");
        confirm.setBounds(1270, 200, 140, 30);
        confirm.setFont(new Font("Calibri", Font.BOLD, 15));

        refresh = new JButton("REFRESH");
        refresh.setBounds(1270, 500, 140, 30);
        refresh.setFont(new Font("Calibri", Font.BOLD, 15));

        panel.add(scroll);
        panel.add(confirm);
        panel.add(refresh);
        this.add(panel);
    }

    public void addRefreshButtonListener (ActionListener listener){refresh.addActionListener(listener);}

    public void addConfirmButtonListener (ActionListener listener){confirm.addActionListener(listener);}

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
