package lernia.java.laboration02_sysark.entities;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ProductDto (
        @NotNull(message = "Product name can not be null!")
        @NotEmpty(message = "Product name can not be empty!")
        String productName,
        @NotNull(message = "Product category can not be null!")
        Category category,
        @Min(value = 0, message = "Product rating can not be less then 0!")
        @Max(value = 10, message = "Product rating can not be more then 10!")
        double rating) {}
