package PresentationLayer.Views;

import BusinessLayer.MenuItem;
import BusinessLayer.Type;
import DataLayer.Serializator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminView extends JFrame {
    private JButton search, add, delete, update, insert, create, selectSoup, selectSteak, selectGarnish, selectDessert, reports;
    private JButton createNew;
    private JTextField soup, steak, garnish, dessert, searchField;
    private JTextField newName, newRating, newCalories, newProtein, newFat, newSodium, newPrice;
    private DefaultTableModel menuTableModel, resultTableModel;
    private JTable menuTable, resultTable;
    private JScrollPane menuScroll, resultScroll;
    private JComboBox comboBox;
    private int index, soupIndex, steakIndex, garnishIndex, dessertIndex;

    public AdminView(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("ADMIN");

        String[] menuColumns = {"NAME", "RATING", "CALORIES", "PROTEIN", "FAT", "SODIUM", "PRICE", "TYPE"};
        Serializator serializator = new Serializator();
        ArrayList<MenuItem> items = (ArrayList<MenuItem>) serializator.deserializeMenuItem();
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
        menuScroll.setBounds(20, 20, 800, 300);

        String[][] resultRows = new String[i][j];
        String[] resultColumns = {"NAME", "RATING", "CALORIES", "PROTEIN", "FAT", "SODIUM", "PRICE"};
        resultTableModel = new DefaultTableModel(resultRows, resultColumns);
        resultTable = new JTable(resultTableModel);
        resultTable.getColumnModel().getColumn(0).setPreferredWidth(600);
        resultScroll = new JScrollPane(resultTable);
        resultScroll.setBounds(20, 450, 800, 300);

        comboBox = new JComboBox();
        comboBox.addItem(BusinessLayer.Type.SOUP);
        comboBox.addItem(BusinessLayer.Type.STEAK);
        comboBox.addItem(BusinessLayer.Type.GARNISH);
        comboBox.addItem(BusinessLayer.Type.DESSERT);
        comboBox.setBounds(430 ,340, 100, 30);
        comboBox.setFont(new Font("Calibri", Font.BOLD, 15));

        add = new JButton("ADD AS");
        add.setBounds(310, 340, 100, 30);
        add.setFont(new Font("Calibri", Font.BOLD, 15));

        delete = new JButton("DELETE");
        delete.setBounds(250, 390, 100, 30);
        delete.setFont(new Font("Calibri", Font.BOLD, 15));

        search = new JButton("SEARCH");
        search.setBounds(370, 390, 100, 30);
        search.setFont(new Font("Calibri", Font.BOLD, 15));

        searchField = new JTextField();
        searchField.setBounds(490, 390, 100, 30);
        searchField.setFont(new Font("Calibri", Font.BOLD, 15));

        selectSoup = new JButton("SELECT SOUP");
        selectSoup.setBounds(1000, 50, 150, 30);
        selectSoup.setFont(new Font("Calibri", Font.BOLD, 15));

        selectSteak = new JButton("SELECT STEAK");
        selectSteak.setBounds(1000, 100, 150, 30);
        selectSteak.setFont(new Font("Calibri", Font.BOLD, 15));

        selectGarnish = new JButton("SELECT GARNISH");
        selectGarnish.setBounds(1000, 150, 150, 30);
        selectGarnish.setFont(new Font("Calibri", Font.BOLD, 15));

        selectDessert = new JButton("SELECT DESSERT");
        selectDessert.setBounds(1000, 200, 150, 30);
        selectDessert.setFont(new Font("Calibri", Font.BOLD, 15));

        soup = new JTextField();
        soup.setEditable(false);
        soup.setBackground(Color.WHITE);
        soup.setBounds(1170, 50, 250, 30);
        soup.setFont(new Font("Calibri", Font.BOLD, 15));

        steak = new JTextField();
        steak.setEditable(false);
        steak.setBackground(Color.WHITE);
        steak.setBounds(1170, 100, 250, 30);
        steak.setFont(new Font("Calibri", Font.BOLD, 15));

        garnish = new JTextField();
        garnish.setEditable(false);
        garnish.setBackground(Color.WHITE);
        garnish.setBounds(1170, 150, 250, 30);
        garnish.setFont(new Font("Calibri", Font.BOLD, 15));

        dessert = new JTextField();
        dessert.setEditable(false);
        dessert.setBackground(Color.WHITE);
        dessert.setBounds(1170, 200, 250, 30);
        dessert.setFont(new Font("Calibri", Font.BOLD, 15));

        create = new JButton("CREATE NEW DAILY MENU");
        create.setBounds(1085, 250, 250, 30);
        create.setFont(new Font("Calibri", Font.BOLD, 15));

        reports = new JButton("REPORTS");
        reports.setBounds(1160, 700, 100, 30);
        reports.setFont(new Font("Calibri", Font.BOLD, 15));

        insert = new JButton("INSERT");
        insert.setBounds(1035, 650, 100, 30);
        insert.setFont(new Font("Calibri", Font.BOLD, 15));

        update = new JButton("UPDATE");
        update.setBounds(1160, 650, 100, 30);
        update.setFont(new Font("Calibri", Font.BOLD, 15));

        createNew = new JButton("CREATE");
        createNew.setBounds(1285, 650, 100, 30);
        createNew.setFont(new Font("Calibri", Font.BOLD, 15));

        newName = new JTextField();
        newName.setBounds(1085, 300, 250, 30);
        newName.setFont(new Font("Calibri", Font.BOLD, 15));

        newRating = new JTextField();
        newRating.setBounds(1085, 350, 250, 30);
        newRating.setFont(new Font("Calibri", Font.BOLD, 15));

        newCalories = new JTextField();
        newCalories.setBounds(1085, 400, 250, 30);
        newCalories.setFont(new Font("Calibri", Font.BOLD, 15));

        newProtein = new JTextField();
        newProtein.setBounds(1085, 450, 250, 30);
        newProtein.setFont(new Font("Calibri", Font.BOLD, 15));

        newFat = new JTextField();
        newFat.setBounds(1085, 500, 250, 30);
        newFat.setFont(new Font("Calibri", Font.BOLD, 15));

        newSodium = new JTextField();
        newSodium.setBounds(1085, 550, 250, 30);
        newSodium.setFont(new Font("Calibri", Font.BOLD, 15));

        newPrice = new JTextField();
        newPrice.setBounds(1085, 600, 250, 30);
        newPrice.setFont(new Font("Calibri", Font.BOLD, 15));

        panel.add(createNew);
        panel.add(menuScroll);
        panel.add(resultScroll);
        panel.add(add);
        panel.add(delete);
        panel.add(search);
        panel.add(searchField);
        panel.add(selectSoup);
        panel.add(selectSteak);
        panel.add(selectGarnish);
        panel.add(selectDessert);
        panel.add(soup);
        panel.add(steak);
        panel.add(garnish);
        panel.add(dessert);
        panel.add(create);
        panel.add(reports);
        panel.add(insert);
        panel.add(update);
        panel.add(newName);
        panel.add(newRating);
        panel.add(newCalories);
        panel.add(newProtein);
        panel.add(newFat);
        panel.add(newSodium);
        panel.add(newPrice);
        panel.add(comboBox);
        this.add(panel);
    }

    public void addCreateButtonListener (ActionListener listener){createNew.addActionListener(listener);}

    public void addSearchButtonListener (ActionListener listener){search.addActionListener(listener);}

    public void addAddButtonListener (ActionListener listener){add.addActionListener(listener);}

    public void addDeleteButtonListener (ActionListener listener){delete.addActionListener(listener);}

    public void addUpdateButtonListener (ActionListener listener){update.addActionListener(listener);}

    public void addInsertButtonListener (ActionListener listener){insert.addActionListener(listener);}

    public void addReportsButtonListener (ActionListener listener){reports.addActionListener(listener);}

    public void addSoupButtonListener (ActionListener listener){selectSoup.addActionListener(listener);}

    public void addSteakButtonListener (ActionListener listener){selectSteak.addActionListener(listener);}

    public void addGarnishButtonListener (ActionListener listener){selectGarnish.addActionListener(listener);}

    public void addDessertButtonListener (ActionListener listener){selectDessert.addActionListener(listener);}

    public void addCreateCompositeButtonListener (ActionListener listener){create.addActionListener(listener);}

    public JTextField getSearchField() {
        return searchField;
    }

    public DefaultTableModel getResultTableModel() {
        return resultTableModel;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public JTable getMenuTable() {
        return menuTable;
    }

    public JTable getResultTable() {
        return resultTable;
    }

    public DefaultTableModel getMenuTableModel() {
        return menuTableModel;
    }

    public JTextField getNewName() {
        return newName;
    }

    public JTextField getNewRating() {
        return newRating;
    }

    public JTextField getNewCalories() {
        return newCalories;
    }

    public JTextField getNewProtein() {
        return newProtein;
    }

    public JTextField getNewFat() {
        return newFat;
    }

    public JTextField getNewSodium() {
        return newSodium;
    }

    public JTextField getNewPrice() {
        return newPrice;
    }

    public int getIndex() {
        return index;
    }

    public int getSoupIndex() {
        return soupIndex;
    }

    public int getSteakIndex() {
        return steakIndex;
    }

    public int getGarnishIndex() {
        return garnishIndex;
    }

    public int getDessertIndex() {
        return dessertIndex;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setSoupIndex(int soupIndex) {
        this.soupIndex = soupIndex;
    }

    public void setSteakIndex(int steakIndex) {
        this.steakIndex = steakIndex;
    }

    public void setGarnishIndex(int garnishIndex) {
        this.garnishIndex = garnishIndex;
    }

    public void setDessertIndex(int dessertIndex) {
        this.dessertIndex = dessertIndex;
    }

    public JTextField getSoup() {
        return soup;
    }

    public JTextField getSteak() {
        return steak;
    }

    public JTextField getGarnish() {
        return garnish;
    }

    public JTextField getDessert() {
        return dessert;
    }
}