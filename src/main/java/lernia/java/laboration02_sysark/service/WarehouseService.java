package lernia.java.laboration02_sysark.service;

import lernia.java.laboration02_sysark.entities.Category;
import lernia.java.laboration02_sysark.entities.Product;

import java.util.List;


public interface WarehouseService {
    public Product addNewProduct(String productName, Category category, double rating);

    public List<Product> getAllProducts();
    public Product getProductOnID(int ID);
    public List<Product> getProductsInCategory(Category category);
}
