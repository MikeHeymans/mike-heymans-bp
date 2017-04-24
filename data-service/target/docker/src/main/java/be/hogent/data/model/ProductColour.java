package be.hogent.data.model;

import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.FrozenValue;
import com.datastax.driver.mapping.annotations.UDT;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
@UDT(name = "product_colour")
public class ProductColour {
    @Field(name = "id")
    private Long id;
    @Field(name = "description")
    private Map<String,String> description;
    @Field(name = "sizes")
    @FrozenValue
    private Set<ProductSize> sizes;
}
