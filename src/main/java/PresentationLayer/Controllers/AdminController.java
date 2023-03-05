package PresentationLayer.Controllers;

import BusinessLayer.BaseProduct;
import BusinessLayer.DeliveryService;
import BusinessLayer.MenuItem;
import BusinessLayer.Type;
import PresentationLayer.Views.AdminView;
import PresentationLayer.Views.ReportsView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;

public class AdminController {
    private AdminView adminView;
    private DeliveryService deliveryService;

    public AdminController(AdminView adminView){
        this.deliveryService = new DeliveryService();
        this.adminView = adminView;
        adminView.setVisible(true);
        adminView.addSearchButtonListener(new searchListener());
        adminView.addAddButtonListener(new addListener());
        adminView.addDeleteButtonListener(new deleteListener());
        adminView.addUpdateButtonListener(new updateListener());
        adminView.addInsertButtonListener(new insertListener());
        adminView.addReportsButtonListener(new reportsListener());
        adminView.addCreateCompositeButtonListener(new createListener());
        adminView.addSoupButtonListener(new soupListener());
        adminView.addSteakButtonListener(new steakListener());
        adminView.addGarnishButtonListener(new garnishListener());
        adminView.addDessertButtonListener(new dessertListener());
        adminView.addCreateButtonListener(new createNewListener());
    }

