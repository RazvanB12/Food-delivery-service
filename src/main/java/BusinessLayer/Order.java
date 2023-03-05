package BusinessLayer;

import DataLayer.EmployeeObserver;
import DataLayer.Observer;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order implements Serializable {
    private int orderID;
    private String clientID;
    private LocalDateTime date;
    private boolean delivered;

    public Order (int orderID, String clientID, LocalDateTime date){
        this.orderID = orderID;
        this.clientID = clientID;
        this.date = date;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderID == order.orderID && Objects.equals(clientID, order.clientID) && Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, clientID, date);
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered, Observer observer) {
        this.delivered = delivered;
        notifyObserver(orderID, observer);
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public void notifyObserver(int id, Observer observer){
        observer.update(id);
    }
}
