package be.hogent.data.web.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class PriceColourDTO {
    private Long id;
    private BigDecimal sellPrice;
    private BigDecimal standardPrice;
    private Set<PriceSizeDTO> sizes;
}
