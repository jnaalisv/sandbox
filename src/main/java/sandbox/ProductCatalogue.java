package sandbox;

import java.util.UUID;

public class ProductCatalogue {

    private final ProductRepository productRepository;

    public ProductCatalogue(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addNewProduct(String name, ProductType productType) {

        var product = new Product(name, productType);

        productRepository.save(product);

        return product;
    }

    public Product findById(UUID id) {
        return productRepository.read(id);
    }
}
