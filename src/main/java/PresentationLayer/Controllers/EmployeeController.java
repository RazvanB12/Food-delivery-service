package PresentationLayer.Controllers;

import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import DataLayer.Serializator;
import PresentationLayer.Views.EmployeeView;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

public class EmployeeController {
    private EmployeeView employeeView;

    public EmployeeController (EmployeeView employeeView){
        this.employeeView = employeeView;
        employeeView.setVisible(true);

        employeeView.addConfirmButtonListener(new confirmListener());
        employeeView.addRefreshButtonListener(new refreshListener());
    }

    class confirmListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int ind = employeeView.getTable().getSelectedRow();
            String s = (String) employeeView.getTable().getModel().getValueAt(ind, 0);
            int index = Integer.parseInt(s);
            Serializator serializator = new Serializator();
            HashMap<Order, List<MenuItem>> orders = serializator.deserializeOrders();

            orders.forEach((key, value) ->{
                if (key.getOrderID() == index){
                    key.setDelivered(true);
                }
            });

            serializator.serializeOrders(orders);
            int i = 100;
            int j = 4;
            var ref = new Object() {
                int k = 0;
            };
            String[] columns = {"ORDER","CLIENT", "PRODUCTS", "TOTAL"};
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
            DefaultTableModel model = employeeView.getTableModel();
            model.setDataVector(rows, columns);
        }
    }

    class refreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Serializator serializator = new Serializator();
            HashMap<Order, List<MenuItem>> orders = serializator.deserializeOrders();
            int i = 100;
            int j = 4;
            var ref = new Object() {
                int k = 0;
            };
            String[] columns = {"ORDER","CLIENT", "PRODUCTS", "TOTAL"};
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
            DefaultTableModel model = employeeView.getTableModel();
            model.setDataVector(rows, columns);
        }
    }
}
