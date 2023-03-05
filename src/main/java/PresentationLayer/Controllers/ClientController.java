package PresentationLayer.Controllers;

import BusinessLayer.DeliveryService;
import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import DataLayer.FileWriterClass;
import DataLayer.Serializator;
import PresentationLayer.Views.ClientView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClientController {
    private ClientView clientView;
    private DeliveryService deliveryService;
    private List<MenuItem> cart = new ArrayList<>();
    private int total;

    public ClientController(ClientView clientView){
        this.deliveryService = new DeliveryService();
        this.clientView = clientView;
        this.total = 0;
        clientView.setVisible(true);

        clientView.addFilterButtonListener(new filterListener());
        clientView.addOrderButtonListener(new orderListener());
        clientView.addAddButtonListener(new addListener());
    }

    class filterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = clientView.getTypeBox().getSelectedIndex();
            String s1 = clientView.getMinRating().getText();
            String s2 = clientView.getMinCalories().getText();
            String s3 = clientView.getMinProtein().getText();
            String s4 = clientView.getMinFat().getText();
            String s5 = clientView.getMinSodium().getText();
            String s6 = clientView.getMinPrice().getText();

            String s7 = clientView.getMaxRating().getText();
            String s8 = clientView.getMaxCalories().getText();
            String s9 = clientView.getMaxProtein().getText();
            String s10 = clientView.getMaxFat().getText();
            String s11 = clientView.getMaxSodium().getText();
            String s12 = clientView.getMaxPrice().getText();

            List<MenuItem> items = new ArrayList<>();

            if (!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty() && !s4.isEmpty() && !s5.isEmpty() && !s6.isEmpty() &&
                    !s7.isEmpty() && !s8.isEmpty() && !s9.isEmpty() && !s10.isEmpty() && !s11.isEmpty() && !s12.isEmpty()){
                int minRating = Integer.parseInt(s1);
                int maxRating = Integer.parseInt(s7);
                int minCalories = Integer.parseInt(s2);
                int maxCalories = Integer.parseInt(s8);
                int minProtein = Integer.parseInt(s3);
                int maxProtein = Integer.parseInt(s9);
                int minFat = Integer.parseInt(s4);
                int maxFat = Integer.parseInt(s10);
                int minSodium = Integer.parseInt(s5);
                int maxSodium = Integer.parseInt(s11);
                int minPrice = Integer.parseInt(s6);
                int maxPrice = Integer.parseInt(s12);
                items = deliveryService.searchMenu(index, minRating, maxRating, minCalories, maxCalories,
                        minProtein, maxProtein, minFat, maxFat, minSodium, maxSodium, minPrice, maxPrice);
                clientView.setItems(items);
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
            DefaultTableModel model = clientView.getMenuTableModel();
            model.setDataVector(resultRows, resultColumns);
        }
    }

    class orderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = clientView.getOrderText().getText();
            String id = clientView.getClientId();
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            s = s + "CLIENT : " + id + " \nTOTAL : " + String.valueOf(total) + "\nDATE : " + dtf.format(now);;
            clientView.getOrderText().setText(s);
            Serializator serializator = new Serializator();
            HashMap<Order, List<MenuItem>> orders = serializator.deserializeOrders();
            int index = orders.size() + 1;
            Order order = deliveryService.createOrder(index, id, now);
            orders.put(order, cart);
            serializator.serializeOrders(orders);

            String name = "OrderNO" + String.valueOf(index) + ".txt";
            FileWriterClass fileWriter = new FileWriterClass();
            try {
                fileWriter.write(name,s);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    class addListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = clientView.getMenuTable().getSelectedRow();
            MenuItem item = clientView.getItems().get(i);
            cart.add(item);
            String s = clientView.getOrderText().getText();
            s = s + item.getTitle() + "  -  " + item.getPrice() + "\n";
            clientView.getOrderText().setText(s);
            total = total + item.getPrice();
            clientView.getTotalText().setText(String.valueOf(total));
        }
    }
}
