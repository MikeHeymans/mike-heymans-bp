package be.hogent.data.config;

import com.datastax.driver.core.*;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "database")
public class DatabaseConfig {
    private String keyspace;
    private String host;
    private int port;
    private int maxConnections = 8;

    @Bean
    public Session session() {
        return Cluster.builder()
                .addContactPoints(host.split(","))
                .withPort(port)
                .withQueryOptions(new QueryOptions().setConsistencyLevel(ConsistencyLevel.QUORUM))
                .withPoolingOptions(new PoolingOptions().setConnectionsPerHost(HostDistance.LOCAL,2,maxConnections))
                .build()
                .connect(keyspace);
    }
}
