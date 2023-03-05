package BusinessLayer;

public class BaseProduct extends MenuItem{
    private Type type;

    public BaseProduct(String title, Double rating, int calories, int protein, int fat, int sodium, int price, Type type) {
        super(title, rating, calories, protein, fat, sodium, price);
        this.type = type;
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public Double getRating() {
        return super.getRating();
    }

    @Override
    public int getCalories() {
        return super.getCalories();
    }

    @Override
    public int getProtein() {
        return super.getProtein();
    }

    @Override
    public int getFat() {
        return super.getFat();
    }

    @Override
    public int getSodium() {
        return super.getSodium();
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public Type getType() {
        return type;
    }
}
