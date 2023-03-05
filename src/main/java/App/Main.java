package App;

import PresentationLayer.Controllers.LoginController;
import PresentationLayer.Views.LoginView;

public class Main {
    public static void main(String[] args){
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView);
    }
}
