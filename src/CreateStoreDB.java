import java.sql.*;

public class CreateStoreDB {
    public CreateStoreDB() {
        final String DB_URL = "jdbc:derby:/home/lucas/School/DistJava/dbProject/StoreDB;create=true";
        //TODO Add the correct db URL

        try {
            Connection connection = DriverManager.getConnection(DB_URL);

            dropTables(connection);
            buildCartTable(connection);
            buildProductTable(connection);
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
                sql.execute("DROP TABLE Product");
                sql.execute("DROP TABLE Cart");
                System.out.println("Tables Dropped");
            } catch (SQLException sqle) {
                //do nothing
            }
        } catch (SQLException sqle) {
            System.out.println("Failed at drop table");
            System.out.println(sqle.getMessage());
        }
    }

    public static void buildProductTable(Connection connection) {
        try {
            Statement sql = connection.createStatement();
            //TODO Create Product table
        } catch (SQLException sqle) {
            System.out.println("Failed at build product table");
            System.out.println(sqle.getMessage());
        }
    }

    public static void buildCartTable(Connection connection) {

        try {
            Statement sql = connection.createStatement();
            //TODO Create cart table
        } catch (SQLException sqle) {
            System.out.println("Failed at buildCartTable");
            System.out.println(sqle.getMessage());
        }
    }
}
