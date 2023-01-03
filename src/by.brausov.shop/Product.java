package by.brausov.shop;

public class Product {

    /**
     * the name of the product
     */
    private final String name;

    /**
     * the price of the product
     */
    private final double price;

    /**
     * the rating of the product
     */
    private final int rating;

    /**
     * Create a new product
     * @param name the product name
     * @param price the product price
     * @param rating the product rating
     */
    public Product(String name, double price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    /**
     * Get a name for this product
     * @return the product's name
     */
    public String getName() {
        return name;
    }

    /**
     * Get a price for this product
     * @return the product's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get a rating for this product
     * @return the product's rating
     */
    public int getRating() {
        return rating;
    }
}
