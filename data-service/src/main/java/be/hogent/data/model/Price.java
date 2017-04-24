package be.hogent.data.model;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.FrozenValue;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Table(name = "price")
public class Price implements Logable {
    public static final String PRICE = "price";
    @PartitionKey
    @Column(name = "id")
    private Long id;
    @Column(name = "sell_price")
    private BigDecimal sellPrice;
    @Column(name = "standard_price")
    private BigDecimal standardPrice;
    @Column(name = "colours")
    @FrozenValue
    private Set<PriceColour> colours;

    @Override
    public String getTableName() {
        return PRICE;
    }
}
