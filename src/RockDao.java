import java.util.List;

public interface RockDao {
    public List getAllProducts();

    public Product getProduct(String id);

    public void updateProduct(Product product);

    public void deleteProduct(Product product);

    public void addProduct(Product product);
}
