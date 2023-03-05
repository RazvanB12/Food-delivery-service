package PresentationLayer.Controllers;

import DataLayer.Serializator;
import DataLayer.User;
import PresentationLayer.MessageBoxes.WrongCredentials;
import PresentationLayer.Views.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginController {
    private LoginView loginView;

    public LoginController(LoginView loginView){
        this.loginView = loginView;
        loginView.setVisible(true);

        loginView.addLoginListener(new loginListener());
        loginView.addRegisterListener(new registerListener());
    }

    class loginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selection = loginView.getComboBox().getSelectedItem().toString();
            String username = loginView.getUsername().getText();
            String password = loginView.getPassword().getText();

            boolean logged = false;

            if (selection == "ADMIN"){
                Serializator serializator = new Serializator();
                ArrayList <User> admins = (ArrayList<User>) serializator.deserializeAdmin();

                for (User admin : admins){
                    if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())){
                        AdminView adminView = new AdminView();
                        AdminController adminController = new AdminController(adminView);
                        //loginView.dispose();
                        logged = true;
                    }
                }
            }

            else if (selection == "CLIENT"){
                Serializator serializator = new Serializator();
                ArrayList <User> clients = (ArrayList<User>) serializator.deserializeClient();

                for (User client : clients){
                    if (username.equals(client.getUsername()) && password.equals(client.getPassword())){
                        String name = client.getUsername();
                        ClientView clientView = new ClientView(name);
                        ClientController clientController = new ClientController(clientView);
                        //loginView.dispose();
                        logged = true;
                    }
                }
            }

            else if (selection == "EMPLOYEE"){
                Serializator serializator = new Serializator();
                ArrayList <User> employees = (ArrayList<User>) serializator.deserializeEmployee();

                for (User employee : employees) {
                    if (username.equals(employee.getUsername()) && password.equals(employee.getPassword())) {
                        EmployeeView employeeView = new EmployeeView();
                        EmployeeController employeeController = new EmployeeController(employeeView);
                        //loginView.dispose();
                        logged = true;
                    }
                }
            }

            if (logged == false){
                WrongCredentials wrongCredentials = new WrongCredentials();
                wrongCredentials.setVisible(true);
            }
        }
    }

    class registerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            RegisterView registerView = new RegisterView();
            RegisterController registerController = new RegisterController(registerView);
        }
    }
}
