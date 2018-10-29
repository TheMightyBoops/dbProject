import com.sun.org.apache.bcel.internal.generic.Select;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Main cannot have any sql in it: needs to list db contents and
 * be able to list records
 *
 * @author lucas
 */
public class Main {
    public static void main(String[] args) {


        ProductImplementation prodDb = new ProductImplementation();
        // create all the products
        prodDb.addProduct(new Product("Old Gray", "This classic is the most basic, " +
                "standard rock that we do at Rocks and rocks alone", 4.99));
        prodDb.addProduct(new Product("Classic Granite", "Add a little style and flair " +
                "to your rock.", 6.00));
        prodDb.addProduct(new Product("Dark Slate", "Like a chalkboard, " +
                "but you buy it from us", 5.00));
        Scanner key = new Scanner(System.in);

        CartImplementation cartDb = new CartImplementation();

        System.out.println("Select an Option");
        System.out.println("****************");
        System.out.println("\n1-List all products");
        System.out.println("2-Add one to the cart");
        System.out.println("3-See your cart");
        System.out.println("4-Exit\n");
        int selection = key.nextInt();
        key.nextLine();

        while (selection != 4) {
            if (selection == 1) {
                listAllProducts(prodDb);
            }

            if (selection == 2) {
                addAnItemToTheCart(cartDb, key);
            }

            if (selection == 3) {
                displayCart(cartDb, prodDb);
            }

            System.out.println("Select an Option");
            System.out.println("****************");
            System.out.println("\n1-List all products");
            System.out.println("2-Add one to the cart");
            System.out.println("3-See your cart");
            System.out.println("4-Exit\n");

            selection = key.nextInt();
            key.nextLine();
        }

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:derby:/home/lucas/School/DistJava/dbProject/StoreDB;" +
                            "create=true");
            CreateStoreDB.dropTables(connection);
        } catch (SQLException sqle) {

        }
        prodDb.closeProductConnection();
        cartDb.closeCartConnection();
    }

    private static void listAllProducts(ProductImplementation prodDB) {


        List<Product> products = prodDB.getAllProducts();
        for (Product p : products) {
            System.out.println("ID: " + p.getId());
            System.out.println("Name:" + p.getName());
            System.out.println("Description: " + p.getDescription());
            System.out.println("Price: " + p.getPrice() + "\n");
        }

    }

    private static void addAnItemToTheCart(CartImplementation cartDB, Scanner key) {
        System.out.println("Which item?\n1)Old Gray\n2)Classic " +
                "Granite\n3)Dark Slate\n");
        int selection = key.nextInt();
        key.nextLine();

        switch (selection) {
            case 1:
                cartDB.addCart(new Cart(1, 1));
                break;
            case 2:
                cartDB.addCart(new Cart(1, 2));
                break;
            case 3:
                cartDB.addCart(new Cart(1, 3));
                break;
            default:
                System.out.println("try again");
                addAnItemToTheCart(cartDB, key);
        }
    }

    private static void displayCart(CartImplementation cartBD,
                                    ProductImplementation prodDB) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:derby:/home/lucas/School/DistJava/dbProject/StoreDB;" +
                            "create=true");

            Statement sql = connection.createStatement();
            ResultSet resultSet = sql.executeQuery(
              "SELECT Name, DESCRIPTION, PRICE " +
                      "FROM Carts " +
                      "Inner JOIN PRODUCTS " +
                      "On PRODUCTS.PRODUCTID = CARTS.ProductId"
            );

            while (resultSet.next()) {
                System.out.println("Product:" +
                        resultSet.getString("Name") +
                        "\nDescription: " +
                        resultSet.getString("Description") +
                        "\nPrice:" +
                        resultSet.getString("Price")
                        + "\n"
                );
            }
        }catch (Exception e) {
            System.out.println("Couldn't display cart\n" + e.getMessage());
        }
    }
}
