package PresentationLayer.Controllers;

import DataLayer.Roles;
import DataLayer.Serializator;
import DataLayer.User;
import PresentationLayer.MessageBoxes.InvalidCredentials;
import PresentationLayer.MessageBoxes.RegisterCompleted;
import PresentationLayer.Views.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegisterController {
    private RegisterView registerView;

    public RegisterController (RegisterView regsiterView){
        this.registerView = regsiterView;
        registerView.setVisible(true);
        registerView.addCreateListener(new createListener());
    }

    class createListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = registerView.getUsername().getText();
            String password = registerView.getPassword().getText();

            User client = new User(Roles.CLIENT, username, password);
            Serializator serializator = new Serializator();
            ArrayList<User> clients = (ArrayList<User>) serializator.deserializeClient();

            boolean valid = true;

            for (User c : clients){
                if (c.getUsername().equals(username)){
                    InvalidCredentials invalidCredentials = new InvalidCredentials();
                    invalidCredentials.setVisible(true);
                    valid =  false;
                }
            }
            if (valid == true){
                RegisterCompleted registerCompleted = new RegisterCompleted();
                registerCompleted.setVisible(true);
                clients.add(client);
                serializator.serializeClient(clients);
            }
        }
    }
}
