import java.util.ArrayList;

public class Cart {
    private int id;
    private ArrayList<Product> products;
    private int productID;
    private int quantity;

    public Cart() {

    }

    public Cart(int quantity, int productID){
        setProductID(productID);
        setQuantity(quantity);
    }

    public Cart(int id) {
        this.id = id;
        products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
