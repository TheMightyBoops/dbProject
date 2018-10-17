import java.util.ArrayList;

public class Cart {
    private int id;
    private ArrayList<Product> products;

    public Cart(int id) {
        this.id = id;
        products = new ArrayList<>();
    }

}
