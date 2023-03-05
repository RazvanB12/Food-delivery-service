package PresentationLayer.Views;

import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import DataLayer.Serializator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ClientView extends JFrame {
    private DefaultTableModel menuTableModel;
    private JTable menuTable;
    private JLabel menuLabel, orderLabel, totalLabel, type, rating, calories, protein, fat, sodium, price;
    private JScrollPane menuScroll;
    private JTextArea orderText, totalText;
    private JButton addButton, orderButton, filter;
    private JTextField minRating, maxRating, minCalories, maxCalories, minProtein, maxProtein, minFat, maxFat, minSodium, maxSodium, minPrice, maxPrice;;
    private JComboBox typeBox;
    private List<MenuItem> items;
    private String clientId;

    public ClientView(String clientId){
        this.clientId = clientId;
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("CLIENT");

        menuLabel = new JLabel("MENU");
        menuLabel.setBounds(550,10, 300, 50);
        menuLabel.setFont(new Font("Calibri", Font.BOLD, 20));

        addButton = new JButton("ADD TO CART");
        addButton.setBounds(525,370, 120, 30);
        addButton.setFont(new Font("Calibri", Font.BOLD, 15));

        String[] menuColumns = {"NAME", "RATING", "CALORIES", "PROTEIN", "FAT", "SODIUM", "PRICE", "TYPE"};
        Serializator serializator = new Serializator();
        items = (ArrayList<MenuItem>) serializator.deserializeMenuItem();
        int i = 100;
        int j = 8;
        String[][] menuRows = new String[i][j];
        for (MenuItem item : items){
            int k = items.indexOf(item);
            menuRows[k][0] = item.getTitle();
            menuRows[k][1] = String.valueOf(item.getRating());
            menuRows[k][2] = String.valueOf(item.getCalories());
            menuRows[k][3] = String.valueOf(item.getProtein());
            menuRows[k][4] = String.valueOf(item.getFat());
            menuRows[k][5] = String.valueOf(item.getSodium());
            menuRows[k][6] = String.valueOf(item.getPrice());
            menuRows[k][7] = String.valueOf(item.getType());
        }

        menuTableModel = new DefaultTableModel(menuRows, menuColumns);
        menuTable = new JTable(menuTableModel);
        menuTable.getColumnModel().getColumn(0).setPreferredWidth(600);
        menuScroll = new JScrollPane(menuTable);
        menuScroll.setBounds(50, 50, 1043, 300);

        typeBox = new JComboBox(BusinessLayer.Type.values());
        typeBox.setBounds(1280,100, 120, 30);
        typeBox.setFont(new Font("Calibri", Font.BOLD, 20));

        type = new JLabel("TYPE");
        type.setBounds(1210, 100, 100, 30);
        type.setFont(new Font("Calibri", Font.BOLD, 20));

        rating = new JLabel("RATING");
        rating.setBounds(1190, 150, 100, 30);
        rating.setFont(new Font("Calibri", Font.BOLD, 20));

        minRating = new JTextField();
        minRating.setBounds(1280, 150, 55, 30);
        minRating.setFont(new Font("Calibri", Font.BOLD, 20));
        minRating.setText("0");

        maxRating = new JTextField();
        maxRating.setBounds(1345, 150, 55, 30);
        maxRating.setFont(new Font("Calibri", Font.BOLD, 20));
        maxRating.setText("10");

        calories = new JLabel("CALORIES");
        calories.setBounds(1170, 200, 100, 30);
        calories.setFont(new Font("Calibri", Font.BOLD, 20));

        minCalories = new JTextField();
        minCalories.setBounds(1280, 200, 55, 30);
        minCalories.setFont(new Font("Calibri", Font.BOLD, 20));
        minCalories.setText("0");

        maxCalories = new JTextField();
        maxCalories.setBounds(1345, 200, 55, 30);
        maxCalories.setFont(new Font("Calibri", Font.BOLD, 20));
        maxCalories.setText("1000");

        protein = new JLabel("PROTEIN");
        protein.setBounds(1180, 250, 100, 30);
        protein.setFont(new Font("Calibri", Font.BOLD, 20));

        minProtein = new JTextField();
        minProtein.setBounds(1280, 250, 55, 30);
        minProtein.setFont(new Font("Calibri", Font.BOLD, 20));
        minProtein.setText("0");

        maxProtein = new JTextField();
        maxProtein.setBounds(1345, 250, 55, 30);
        maxProtein.setFont(new Font("Calibri", Font.BOLD, 20));
        maxProtein.setText("1000");

        fat = new JLabel("FAT");
        fat.setBounds(1220, 300, 100, 30);
        fat.setFont(new Font("Calibri", Font.BOLD, 20));

        minFat = new JTextField();
        minFat.setBounds(1280, 300, 55, 30);
        minFat.setFont(new Font("Calibri", Font.BOLD, 20));
        minFat.setText("0");

        maxFat = new JTextField();
        maxFat.setBounds(1345, 300, 55, 30);
        maxFat.setFont(new Font("Calibri", Font.BOLD, 20));
        maxFat.setText("1000");

        sodium = new JLabel("SODIUM");
        sodium.setBounds(1180, 350, 100, 30);
        sodium.setFont(new Font("Calibri", Font.BOLD, 20));

        minSodium = new JTextField();
        minSodium.setBounds(1280, 350, 55, 30);
        minSodium.setFont(new Font("Calibri", Font.BOLD, 20));
        minSodium.setText("0");

        maxSodium = new JTextField();
        maxSodium.setBounds(1345, 350, 55, 30);
        maxSodium.setFont(new Font("Calibri", Font.BOLD, 20));
        maxSodium.setText("1000");

        price = new JLabel("PRICE");
        price.setBounds(1200, 400, 100, 30);
        price.setFont(new Font("Calibri", Font.BOLD, 20));

        minPrice = new JTextField();
        minPrice.setBounds(1280, 400, 55, 30);
        minPrice.setFont(new Font("Calibri", Font.BOLD, 20));
        minPrice.setText("0");

        maxPrice = new JTextField();
        maxPrice.setBounds(1345, 400, 55, 30);
        maxPrice.setFont(new Font("Calibri", Font.BOLD, 20));
        maxPrice.setText("1000");

        filter = new JButton("FILTER");
        filter.setBounds(1290,450, 100, 30);
        filter.setFont(new Font("Calibri", Font.BOLD, 20));

        orderLabel = new JLabel("YOUR CART");
        orderLabel.setBounds(535,450, 300, 50);
        orderLabel.setFont(new Font("Calibri", Font.BOLD, 20));

        orderText = new JTextArea();
        orderText.setEditable(false);
        orderText.setBackground(Color.WHITE);
        orderText.setBounds(225,510, 700, 200);
        orderText.setFont(new Font("Calibri", Font.BOLD, 15));

        totalLabel = new JLabel("TOTAL");
        totalLabel.setBounds(1050,550, 300, 50);
        totalLabel.setFont(new Font("Calibri", Font.BOLD, 20));

        totalText = new JTextArea("0");
        totalText.setEditable(false);
        totalText.setBackground(Color.WHITE);
        totalText.setBounds(1130,555, 80, 30);
        totalText.setFont(new Font("Calibri", Font.BOLD, 20));

        orderButton = new JButton("PLACE ORDER");
        orderButton.setBounds(1060, 600, 140, 30);
        orderButton.setFont(new Font("Calibri", Font.BOLD, 15));

        panel.add(menuLabel);
        panel.add(menuScroll);
        panel.add(addButton);
        panel.add(typeBox);
        panel.add(type);
        panel.add(rating);
        panel.add(minRating);
        panel.add(maxRating);
        panel.add(calories);
        panel.add(minCalories);
        panel.add(maxCalories);
        panel.add(protein);
        panel.add(minProtein);
        panel.add(maxProtein);
        panel.add(fat);
        panel.add(minFat);
        panel.add(maxFat);
        panel.add(sodium);
        panel.add(minSodium);
        panel.add(maxSodium);
        panel.add(price);
        panel.add(minPrice);
        panel.add(maxPrice);
        panel.add(filter);
        panel.add(orderLabel);
        panel.add(orderText);
        panel.add(totalLabel);
        panel.add(totalText);
        panel.add(orderButton);
        this.add(panel);
    }

    public void addFilterButtonListener (ActionListener listener){filter.addActionListener(listener);}

    public void addAddButtonListener (ActionListener listener){addButton.addActionListener(listener);}

    public void addOrderButtonListener (ActionListener listener){orderButton.addActionListener(listener);}

    public JTable getMenuTable() {
        return menuTable;
    }

    public JTextArea getOrderText() {
        return orderText;
    }

    public void setOrderText(JTextArea orderText) {
        this.orderText = orderText;
    }

    public JTextArea getTotalText() {
        return totalText;
    }


    public JTextField getMinRating() {
        return minRating;
    }

    public JTextField getMaxRating() {
        return maxRating;
    }

    public JTextField getMinCalories() {
        return minCalories;
    }

    public JTextField getMaxCalories() {
        return maxCalories;
    }

    public JTextField getMinProtein() {
        return minProtein;
    }

    public JTextField getMaxProtein() {
        return maxProtein;
    }

    public JTextField getMinFat() {
        return minFat;
    }

    public JTextField getMaxFat() {
        return maxFat;
    }

    public JTextField getMinSodium() {
        return minSodium;
    }

    public JTextField getMaxSodium() {
        return maxSodium;
    }

    public JTextField getMinPrice() {
        return minPrice;
    }

    public JTextField getMaxPrice() {
        return maxPrice;
    }

    public JComboBox getTypeBox() {
        return typeBox;
    }

    public DefaultTableModel getMenuTableModel() {
        return menuTableModel;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public String getClientId() {
        return clientId;
    }
}
