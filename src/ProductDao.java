import java.util.List;

public interface ProductDao {
    public List getAllProducts();

    public Product getProduct(Product product);

    public void updateProduct(Product product);

    public void deleteProduct(Product product);

    public void addProduct(Product product);
}
