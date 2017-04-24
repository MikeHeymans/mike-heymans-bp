package be.hogent.data.web.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PriceSizeDTO {
    private Long id;
    private BigDecimal sellPrice;
    private BigDecimal standardPrice;
}
