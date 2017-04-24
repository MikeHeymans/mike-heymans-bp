package be.hogent.data.model;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.Data;

import java.util.Map;

@Data
@Table(name = "category")
public class Category implements Logable {
    public static final String CATEGORY = "category";
    @PartitionKey
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private Map<String, String> name;
    @Column(name = "active")
    private Boolean active;

    @Override
    public String getTableName() {
        return CATEGORY;
    }
}
