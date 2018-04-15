package sandbox;

import java.util.UUID;

public class Product {

    private UUID id;
    private String name;
    private ProductType productType;

    public Product(String name, ProductType productType) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public UUID getId() {
        return id;
    }
}
