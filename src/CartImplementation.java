import java.util.ArrayList;
import java.util.List;

public class CartImplementation implements CartDao {

    private List<Cart> carts = null;

    CartImplementation() {
        carts = new ArrayList<>();
    }

    @Override
    public List getAllCarts() {
        return carts;
    }

    @Override
    public Cart getCart(int id) {
        return carts.get(id);
    }

    @Override
    public void updateProduct(Cart cart) {
        //TODO
        carts.get(cart.getId());
    }

    @Override
    public void deleteProduct(Cart cart) {
        //TODO
    }

    @Override
    public void addProduct(Cart cart) {
        //TODO
    }
}
