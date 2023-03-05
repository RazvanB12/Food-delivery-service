package BusinessLayer;

public class CompositeProduct extends MenuItem{
    private MenuItem soup;
    private MenuItem steak;
    private MenuItem garnish;
    private MenuItem dessert;
    private Type type;

    public CompositeProduct(MenuItem soup, MenuItem steak, MenuItem garnish, MenuItem dessert) {
        this.soup = soup;
        this.steak = steak;
        this.garnish = garnish;
        this.dessert = dessert;
        this.type = Type.MENU;
    }

    @Override
    public String getTitle(){
        String title = "";
        title = title + soup.getTitle() + " + " + steak.getTitle() + " + " + garnish.getTitle() + " + " + dessert.getTitle();
        return title;
    }

    @Override
    public Double getRating() {
        Double rating = 0.0;
        rating = rating + soup.getRating() + steak.getRating() + garnish.getRating() + dessert.getRating();
        rating = rating / 4;
        return rating;
    }

    @Override
    public int getCalories() {
        int calories = 0;
        calories = calories + soup.getCalories() + steak.getCalories() + garnish.getCalories() + dessert.getCalories();
        return calories;
    }

    @Override
    public int getProtein() {
        int protein = 0;
        protein = protein + soup.getProtein() + steak.getProtein() + garnish.getProtein() + dessert.getProtein();
        return protein;
    }

    @Override
    public int getFat() {
        int fat = 0;
        fat = fat + soup.getFat() + steak.getFat() + garnish.getFat() + dessert.getFat();
        return fat;
    }

    @Override
    public int getSodium() {
        int sodium = 0;
        sodium = sodium + soup.getSodium() + steak.getSodium() + garnish.getSodium() + dessert.getSodium();
        return sodium;
    }

    @Override
    public int getPrice() {
        int price = 0;
        price = price + soup.getPrice() + steak.getPrice() + garnish.getPrice() + dessert.getPrice();
        return price;
    }

    @Override
    public Type getType() {
        return type;
    }
}
