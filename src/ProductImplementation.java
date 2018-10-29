import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductImplementation implements ProductDao {

    private List<Product> products = new ArrayList<>();
    Connection connection = null;
    private String SQL_CONN = "jdbc:derby:/home/lucas/School/DistJava/dbProject/StoreDB;create=true";

    public ProductImplementation() {
        try {
            connection = DriverManager.getConnection(SQL_CONN);
            CreateStoreDB.buildProductTable(connection);
        } catch (SQLException sqle) {
            System.out.println("sql server couldn't connect");
            System.out.println(sqle.getMessage());
        }
    }

    @Override
    public List getAllProducts() {
        try {
            //purge list
            products.clear();
            Statement sql = connection.createStatement();
            ResultSet resultSet = sql.executeQuery("SELECT * FROM Products");

            while(resultSet.next()) {
                int id = resultSet.getInt("ProductID");
                String name = resultSet.getString("Name");
                String description = resultSet.getString("Description");
                double price = resultSet.getDouble("Price");
                Product product = new Product();
                product.setId(id);
                product.setName(name);
                product.setDescription(description);
                product.setPrice(price);
                products.add(product);
            }
        } catch (SQLException sqle) {
            System.out.println("Failed at displaying prods");
            System.out.println(sqle.getMessage());
        }
        return products;
    }

    @Override
    public Product getProduct(Product product) {
        try {
            return products.get(product.getId()-1);
        } catch (NullPointerException npe) {
            System.out.println("Id not a number");
            return null;
        }
    }

    @Override
    public void updateProduct(Product product) {
        try {
            Statement sql = connection.createStatement();

            sql.execute("UPDATE PRODUCTS " +
                    "SET NAME='" + product.getName() +
                    "', DESCRIPTION='" + product.getDescription() +
                    "', PRICE=" + product.getPrice()
                    + "WHERE ProductID=" + product.getId());
            System.out.println("product id:" + product.getId() + " was changed");
        }catch (SQLException sqle) {
            System.out.println("update product" + "\n" + sqle.getMessage());
        }
    }

    @Override
    public void deleteProduct(Product product) {
        try {
            Statement sql = connection.createStatement();
            sql.execute("DELETE From Products Where ProductID= " + product.getId());
            System.out.println(product.getName().trim() + " deleted.");
        } catch (SQLException sqle) {
            System.out.println("Delete product\n" + sqle.getMessage());
        }

    }

    @Override
    public void addProduct(Product product) {
        try {
            Statement sql = connection.createStatement();
            sql.execute("INSERT INTO Products VALUES (DEFAULT, " +
                    "'" + product.getName() + "'," +
                    "'" + product.getDescription() + "'," +
                    product.getPrice() + ")");
        } catch (SQLException sqle) {
            System.out.println("Add prod \n " + sqle.getMessage());
        }
    }

    public void closeProductConnection() {
        try {
            connection.close();
        } catch (SQLException sqle) {
            System.out.println(" Closing prod Conn.\n" +sqle.getMessage());
        }
    }
}
