package by.brausov.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InternetShop {

    static List<User> users = new ArrayList<>();
    static List<Category> categories = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        User user = new User("Brausov", "1234");
        users.add(user);
        categories.add(new Category("Женская одежда"));

        Product product = new Product("Джинсы", 100.0, 4);
        Product product1 = new Product("Очки", 10.0, 2);
        Product product2 = new Product("Сапоги", 120.0, 3);

        categories.get(0).addProduct(product);
        categories.get(0).addProduct(product1);
        categories.get(0).addProduct(product2);

        User curUser = InternetShop.auth(scanner);
        while (true) {
            InternetShop.printUserMenu(scanner, curUser);
        }
    }

    /**
     * Prints the application menu
     * @param scanner the scanner object for user input
     * @param user the logged-in user
     */
    private static void printUserMenu(Scanner scanner, User user) {
        int choice;
        do {
            System.out.printf("\nWelcome %s\n", user.getLogin());
            System.out.println("( 1) view categories");
            System.out.println("( 2) view products by categories");
            System.out.println("( 3) view basket") ;
            System.out.println("( 5) Quit");
            System.out.println("\nEnter choice: ");
            choice = scanner.nextInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice! Please choose 1-5");
            }
        } while (choice < 1 || choice > 5);

        switch (choice) {
            case 1: {
                InternetShop.viewCategories();
                break;
            }
            case 2: {
                InternetShop.viewProductsByCategory(scanner, user);
                break;
            }
            case 3: {
                InternetShop.viewBasket(scanner, user);
                break;
            }
        }
    }

    /**
     * Print the user's basket
     * @param scanner the scanner object for user input
     * @param user the logged-in user
     */
    private static void viewBasket(Scanner scanner, User user) {
        System.out.println("Name product | price product | rating product");
        for(Product p: user.getBasket().getProducts()) {
            System.out.printf("%3s | %3s | %3s\n", p.getName(), p.getPrice(), p.getRating());
        }

        int choice;
        System.out.println("( 1) Buy");
        System.out.println("( 2) Clear");
        do {
            choice = scanner.nextInt();
            if (choice < 1 || choice > 2) {
                System.out.println("Invalid choice. Try choose again!");
            }
        } while (choice < 1 || choice > 2);

        switch (choice) {
            case 1: {
                System.out.println("Buy processed...");
                System.out.println("Buy successfully!");
            }
            case 2: {
                user.getBasket().getProducts().clear();
                System.out.println("Basket is cleared!");
            }
        }
    }

    /**
     * Gets a list of products by category
     * @param scanner the scanner object for user input
     * @param user the logged-in user
     */
    private static void viewProductsByCategory(Scanner scanner, User user) {
        int choice;
        do {
            System.out.println("Enter categories: ");
            choice = scanner.nextInt();

            if (choice > categories.size() - 1) {
                System.out.println("Invalid choice. Please try again!");
            }
        } while (choice > categories.size() - 1);

        int choiceProduct;
        System.out.println("To add a product int the basket, enter its number or enter 0 to enter the main menu");
        System.out.println("№ | Name product | price product | rating product");
        for (Product p: categories.get(choice).getProducts()) {
            System.out.printf("%4s | %3s | %3s | %3s\n", (categories.get(choice).getProducts().indexOf(p) + 1), p.getName(), p.getPrice(), p.getRating());
        }

        do {
            choiceProduct = scanner.nextInt() - 1;

            if (choiceProduct < 0 || choiceProduct > categories.get(choice).getProducts().size()) {
                System.out.println("Invalid choice. Try choose again!");
            } else {
                user.getBasket().addProduct(categories.get(choice).getProducts().get(choiceProduct));
            }
        } while (choiceProduct < 0 || choiceProduct > categories.get(choice).getProducts().size());
    }

    /**
     * Gets list of categories
     */
    private static void viewCategories() {
        for (Category c : categories) {
            System.out.println("( "+ (categories.indexOf(c) + 1) + ") " + c.getName());
        }
    }

    /**
     * User authentication
     * @param scanner the Scanner object for user input
     * @return logged-in user object
     */
    private static User auth(Scanner scanner) {
        User user = null;
        String login;
        String password;

        do {
            System.out.println("Enter please your login");
            login = scanner.nextLine();
            System.out.println("Enter please your password");
            password = scanner.nextLine();

            for(User u: users) {
                if (u.validateLogin(login) && u.validatePassword(password)) {
                    user = u;
                }
            }

            if (user == null) {
                System.out.println("Incorrect login or password. Try again please!");
            }
        } while (user == null);

        return user;
    }
}
