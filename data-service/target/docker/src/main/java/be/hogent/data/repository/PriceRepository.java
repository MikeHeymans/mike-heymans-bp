package be.hogent.data.repository;

import be.hogent.data.model.Price;
import be.hogent.data.model.Product;
import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class PriceRepository extends AbstractRepository<Price> {

    @Autowired
    public PriceRepository(Session session) {
        super(session, Price.class);
    }
}
