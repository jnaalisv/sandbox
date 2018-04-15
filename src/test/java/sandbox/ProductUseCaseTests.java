package sandbox;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductUseCaseTests {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductCatalogue productCatalogue;

    private static String newProductName = "8086";
    private static final ProductType newProductType = ProductType.SPARE_PARTS;

    @Test
    void aNewProductCanBeAdded() {
        var addedProduct = productCatalogue.addNewProduct(newProductName, newProductType);

        assertThat(addedProduct.getName()).isEqualTo(newProductName);
        assertThat(addedProduct.getProductType()).isEqualTo(newProductType);
        verify(productRepository).save(addedProduct);
    }

    @Nested
    class AfterProductIsAdded {

        private Product product;

        @BeforeEach
        void addProductToCatalogue() {
            product = productCatalogue.addNewProduct(newProductName, newProductType);
        }

        @Test
        void itCanBeFetchedById() {
            when(productRepository.read(product.getId())).thenReturn(product);

            var foundProduct = productCatalogue.findById(product.getId());

            assertThat(foundProduct.getId()).isEqualTo(product.getId());
        }
    }
}
