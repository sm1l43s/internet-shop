package by.brausov.shop;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    /**
     * list of products for this basket
     */
    private final List<Product> products;

    /**
     * Create a new empty basket
     */
    public Basket() {
        products = new ArrayList<>();
    }

    /**
     * Add a product to a products
     * @param product the product to add
     */
    public void addProduct(Product product) {
        this.products.add(product);
    }

    /**
     * Get a products for this basket
     * @return the basket's product
     */
    public List<Product> getProducts() {
        return products;
    }
}