    class searchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = adminView.getSearchField().getText();
            List<BaseProduct> items = null;
            try {
                items = deliveryService.searchProducts(s);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            int i = 100;
            int j = 7;
            String[] resultColumns = {"NAME", "RATING", "CALORIES", "PROTEIN", "FAT", "SODIUM", "PRICE"};
            String[][] resultRows = new String[i][j];
            for (BaseProduct item : items){
                int k = items.indexOf(item);
                resultRows[k][0] = item.getTitle();
                resultRows[k][1] = String.valueOf(item.getRating());
                resultRows[k][2] = String.valueOf(item.getCalories());
                resultRows[k][3] = String.valueOf(item.getProtein());
                resultRows[k][4] = String.valueOf(item.getFat());
                resultRows[k][5] = String.valueOf(item.getSodium());
                resultRows[k][6] = String.valueOf(item.getPrice());
            }
            DefaultTableModel model = adminView.getResultTableModel();
            model.setDataVector(resultRows, resultColumns);
        }
    }

    class addListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int ind = adminView.getResultTable().getSelectedRow();
            String name = (String) adminView.getResultTable().getValueAt(ind, 0);
            String s1 = (String) adminView.getResultTable().getValueAt(ind, 1);
            String s2 = (String) adminView.getResultTable().getValueAt(ind, 2);
            String s3 = (String) adminView.getResultTable().getValueAt(ind, 3);
            String s4 = (String) adminView.getResultTable().getValueAt(ind, 4);
            String s5 = (String) adminView.getResultTable().getValueAt(ind, 5);
            String s6 = (String) adminView.getResultTable().getValueAt(ind, 6);

            Double rating = Double.parseDouble(s1);
            int calories = Integer.parseInt(s2);
            int protein = Integer.parseInt(s3);
            int fat = Integer.parseInt(s4);
            int sodium = Integer.parseInt(s5);
            int price = (int) Double.parseDouble(s6);
            int index = adminView.getComboBox().getSelectedIndex();
            Type tip = Type.values()[index];
            BaseProduct menuItem = new BaseProduct(name, rating, calories, protein, fat, sodium, price, tip);
            deliveryService.addMenuItem(menuItem);

            List<MenuItem> items = deliveryService.getMenuItems();
            int i = 100;
            int j = 8;
            String[] resultColumns = {"NAME", "RATING", "CALORIES", "PROTEIN", "FAT", "SODIUM", "PRICE", "TIP"};
            String[][] resultRows = new String[i][j];
            for (MenuItem item : items){
                int k = items.indexOf(item);
                resultRows[k][0] = item.getTitle();
                resultRows[k][1] = String.valueOf(item.getRating());
                resultRows[k][2] = String.valueOf(item.getCalories());
                resultRows[k][3] = String.valueOf(item.getProtein());
                resultRows[k][4] = String.valueOf(item.getFat());
                resultRows[k][5] = String.valueOf(item.getSodium());
                resultRows[k][6] = String.valueOf(item.getPrice());
                resultRows[k][7] = String.valueOf(item.getType());
            }
            DefaultTableModel model = adminView.getMenuTableModel();
            model.setDataVector(resultRows, resultColumns);
        }
    }

    class deleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = adminView.getMenuTable().getSelectedRow();
            deliveryService.deleteMenuItem(index);
            List<MenuItem> items = deliveryService.getMenuItems();
            int i = 100;
            int j = 8;
            String[] resultColumns = {"NAME", "RATING", "CALORIES", "PROTEIN", "FAT", "SODIUM", "PRICE", "TIP"};
            String[][] resultRows = new String[i][j];
            for (MenuItem item : items){
                int k = items.indexOf(item);
                resultRows[k][0] = item.getTitle();
                resultRows[k][1] = String.valueOf(item.getRating());
                resultRows[k][2] = String.valueOf(item.getCalories());
                resultRows[k][3] = String.valueOf(item.getProtein());
                resultRows[k][4] = String.valueOf(item.getFat());
                resultRows[k][5] = String.valueOf(item.getSodium());
                resultRows[k][6] = String.valueOf(item.getPrice());
                resultRows[k][7] = String.valueOf(item.getType());
            }
            DefaultTableModel model = adminView.getMenuTableModel();
            model.setDataVector(resultRows, resultColumns);
        }
    }

    class insertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = adminView.getMenuTable().getSelectedRow();
            JTextField name = adminView.getNewName();
            JTextField rating = adminView.getNewRating();
            JTextField calories = adminView.getNewCalories();
            JTextField proteins = adminView.getNewProtein();
            JTextField fat = adminView.getNewFat();
            JTextField sodium = adminView.getNewSodium();
            JTextField price = adminView.getNewPrice();
            name.setText((String) adminView.getMenuTable().getValueAt(index, 0));
            rating.setText((String) adminView.getMenuTable().getValueAt(index, 1));
            calories.setText((String) adminView.getMenuTable().getValueAt(index, 2));
            proteins.setText((String) adminView.getMenuTable().getValueAt(index, 3));
            fat.setText((String) adminView.getMenuTable().getValueAt(index, 4));
            sodium.setText((String) adminView.getMenuTable().getValueAt(index, 5));
            price.setText((String) adminView.getMenuTable().getValueAt(index, 6));
            adminView.setIndex(index);
        }
    }

    class updateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = adminView.getIndex();
            String name = adminView.getNewName().getText();
            String s1 = adminView.getNewRating().getText();
            String s2 = adminView.getNewCalories().getText();
            String s3 = adminView.getNewProtein().getText();
            String s4 = adminView.getNewFat().getText();
            String s5 = adminView.getNewSodium().getText();
            String s6 = adminView.getNewPrice().getText();
            if (!name.isEmpty() && !s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty() && !s4.isEmpty() && !s5.isEmpty() && !s6.isEmpty()){
                Double rating = Double.parseDouble(s1);
                int calories = Integer.parseInt(s2);
                int protein = Integer.parseInt(s3);
                int fat = Integer.parseInt(s4);
                int sodium = Integer.parseInt(s5);
                int price = (int) Double.parseDouble(s6);
                deliveryService.updateMenuItem(index, name, rating, calories, protein, fat, sodium, price);
            }
            List<MenuItem> items = deliveryService.getMenuItems();
            int i = 100;
            int j = 8;
            String[] resultColumns = {"NAME", "RATING", "CALORIES", "PROTEIN", "FAT", "SODIUM", "PRICE", "TIP"};
            String[][] resultRows = new String[i][j];
            for (MenuItem item : items){
                int k = items.indexOf(item);
                resultRows[k][0] = item.getTitle();
                resultRows[k][1] = String.valueOf(item.getRating());
                resultRows[k][2] = String.valueOf(item.getCalories());
                resultRows[k][3] = String.valueOf(item.getProtein());
                resultRows[k][4] = String.valueOf(item.getFat());
                resultRows[k][5] = String.valueOf(item.getSodium());
                resultRows[k][6] = String.valueOf(item.getPrice());
                resultRows[k][7] = String.valueOf(item.getType());
            }
            DefaultTableModel model = adminView.getMenuTableModel();
            model.setDataVector(resultRows, resultColumns);
        }
    }

    class soupListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = adminView.getMenuTable().getSelectedRow();
            String s = (String) adminView.getMenuTable().getValueAt(index, 7);
            if (s.equals("SOUP")) {
                adminView.setSoupIndex(index);
                adminView.getSoup().setText((String) adminView.getMenuTable().getValueAt(index, 0));
            }
        }
    }

    class steakListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = adminView.getMenuTable().getSelectedRow();
            String s = (String) adminView.getMenuTable().getValueAt(index, 7);
            if (s.equals("STEAK")) {
                adminView.setSteakIndex(index);
                adminView.getSteak().setText((String) adminView.getMenuTable().getValueAt(index, 0));
            }
        }
    }

    class garnishListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = adminView.getMenuTable().getSelectedRow();
            String s = (String) adminView.getMenuTable().getValueAt(index, 7);
            if (s.equals("GARNISH")) {
                adminView.setGarnishIndex(index);
                adminView.getGarnish().setText((String) adminView.getMenuTable().getValueAt(index, 0));
            }
        }
    }

    class dessertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = adminView.getMenuTable().getSelectedRow();
            String s = (String) adminView.getMenuTable().getValueAt(index, 7);
            if (s.equals("DESSERT")) {
                adminView.setDessertIndex(index);
                adminView.getDessert().setText((String) adminView.getMenuTable().getValueAt(index, 0));
            }
        }
    }

    class createListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String soup = adminView.getSoup().getText();
            String steak = adminView.getSteak().getText();
            String garnish = adminView.getGarnish().getText();
            String dessert = adminView.getDessert().getText();

            if (!soup.isEmpty() && !steak.isEmpty() && !garnish.isEmpty() && !dessert.isEmpty()){
                int indexSoup = adminView.getSoupIndex();
                int indexSteak = adminView.getSteakIndex();
                int indexGarnish = adminView.getGarnishIndex();
                int indexDessert = adminView.getDessertIndex();
                deliveryService.createComposite(indexSoup, indexSteak, indexGarnish, indexDessert);
            }
            List<MenuItem> items = deliveryService.getMenuItems();
            int i = 100;
            int j = 8;
            String[] resultColumns = {"NAME", "RATING", "CALORIES", "PROTEIN", "FAT", "SODIUM", "PRICE", "TIP"};
            String[][] resultRows = new String[i][j];
            for (MenuItem item : items){
                int k = items.indexOf(item);
                resultRows[k][0] = item.getTitle();
                resultRows[k][1] = String.valueOf(item.getRating());
                resultRows[k][2] = String.valueOf(item.getCalories());
                resultRows[k][3] = String.valueOf(item.getProtein());
                resultRows[k][4] = String.valueOf(item.getFat());
                resultRows[k][5] = String.valueOf(item.getSodium());
                resultRows[k][6] = String.valueOf(item.getPrice());
                resultRows[k][7] = String.valueOf(item.getType());
            }
            DefaultTableModel model = adminView.getMenuTableModel();
            model.setDataVector(resultRows, resultColumns);
        }
    }

    class reportsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ReportsView reportsView = new ReportsView();
            ReportsController reportsController = new ReportsController(reportsView);
            adminView.dispose();
        }
    }

    class createNewListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<MenuItem> items = deliveryService.getMenuItems();
            int index = adminView.getComboBox().getSelectedIndex();
            Type tip = Type.values()[index];
            String name = adminView.getNewName().getText();
            String s1 = adminView.getNewRating().getText();
            String s2 = adminView.getNewCalories().getText();
            String s3 = adminView.getNewProtein().getText();
            String s4 = adminView.getNewFat().getText();
            String s5 = adminView.getNewSodium().getText();
            String s6 = adminView.getNewPrice().getText();
            if (!name.isEmpty() && !s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty() && !s4.isEmpty() && !s5.isEmpty() && !s6.isEmpty()){
                Double rating = Double.parseDouble(s1);
                int calories = Integer.parseInt(s2);
                int protein = Integer.parseInt(s3);
                int fat = Integer.parseInt(s4);
                int sodium = Integer.parseInt(s5);
                int price = (int) Double.parseDouble(s6);
                BaseProduct product = new BaseProduct(name, rating, calories, protein, fat, sodium, price, tip);
                deliveryService.addMenuItem(product);
            }

            int i = 100;
            int j = 8;
            String[] resultColumns = {"NAME", "RATING", "CALORIES", "PROTEIN", "FAT", "SODIUM", "PRICE", "TIP"};
            String[][] resultRows = new String[i][j];
            for (MenuItem item : items){
                int k = items.indexOf(item);
                resultRows[k][0] = item.getTitle();
                resultRows[k][1] = String.valueOf(item.getRating());
                resultRows[k][2] = String.valueOf(item.getCalories());
                resultRows[k][3] = String.valueOf(item.getProtein());
                resultRows[k][4] = String.valueOf(item.getFat());
                resultRows[k][5] = String.valueOf(item.getSodium());
                resultRows[k][6] = String.valueOf(item.getPrice());
                resultRows[k][7] = String.valueOf(item.getType());
            }
            DefaultTableModel model = adminView.getMenuTableModel();
            model.setDataVector(resultRows, resultColumns);
        }
    }
}
