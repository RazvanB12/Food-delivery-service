package App;

import DataLayer.Roles;
import DataLayer.Serializator;
import DataLayer.User;

import java.util.ArrayList;
import java.util.List;

public class CheckCredentials {
    public static void main(String[] args){
        Serializator serializator = new Serializator();
        List <User> clients = serializator.deserializeClient();
        for (User client : clients){
            System.out.println(client.getRole() + " " + client.getUsername() + " " + client.getPassword());
        }

        List <User> admins = serializator.deserializeAdmin();
        for (User admin : admins){
            System.out.println(admin.getRole() + " " + admin.getUsername() + " " + admin.getPassword());
        }


        List <User> employees = serializator.deserializeEmployee();
        for (User employee : employees){
            System.out.println(employee.getRole() + " " + employee.getUsername() + " " + employee.getPassword());
        }
    }
}
