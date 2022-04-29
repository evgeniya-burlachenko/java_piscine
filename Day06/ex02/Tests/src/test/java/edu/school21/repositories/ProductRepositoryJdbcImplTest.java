package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


public class ProductRepositoryJdbcImplTest {
    ProductsRepository productsRepository;
    EmbeddedDatabase dataSource;

    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(1L, "Barni", 66),
            new Product(2L, "Mars", 68),
            new Product(3L, "Baunti", 70),
            new Product(4L, "Snikers", 64),
            new Product(5L, "Nuts", 55)
    );
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(4L, "Snikers", 64);
    final Product EXPECTED_UPDATED_PRODUCT = new Product(3L, "Milka", 12);
    final Product EXPECTED_SAVED_PRODUCT = new Product(6L, "Hello world", 100);

    @BeforeEach
    void init() {
        dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        productsRepository = new ProductsRepositoryJdbcImpl(dataSource);
    }

    @Test
    void testFindAll() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, productsRepository.findAll());
    }

    @Test
    void testFindById() throws SQLException {
        Assertions.assertEquals(productsRepository.findById(4L).get(), EXPECTED_FIND_BY_ID_PRODUCT);
    }

    @Test
    void testUpdate() throws SQLException {
        productsRepository.update(EXPECTED_UPDATED_PRODUCT);
        Assertions.assertEquals(productsRepository.findById(3L).get(), EXPECTED_UPDATED_PRODUCT);
    }

    @Test
    void testSave() throws SQLException {
        productsRepository.save(EXPECTED_SAVED_PRODUCT);
        Assertions.assertEquals(productsRepository.findById(6L).get(), EXPECTED_SAVED_PRODUCT);
    }

    @Test
    void testDelete() throws SQLException {
        productsRepository.delete(1L);
        Assertions.assertThrows(RuntimeException.class, () -> productsRepository.findById(1L));
    }

    @AfterEach
    void close() {
        dataSource.shutdown();
    }

}
