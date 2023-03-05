package BusinessLayer;

import DataLayer.User;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public interface IDeliveryServiceProcessing {
    List<BaseProduct> searchProducts(String s) throws FileNotFoundException;
    void addMenuItem(MenuItem menuItem);
    void deleteMenuItem(int index);
    void updateMenuItem(int index, String name, Double rating, int calories, int protein, int fat, int sodium, int price);
    void createComposite(int soup, int steak, int garnish, int dessert);
    List<MenuItem> searchMenu(int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13);
    List<MenuItem> getMenuItems();
    HashMap<Order, List<MenuItem>> getOrders();
    Order createOrder(int id, String client, LocalDateTime date);
    boolean isWellFormed();
    Map<Order, List<MenuItem>> report1 (int start, int end);
    Map<MenuItem, Long> report2 (int min);
    Map<User, Long> report3 (int times, int value);
    Map<MenuItem, Long> report4 (int year, int month, int day);
    Map<MenuItem, Long> counter (Stream<MenuItem> items);
}
