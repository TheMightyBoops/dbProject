import java.util.ArrayList;
import java.util.List;

public class RockImplementation implements RockDao {

    private List<Product> products = null;

    public RockImplementation() {
        products = new ArrayList<>();
    }
    @Override
    public List getAllProducts() {
        return products;
    }

    @Override
    public Product getProduct(String id) {
        try {
            return products.get(Integer.parseInt(id));
        } catch (NullPointerException npe) {
            System.out.println("Id not a number");
            return null;
        }
    }

    @Override
    public void updateProduct(Product product) {
        products.get(Integer.parseInt(product.getId())).setName(product.getName());
        products.get(Integer.parseInt(product.getId())).setDescription(product.getDescription());
        products.get(Integer.parseInt(product.getId())).setPrice(product.getPrice());

    }

    @Override
    public void deleteProduct(Product product) {
        products.remove(product);

    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }
}
