package be.hogent.data.web.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class PriceDTO {
    private Long id;
    private BigDecimal sellPrice;
    private BigDecimal standardPrice;
    private Set<PriceColourDTO> colours;
}
