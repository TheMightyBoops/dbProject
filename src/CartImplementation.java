import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartImplementation implements CartDao {

    private Connection connection = null;
    private List<Cart> carts = new ArrayList<>();
    private final String SQL_CONN = "jdbc:derby:/home/lucas/School/DistJava/dbProject/StoreDB;create=true";

    CartImplementation() {
        try {
            connection = DriverManager.getConnection(SQL_CONN);
            CreateStoreDB.buildCartTable(connection);
        } catch (SQLException sqle) {
            System.out.println("sql server couldn't connect");
            System.out.println(sqle.getMessage());
        }
    }

    @Override
    public List getAllCarts() {
        try {
            //purge list
            carts.clear();
            Statement sql = connection.createStatement();
            ResultSet resultSet = sql.executeQuery("SELECT * FROM Carts");

            while(resultSet.next()) {

                int id = resultSet.getInt("CartID");
                int quantity = resultSet.getInt("Quantity");
                int productID = resultSet.getInt("ProductID");
                Cart cart = new Cart();
                cart.setId(id);
                cart.setProductID(productID);
                cart.setQuantity(quantity);
                carts.add(cart);
            }
        } catch (SQLException sqle) {
            System.out.println("Failed at displaying prods");
            System.out.println(sqle.getMessage());
        }
        return carts;
    }

    @Override
    public Cart getCart(Cart cart) {
        try {
            return carts.get(cart.getId()-1);
        } catch (NullPointerException npe) {
            System.out.println("Id NAN");
            return null;
        }
    }

    @Override
    public void updateCart(Cart cart) {
        try {
            Statement sql = connection.createStatement();

            sql.execute("UPDATE Carts" +
                    "SET Quantity='" + cart.getQuantity() +
                    "' WHERE CartID=" + cart.getId());
            System.out.println("Cart at id:" + cart.getId() + " edited.");
        } catch (SQLException sqle) {
            System.out.println("Failed at update prod\n"
                    + sqle.getMessage());
        }
    }

    @Override
    public void deleteCart(Cart cart) {
        try {
            Statement sql = connection.createStatement();

            sql.execute("DELETE From Carts Where CartID="
                    + cart.getId());
            System.out.println("cart " + cart.getId() + " deleted.");
        } catch (SQLException sqle) {
            System.out.println("Delete cart\n" + sqle.getMessage());
        }
    }

    @Override
    public void addCart(Cart cart) {
        try {
            Statement sql = connection.createStatement();
            sql.execute("INSERT INTO Carts VALUES(DEFAULT, " +
                    cart.getQuantity() + "," +
                    cart.getProductID() +
                    ")");
            System.out.println("Cart added");
        } catch (SQLException sqle) {
            System.out.println("Add cart\n" + sqle.getMessage());
        }
    }

    public void closeCartConnection() {
        try {
            connection.close();
        } catch (SQLException sqle) {
            System.out.println("Closing cart conn.\n" + sqle.getMessage());
        }
    }
}
