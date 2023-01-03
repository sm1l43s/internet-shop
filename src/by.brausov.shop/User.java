package by.brausov.shop;

public class User {

    /**
     * The login of the user
     */
    private final String login;

    /**
     * The MD5 hash of user pin
     */
    private final byte[] pin;

    /**
     * The basket for this user
     */
    private final Basket basket;

    /**
     * Create a new user
     * @param login the user's login
     * @param pin the user's pin
     * @param basket the user's basket
     */
    public User(String login, byte[] pin, Basket basket) {
        this.login = login;
        this.pin = pin;
        this.basket = basket;
    }
}