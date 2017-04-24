package be.hogent.data.web.dto;

import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
public class ProductColourDTO {
    private Long id;
    private Map<String,String> description;
    private Set<ProductSizeDTO> sizes;
}
