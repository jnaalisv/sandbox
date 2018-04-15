package sandbox;

import java.util.UUID;

public interface ProductRepository {
    void save(Product product);

    Product read(UUID id);
}
