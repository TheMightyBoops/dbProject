import java.util.List;

public interface CartDao {
    public List getAllCarts();

    public Cart getCart(int id);

    public void updateProduct(Cart cart);

    public void deleteProduct(Cart cart);

    public void addProduct(Cart cart);
}
