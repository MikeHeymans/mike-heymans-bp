package be.hogent.data.web.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ProductSizeDTO {
    private Long id;
    private Map<String,String> description;
}
