package be.hogent.data.model;

import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.FrozenValue;
import com.datastax.driver.mapping.annotations.UDT;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@UDT(name = "price_colour")
public class PriceColour {
    @Field(name = "id")
    private Long id;
    @Field(name = "sell_price")
    private BigDecimal sellPrice;
    @Field(name = "standard_price")
    private BigDecimal standardPrice;
    @Field(name = "sizes")
    @FrozenValue
    private Set<PriceSize> sizes;
}
