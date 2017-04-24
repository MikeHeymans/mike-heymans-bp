package be.hogent.data.web.dto.mapper;

import be.hogent.data.model.Product;
import be.hogent.data.model.ProductColour;
import be.hogent.data.model.ProductSize;
import be.hogent.data.web.dto.ProductColourDTO;
import be.hogent.data.web.dto.ProductDTO;
import be.hogent.data.web.dto.ProductSizeDTO;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import java.util.Set;
import java.util.stream.Collectors;

public class ProductDTOMapper {
    private static final Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

    public static ProductDTO toDto(Product product) {
        ProductDTO dto = null;
        if (product != null) {
            dto = mapper.map(product, ProductDTO.class);
            dto.setColours(toColoursDto(product.getColours()));
        }
        return dto;
    }

    private static Set<ProductColourDTO> toColoursDto(Set<ProductColour> colours) {
        return colours == null ? null : colours.stream()
                .map(colour -> toColourDto(colour))
                .collect(Collectors.toSet());
    }

    private static ProductColourDTO toColourDto(ProductColour colour) {
        ProductColourDTO dto = null;
        if (colour != null) {
            dto = mapper.map(colour, ProductColourDTO.class);
            dto.setSizes(toSizesDto(colour.getSizes()));
        }
        return dto;
    }

    private static Set<ProductSizeDTO> toSizesDto(Set<ProductSize> sizes) {
        return sizes == null ? null : sizes.stream()
                .map(size -> mapper.map(size, ProductSizeDTO.class))
                .collect(Collectors.toSet());
    }

    public static Product toEntity(ProductDTO product) {
        Product entity = null;
        if (product != null) {
            entity = mapper.map(product, Product.class);
            entity.setColours(toColoursEntity(product.getColours()));
        }
        return entity;
    }

    private static Set<ProductColour> toColoursEntity(Set<ProductColourDTO> colours) {
        return colours == null ? null : colours.stream()
                .map(colour -> toColourEnitity(colour))
                .collect(Collectors.toSet());
    }

    private static ProductColour toColourEnitity(ProductColourDTO colour) {
        ProductColour entity = null;
        if (colour != null) {
            entity = mapper.map(colour, ProductColour.class);
            entity.setSizes(toSizesEntity(colour.getSizes()));
        }
        return entity;
    }

    private static Set<ProductSize> toSizesEntity(Set<ProductSizeDTO> sizes) {
        return sizes == null ? null : sizes.stream()
                .map(size -> mapper.map(size, ProductSize.class))
                .collect(Collectors.toSet());
    }
}
