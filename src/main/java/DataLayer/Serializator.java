package DataLayer;

import BusinessLayer.MenuItem;
import BusinessLayer.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Serializator {
    public static void serializeAdmin(List<User> admins){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("admins.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(admins);
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static List<User> deserializeAdmin(){
        try {
            FileInputStream fileInputStream = new FileInputStream("admins.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<User> admins = (ArrayList<User>) objectInputStream.readObject();
            return admins;
        } catch (IOException | ClassNotFoundException e){ e.printStackTrace(); }
        return null;
    }

    public static void serializeClient(List<User> clients){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("clients.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(clients);
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static List<User> deserializeClient(){
        try {
            FileInputStream fileInputStream = new FileInputStream("clients.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<User> clients = (ArrayList<User>) objectInputStream.readObject();
            return clients;
        } catch (IOException | ClassNotFoundException e){ e.printStackTrace(); }
        return null;
    }

    public static void serializeEmployee(List<User> employees){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("employees.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employees);
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static List<User> deserializeEmployee(){
        try {
            FileInputStream fileInputStream = new FileInputStream("employees.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<User> employees = (ArrayList<User>) objectInputStream.readObject();
            return employees;
        } catch (IOException | ClassNotFoundException e){ e.printStackTrace(); }
        return null;
    }

    public static void serializeMenuItem(List<MenuItem> items){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("menuitems.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(items);
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static List<MenuItem> deserializeMenuItem(){
        try {
            FileInputStream fileInputStream = new FileInputStream("menuitems.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<MenuItem> items = (ArrayList<MenuItem>) objectInputStream.readObject();
            return items;
        } catch (IOException | ClassNotFoundException e){ e.printStackTrace(); }
        return null;
    }

    public static void serializeOrders(HashMap<Order, List<MenuItem>> orders){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("orders.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(orders);
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static HashMap<Order, List<MenuItem>> deserializeOrders(){
        try {
            FileInputStream fileInputStream = new FileInputStream("orders.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            HashMap<Order, List<MenuItem>> orders = (HashMap<Order, List<MenuItem>>) objectInputStream.readObject();
            return orders;
        } catch (IOException | ClassNotFoundException e){ e.printStackTrace(); }
        return null;
    }
}
