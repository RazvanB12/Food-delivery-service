package BusinessLayer;

import DataLayer.EmployeeObserver;
import DataLayer.Serializator;
import DataLayer.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeliveryService extends Observable implements Serializable, IDeliveryServiceProcessing{
    private List<MenuItem> menuItems;
    private HashMap<Order, List<MenuItem>> orders;
    private List<User> clients;
    private List<User> admins;
    private List<User> employees;

    public DeliveryService(){
        Serializator serializator = new Serializator();
        menuItems = serializator.deserializeMenuItem();
        clients = serializator.deserializeClient();
        admins = serializator.deserializeAdmin();
        employees = serializator.deserializeEmployee();
    }

    /**
     * Precondition : the string we want to find in the producs.csv must be not null
     * Postcondition : the list of products that contains the string in their name
     * @param s the string we want to find in product's name
     * @return list of products that contin string s
     */
    public List<BaseProduct> searchProducts(String s) throws FileNotFoundException {
        assert s != null : "String can't be null";

        Scanner sc = new Scanner(new File("products.csv"));
        sc.useDelimiter(",|\n");
        for (int i=0; i<7; i++){
            sc.next();
        }
        List<BaseProduct> items = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        while (sc.hasNext() && items.size()<100){
            String name = sc.next();
            Double rating = Double.parseDouble(sc.next());
            int calories = Integer.parseInt(sc.next());
            int protein = Integer.parseInt(sc.next());
            int fat = Integer.parseInt(sc.next());
            int sodium = Integer.parseInt(sc.next());
            int price = (int) Double.parseDouble(sc.next());
            if (!strings.contains(name) && name.toUpperCase().contains(s.toUpperCase())){
                BaseProduct product = new BaseProduct(name, rating, calories, protein, fat, sodium, price, null);
                items.add(product);
                strings.add(name);
            }
        }
        return items;
    }

    /**
     * Precondition : item we want to add can't be null
     * Postcondition : item is added to the menu
     * @param item item we want to delete
     */
    public void addMenuItem(MenuItem item){
        assert item != null : "Item can't be null";

        menuItems.add(item);
        Serializator serializator = new Serializator();
        serializator.serializeMenuItem(menuItems);
    }

    /**
     * Precondition : index of the item we want to delete must be >= 0
     * Postcondition : item is deleted from the menu
     * @param index index of the product we want to delete
     */
    public void deleteMenuItem(int index){
        assert index >= 0 : "Index must be positive";

        menuItems.remove(index);
        Serializator serializator = new Serializator();
        serializator.serializeMenuItem(menuItems);
    }

    /**
     * Preconditon : index,name,rating, calories, protein, fat, sodium, price >= 0
     * Postcondition : item is modified
     * @param index index of the item we want to modify
     * @param name new name
     * @param rating new rating
     * @param calories new calories
     * @param protein new protein
     * @param fat new fat
     * @param sodium new sodium
     * @param price new price
     */
    public void updateMenuItem(int index, String name, Double rating, int calories, int protein, int fat, int sodium, int price){
        assert index >= 0 : "Index must be positive";
        assert name != null : "Name can't be null";
        assert rating >= 0 : "Rating must be positive";
        assert calories >= 0 : "Calories must be positive";
        assert protein >= 0 : "Protein must be positive";
        assert fat >= 0 : "Fat must be positive";
        assert sodium >= 0 : "Sodium must be positive";
        assert price >= 0 : "Price must be positive";

        MenuItem menuItem = menuItems.get(index);
        menuItem.setTitle(name);
        menuItem.setRating(rating);
        menuItem.setCalories(calories);
        menuItem.setProtein(protein);
        menuItem.setFat(fat);
        menuItem.setSodium(sodium);
        menuItem.setPrice(price);
        Serializator serializator = new Serializator();
        serializator.serializeMenuItem(menuItems);
    }

    /**
     * Preconditon : all indexes must be positive
     * Postcondition : composite item is created
     * @param indexSoup index of the soup
     * @param indexSteak index of the steak
     * @param indexGarnish index of the garnish
     * @param indexDessert indesx of the dessert
     */
    public void createComposite(int indexSoup, int indexSteak, int indexGarnish, int indexDessert){
        assert indexSoup >= 0 : "Index must be positive";
        assert indexSteak >= 0 : "Index must be positive";
        assert indexGarnish >= 0 : "Index must be positive";
        assert indexDessert >= 0 : "Index must be positive";

        MenuItem soup = menuItems.get(indexSoup);
        MenuItem steak = menuItems.get(indexSteak);
        MenuItem garnish = menuItems.get(indexGarnish);
        MenuItem dessert = menuItems.get(indexDessert);
        CompositeProduct compositeProduct = new CompositeProduct(soup, steak, garnish, dessert);
        menuItems.add(compositeProduct);
        Serializator serializator = new Serializator();
        serializator.serializeMenuItem(menuItems);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setOrders(HashMap<Order, List<MenuItem>> orders) {
        this.orders = orders;
    }

    public HashMap<Order, List<MenuItem>> getOrders() {
        return orders;
    }

    /**
     * Precondition : all param are >= 0 and all mins <= maxs
     * Poscondition : list of filtered products
     * @param tip   type of products
     * @param minR  min rating
     * @param maxR  max rating
     * @param minC  min Calories
     * @param maxC  max Calories
     * @param minP  min Protein
     * @param maxP  max Protein
     * @param minF  min Fat
     * @param maxF  max Fat
     * @param minS  min Sodiu
     * @param maxS  max Sodium
     * @param minPr min Price
     * @param maxPr max Price
     * @return list of filtered products
     */
    public List<MenuItem> searchMenu(int tip, int minR, int maxR, int minC, int maxC, int minP, int maxP, int minF, int maxF,
                                     int minS, int maxS, int minPr, int maxPr) {
        assert tip>=0 && tip<=5 : "Only 5 tipes of products";
        assert minR>=0 && minR<=maxR : "Min must be >=0 and max must be >= min";
        assert minC>=0 && minC<=maxC : "Min must be >=0 and max must be >= min";
        assert minP>=0 && minP<=maxP : "Min must be >=0 and max must be >= min";
        assert minF>=0 && minF<=maxF : "Min must be >=0 and max must be >= min";
        assert minS>=0 && minS<=maxS : "Min must be >=0 and max must be >= min";
        assert minPr>=0 && minPr<=maxPr : "Min must be >=0 and max must be >= min";

        List<MenuItem> items = new ArrayList<>();
        menuItems.forEach(menuItem -> {
            if(menuItem.getType() == Type.values()[tip] &&
            menuItem.getRating()>=minR && menuItem.getRating()<=maxR &&
            menuItem.getCalories()>=minC && menuItem.getCalories()<=maxC &&
            menuItem.getProtein()>=minP && menuItem.getProtein()<=maxP &&
            menuItem.getFat()>=minF && menuItem.getFat()<=maxF &&
            menuItem.getPrice()>=minPr && menuItem.getPrice()<=maxPr
            ){
                items.add(menuItem);
            }
        });

        return items;
    }

    /**
     * Precondition : id >=0 , client != null, date != null
     * Postcondition : creates the order
     * @param id order id
     * @param client client that placed the order
     * @param date date of the order
     * @return order
     */
    public Order createOrder(int id, String client, LocalDateTime date){
        assert id >= 0 : "Order id must be pozitive";
        assert client != null : "Client can't be null";
        assert date != null : "Date can't be null";

        Order order = new Order(id, client, date);
        EmployeeObserver observer = new EmployeeObserver();
        order.setDelivered(false, observer);
        return order;
    }

    /**
     * Precondition : 0 <= start <= end <= 23
     * Postcondition : list of orders placed in the specified time interval
     * @param start start hour
     * @param end en hour
     * @return list of orders placed in the specified time interval
     */
    public  Map<Order, List<MenuItem>> report1 (int start, int end){
        assert 0 <= start && start <= end && end <= 23 : "Time interval must be valid";

        Serializator serializator = new Serializator();
        orders = serializator.deserializeOrders();

        Map<Order, List<MenuItem>> result = orders.entrySet().stream()
                .filter(orderListEntry -> {
                    int h = orderListEntry.getKey().getDate().getHour();
                    return h >= start && h <= end;
                }).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        return result;
    }

    /**
     * Precondition : min >= 0
     * Postcondition : list of items that had been ordered more than min times
     * @param min mini times that the item has been ordered
     * @return list of items that had been ordered more than min times
     */
    public Map<MenuItem, Long> report2 (int min){
        assert min >= 0 : "Min must be positive";

        Serializator serializator = new Serializator();
        orders = serializator.deserializeOrders();

        Map<MenuItem, Long> countered = counter(orders.values().stream().flatMap(List::stream));

        Map<MenuItem, Long> result = countered.entrySet().stream()
                .filter(orderListEntry -> {
                    Long v = orderListEntry.getValue();
                    return v >= min;
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return result;
    }

    /**
     * Precondition : number of times >=0 and value >= 0
     * Postcondition : list of clients that ordered more than specified times and the order's price was higher than the specified value
     * @param times min number of times that the client ordered
     * @param value min value of orders
     * @return list of clients that ordered more than specified times and the order's price was higher than the specified value
     */
    public Map<User, Long> report3 (int times, int value){
        assert times >= 0 : "Number of times must be positive";
        assert value >= 0 : "Value must be positive";

        Serializator serializator = new Serializator();
        orders = serializator.deserializeOrders();

        Map<Order, List<MenuItem>> orders1 = orders.entrySet().stream()
                .filter(orderListEntry -> {
                    List<MenuItem> items = orderListEntry.getValue();
                    var ref = new Object() {
                        int total = 0;
                    };
                    items.forEach(item -> {
                        ref.total = ref.total + item.getPrice();
                    });
                    int t = ref.total;

                    ref.total = 0;
                    return t >= value;
                }).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        Map<User, Long> result = new HashMap<>();

        clients.forEach(client -> {
            var ref = new Object() {
                int count = 0;
            };
            orders1.forEach((key, val) -> {
                if (key.getClientID().equals(client.getUsername())){
                    ref.count++;
                }
            });
            if(ref.count >= times){
                result.put(client, (long) ref.count);
            }
            ref.count = 0;
        });

        return result;
    }

    /**
     * Precondition : year >= 0, 1 <= month <= 12, 1 <= day <= 31
     * Postcondition : orderes from the specified date
     * @param year year of the order
     * @param month month of the order
     * @param day day of the order
     * @return orderes from the specified date
     */
    public Map<MenuItem, Long> report4 (int year, int month, int day){
        assert year >= 0 : "Year must be positive";
        assert month >= 1 && month <= 12 : "Month must be between 1 and 12";
        assert day >= 1 && day <= 31 : "Day must be between 1 and 31";

        Serializator serializator = new Serializator();
        orders = serializator.deserializeOrders();

        Map<Order, List<MenuItem>> toCount = orders.entrySet().stream()
                .filter(orderListEntry -> {
                    int y = orderListEntry.getKey().getDate().getYear();
                    int m = orderListEntry.getKey().getDate().getMonthValue();
                    int d = orderListEntry.getKey().getDate().getDayOfMonth();
                    return y == year && m == month && d == day;
                }).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        Map<MenuItem, Long> partial = counter(toCount.values().stream().flatMap(List::stream));

        Map<MenuItem, Long> result = partial.entrySet().stream()
                .filter(orderListEntry -> {
                    Long v = orderListEntry.getValue();
                    return v > 0;
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return result;
    }

    /**
     * Invariant - must always be true
     */
    public boolean isWellFormed(){
        if (menuItems.isEmpty() || orders.isEmpty() || clients.isEmpty() || admins.isEmpty() || employees.isEmpty()) return false;
        return true;
    }

    public Map<MenuItem, Long> counter (Stream<MenuItem> items){
        Map<MenuItem, Long> result = new HashMap<>();

        var ref = new Object() {
            int count = 0;
        };

        List<MenuItem> items1 = new ArrayList<>();
        items.forEach(item -> {
            items1.add(item);
        });

        menuItems.forEach(menuItem -> {
            items1.forEach(item ->{
                if (item.getTitle().equals(menuItem.getTitle())){
                    ref.count++;
                }
            });
            result.put(menuItem, (long) ref.count);
            ref.count = 0;
        });

        return result;
    }
}
