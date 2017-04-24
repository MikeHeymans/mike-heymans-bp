package be.hogent.data.repository;

import be.hogent.data.model.ModificationLog;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.utils.UUIDs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;
import static com.datastax.driver.core.querybuilder.QueryBuilder.gte;


@Repository
public class ModificationLogRepository extends AbstractRepository<ModificationLog> {

    @Autowired
    public ModificationLogRepository(Session session) {
        super(session, ModificationLog.class);
    }

    public Set<Long> findModified(String table, Date since) {
        Statement statement = QueryBuilder
                .select("id")
                .distinct()
                .from("modification_log")
                .where(eq("table_name",table))
                .and(gte("time", UUIDs.startOf(since.getTime())));
        return session.execute(statement).all().stream()
                .map(row -> row.get(0,Long.class))
                .collect(Collectors.toSet());
    }
}
