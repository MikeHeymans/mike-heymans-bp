package be.hogent.data.repository;

import be.hogent.data.model.Category;
import be.hogent.data.model.Price;
import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CategoryRepository extends AbstractRepository<Category> {

    @Autowired
    public CategoryRepository(Session session) {
        super(session, Category.class);
    }
}
