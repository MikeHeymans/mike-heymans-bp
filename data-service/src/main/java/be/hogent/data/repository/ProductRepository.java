package be.hogent.data.repository;

import be.hogent.data.model.Product;
import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ProductRepository extends AbstractRepository<Product> {

    @Autowired
    public ProductRepository(Session session) {
        super(session, Product.class);
    }
}
