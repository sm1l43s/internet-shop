package by.brausov.shop;

import java.util.ArrayList;
import java.util.List;

public class Category {

    /**
     * the name of the category
     */
    private final String name;

    /**
     * list of product for this category
     */
    private List<Product> products;

    /**
     * Create a new category product
     * @param name the category name
     */
    public Category(String name) {
        this.name = name;
        products = new ArrayList<>();
    }

    /**
     * Add a product to a category
     * @param product the product to add
     */
    public void addProduct(Product product) {
        this.products.add(product);
    }

    /**
     * Get list products for this category
     * @return the list products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Get name category
     * @return the name category
     */
    public String getName() {
        return name;
    }
}
