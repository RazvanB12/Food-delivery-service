package DataLayer;

import BusinessLayer.Order;

public abstract class Observer {
    protected Order order;
    public abstract void update(int id);
}
