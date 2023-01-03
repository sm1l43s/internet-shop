package by.brausov.shop;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {

    /**
     * The login of the user
     */
    private final String login;

    /**
     * The MD5 hash of user password
     */
    private final byte[] password;

    /**
     * The basket for this user
     */
    private final Basket basket;

    /**
     * Create a new user
     * @param login the user's login
     * @param password the user's password
     */
    public User(String login, String password) {
        this.login = login;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.password = md.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        this.basket = new Basket();
    }

    /**
     * Check whether a given password matches the true User password
     * @param password the password to check
     * @return whether the password valid or not
     */
    public boolean validatePassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(password.getBytes()), this.password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Check whether a given login matches the true User login
     * @param login the login to check
     * @return whether the login valid or not
     */
    public boolean validateLogin(String login) {
        return this.login.equals(login);
    }

    /**
     * Get a basket for this user
     * @return the user's basket
     */
    public Basket getBasket() {
        return basket;
    }

    /**
     * Get a login for this user
     * @return the user's login
     */
    public String getLogin() {
        return login;
    }
}