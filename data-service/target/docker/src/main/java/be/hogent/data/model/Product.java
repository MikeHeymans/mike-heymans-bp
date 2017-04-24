package be.hogent.data.model;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.FrozenValue;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
@Table(name = "product")
public class Product implements Logable {
    public static final String PRODUCT = "product";
    @PartitionKey
    @Column(name = "id")
    private Long id;
    @Column(name = "id_category")
    private Long categoryId;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "name")
    private Map<String, String> name;
    @Column(name = "description")
    private Map<String, String> description;
    @Column(name = "colours")
    @FrozenValue
    private Set<ProductColour> colours;

    @Override
    public String getTableName() {
        return PRODUCT;
    }
}
