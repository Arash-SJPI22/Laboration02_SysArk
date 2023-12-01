package lernia.java.laboration02_sysark.service;


import jakarta.enterprise.context.ApplicationScoped;
import lernia.java.laboration02_sysark.entities.Category;
import lernia.java.laboration02_sysark.entities.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@ApplicationScoped
public class Warehouse implements WarehouseService {

    public Warehouse(){
        addNewProduct("Intel i5 6600K", Category.CPU, 5.8);
        addNewProduct("AMD Ryzen 7 7800X3D", Category.CPU, 8.8);
        addNewProduct("AMD Ryzen 5 7600X", Category.CPU, 6.0);
        addNewProduct("RTX 580", Category.GPU, 6.5);
        addNewProduct("Western Digital DFJ9FJI99M", Category.HDD, 2.43);
        addNewProduct("KingStong DDR4 16GB", Category.RAM, 4.4);

    }

    private List<Product> productList = new CopyOnWriteArrayList<>();


    public Product addNewProduct(String productName,Category category, double rating) {
        checkProductName(productName);
        checkRating(rating);
        Product product = new Product(productName, category, rating);
        productList.add(product);
        return product;

    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(productList);
    }

    public Product getProductOnID(int ID) {
        checkProductID(ID);
        return productList.stream()
                .filter(product -> product.getID() == ID)
                .findFirst()
                .orElse(null);
    }

    public List<Product> getProductsInCategory(Category category) {
        return productList.stream()
                .filter(product -> product.getCategory() == category)
                .sorted(Comparator.comparing(Product::getProductName))
                .toList();
    }


    // Private methods
    private void checkProductName(String productName) {
        if (productName == null || productName.isEmpty())
            throw new IllegalArgumentException("Product name can not be empty or null!");
    }


    private void checkRating(double rating) {
        if (rating < 0 || rating > 10)
            throw new IllegalArgumentException("Product rating can not be less then 0 or more then 10!");
    }

    private void checkProductID (int ID) {
        if (productList.stream().noneMatch(product -> product.getID() == ID))
            throw new IllegalArgumentException("Product with ID: " + ID + ", dose not exist!");
    }
}
