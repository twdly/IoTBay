package unit;

import isdwrk04.group5.iotbay.dao.ProductDao;
import isdwrk04.group5.iotbay.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductDaoTest {

    public ProductDao dao;

    @BeforeEach
    public void before() {
        dao = new ProductDao();
    }

    @Test
    public void testGetAllProducts() {
        List<Product> products = dao.getAllProducts();
        Product dingtek = products.stream().filter(product -> product.getId() == 1000).findFirst().orElse(null);
        assertNotNull(dingtek);
        assertEquals("A sensor for your bin", dingtek.getDescription());

        Product healthguard = products.stream().filter(product -> product.getId() == 1018).findFirst().orElse(null);
        assertNotNull(healthguard);
        assertEquals("Tracks steps, heart rate, and sleep patterns", healthguard.getDescription());
    }
}
