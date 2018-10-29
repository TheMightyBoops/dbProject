import java.sql.*;

public class CreateStoreDB {
    public CreateStoreDB() {
        final String DB_URL = "jdbc:derby:/home/lucas/School/DistJava/dbProject/StoreDB;create=true";

        try {
            Connection connection = DriverManager.getConnection(DB_URL);

            dropTables(connection);
            buildProductTable(connection);
            buildCartTable(connection);

            Product product = new Product();
            product.setId(0);
            product.setDescription("test des");
            product.setName("test name");
            product.setPrice(1.00);

            addAProductToDB(product, connection);
            connection.close();

        } catch (SQLException sqle) {
            System.out.println("Failed at CreateStoreDB");
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        }
    }

    public static void dropTables(Connection connection) {
        try {
            Statement sql = connection.createStatement();
            try {
                sql.execute("DROP TABLE Carts");
                sql.execute("DROP TABLE Products");
                System.out.println("Tables Dropped");
            } catch (SQLException sqle) {
                //do nothing
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public static void buildProductTable(Connection connection) {
        try {
            Statement sql = connection.createStatement();
            sql.execute("CREATE TABLE Products (" +
                    "ProductID INT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY," +
                    "Name CHAR(30)," +
                    "Description CHAR(200)," +
                    "Price DOUBLE)");
        } catch (SQLException sqle) {
            System.out.println("Failed at build product table");
            System.out.println(sqle.getMessage());
        }
    }

    public static void buildCartTable(Connection connection) {

        try {
            Statement sql = connection.createStatement();
            sql.execute("CREATE TABLE Carts(" +
                    "CartID INT GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY," +
                    "Quantity INT," +
                    "ProductID INT REFERENCES Products(ProductID))");
        } catch (SQLException sqle) {
            System.out.println("Failed at buildCartTable");
            System.out.println(sqle.getMessage());
        }
    }

    public static void addAProductToDB(Product product, Connection connection) {
        try {


            Statement sql = connection.createStatement();


        } catch (SQLException sqle) {
            System.out.println("Failed at addAProductToDB");
            System.out.println(sqle.getMessage());
        }
    }
}
