package by.brausov.shop;

public class Category {

    /**
     * the name of the category
     */
    private final String name;

    /**
     * list of product for this category
     */
    private Product[] products;

    /**
     * Create a new category product
     * @param name the category name
     */
    public Category(String name) {
        this.name = name;
    }
}
