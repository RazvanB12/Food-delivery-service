package PresentationLayer.Controllers;

import BusinessLayer.DeliveryService;
import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import DataLayer.User;
import PresentationLayer.Views.ReportsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class ReportsController {
    private ReportsView reportsView;
    private DeliveryService deliveryService;

    public ReportsController(ReportsView reportsView) {
        this.reportsView = reportsView;
        reportsView.setVisible(true);
        deliveryService = new DeliveryService();

        reportsView.addButton1Listener(new button1Listener());
        reportsView.addButton2Listener(new button2Listener());
        reportsView.addButton3Listener(new button3Listener());
        reportsView.addButton4Listener(new button4Listener());
    }

    class button1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int start = Integer.parseInt(reportsView.getStart().getText());
            int end = Integer.parseInt(reportsView.getEnd().getText());
            Map<Order, List<MenuItem>> result = deliveryService.report1(start, end);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            var ref = new Object() {
                String text = "Orders performed in interval " + start + " - " + end + "\n\n";
            };

            result.forEach((order, menuItems) -> {
                ref.text = ref.text + "ORDER NO" + order.getOrderID() + " -- DATE " + dtf.format(order.getDate()) + "\n";
            });

            JTextArea area = reportsView.getTextArea();
            area.setText(ref.text);
        }
    }

    class button2Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int min  = Integer.parseInt(reportsView.getMin1().getText());
            Map<MenuItem, Long> result = deliveryService.report2(min);
            var ref = new Object() {
                String text = "Menu items ordered more than " + min +  " times\n\n";
            };
            result.forEach(((menuItem, counter) -> {
                ref.text = ref.text + menuItem.getTitle() + " -- " + counter + "\n";
            }));

            JTextArea area = reportsView.getTextArea();
            area.setText(ref.text);
        }
    }

    class button3Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int times  = Integer.parseInt(reportsView.getMin2().getText());
            int value  = Integer.parseInt(reportsView.getMin3().getText());
            Map<User, Long> result = deliveryService.report3(times, value);
            var ref = new Object() {
                String text = "Clients that have ordered more than " + times +" times and order's value was higher than " + value + "\n\n";
            };
            result.forEach(((user, counter) -> {
                ref.text = ref.text + user.getUsername() + " -- " + counter + "\n";
            }));

            JTextArea area = reportsView.getTextArea();
            area.setText(ref.text);
        }
    }

    class button4Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int year = Integer.parseInt(reportsView.getYear().getText());
            int month = Integer.parseInt(reportsView.getMonth().getText());
            int day = Integer.parseInt(reportsView.getDay().getText());
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            Map<MenuItem, Long> result = deliveryService.report4(year, month, day);
            var ref = new Object() {
                String text = "Menu items ordered in " + day + "/" + month + "/" + year +" and number of times they have been ordered\n\n";
            };
            result.forEach(((menuItem, counter) -> {
                ref.text = ref.text + menuItem.getTitle() + " -- " + counter + "\n";
            }));

            JTextArea area = reportsView.getTextArea();
            area.setText(ref.text);
        }
    }
}
