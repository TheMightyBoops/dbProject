import java.util.ArrayList;

public class Cart {
    private int id;
    private ArrayList<Product> products;

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

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
