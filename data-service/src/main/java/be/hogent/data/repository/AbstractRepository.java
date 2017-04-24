package be.hogent.data.repository;


import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;

public abstract class AbstractRepository<T> {
    protected Mapper<T> mapper;
    protected Session session;
    private MappingManager mappingManager;

    public AbstractRepository(Session session,Class<T> tClass) {
        if(session != null) {
            this.session = session;
            this.mappingManager = new MappingManager(session);
            this.mapper = mappingManager.mapper(tClass);
        }
    }

    public T findOne(Object... keys) {
        return mapper.get(keys);
    }

    public void save(T entity) {
        mapper.save(entity);
    }
    public void delete(Object... keys) {
        mapper.delete(keys);
    }
}
