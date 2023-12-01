package lernia.java.laboration02_sysark.entities;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class Product {
    private static int products = 0;
    private final int ID;
    @NotNull(message = "Product name can not be null!")
    @NotEmpty(message = "Product name can not be empty!")
    private String productName;
    @NotNull(message = "Product category can not be null!")
    private Category category;
    @Min(value = 0, message = "Product rating can not be less then 0!")
    @Max(value = 10, message = "Product rating can not be more then 10!")
    private double rating;
    private final LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Product(){
        ID=products;
        LocalDateTime now = LocalDateTime.now();
        this.createdDate = now;
        this.modifiedDate = now;
    };

    public Product(String productName, Category category, double rating) {
        this.ID = products;
        this.productName = productName;
        this.category = category;
        this.rating = rating;
        LocalDateTime now = LocalDateTime.now();
        this.createdDate = now;
        this.modifiedDate = now;
        products++;
    }

    public Product(String productName, Category category, double rating, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.ID = products;
        this.productName = productName;
        this.category = category;
        this.rating = rating;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        products++;
    }

    public int getID() {
        return ID;
    }

    public String getProductName() {
        return productName;
    }

    public Category getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setProductName(String productName) {
        this.productName = productName;
        setModifiedDate(LocalDateTime.now());
    }

    public void setCategory(Category category) {
        this.category = category;
        setModifiedDate(LocalDateTime.now());
    }

    public void setRating(double rating) {
        this.rating = rating;
        setModifiedDate(LocalDateTime.now());
    }

    private void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", productName='" + productName + '\'' +
                ", category=" + category +
                ", rating=" + rating +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
