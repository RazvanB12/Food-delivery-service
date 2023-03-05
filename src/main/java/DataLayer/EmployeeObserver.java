package DataLayer;

import PresentationLayer.MessageBoxes.OrderCreated;

public class EmployeeObserver extends Observer{
    public EmployeeObserver (){
        System.out.println("Observer created");
    }

    @Override
    public void update(int id) {
        OrderCreated orderCreated = new OrderCreated(id);
        orderCreated.setVisible(true);
    }
}
