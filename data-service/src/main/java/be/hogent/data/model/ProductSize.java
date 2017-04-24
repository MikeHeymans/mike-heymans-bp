package be.hogent.data.model;

import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;
import lombok.Data;

import java.util.Map;

@Data
@UDT(name = "product_size")
public class ProductSize {
    @Field(name = "id")
    private Long id;
    @Field(name = "description")
    private Map<String,String> description;
}
