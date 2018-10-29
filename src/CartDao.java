import java.util.List;

public interface CartDao {
    public List getAllCarts();

    public Cart getCart(Cart cart);

    public void updateCart(Cart cart);

    public void deleteCart(Cart cart);

    public void addCart(Cart cart);
}
