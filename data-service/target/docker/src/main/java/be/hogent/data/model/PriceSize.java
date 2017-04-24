package be.hogent.data.model;

import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
@UDT(name = "price_size")
public class PriceSize {
    @Field(name = "id")
    private Long id;
    @Field(name = "sell_price")
    private BigDecimal sellPrice;
    @Field(name = "standard_price")
    private BigDecimal standardPrice;
}
