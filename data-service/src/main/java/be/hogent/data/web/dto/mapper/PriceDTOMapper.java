package be.hogent.data.web.dto.mapper;

import be.hogent.data.model.*;
import be.hogent.data.web.dto.*;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import java.util.Set;
import java.util.stream.Collectors;

public class PriceDTOMapper {
    private static final Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

    public static PriceDTO toDto(Price price) {
        PriceDTO dto = null;
        if (price != null) {
            dto = mapper.map(price, PriceDTO.class);
            dto.setColours(toColoursDto(price.getColours()));
        }
        return dto;
    }

    private static Set<PriceColourDTO> toColoursDto(Set<PriceColour> colours) {
        return colours == null ? null : colours.stream()
                .map(colour -> toColourDto(colour))
                .collect(Collectors.toSet());
    }

    private static PriceColourDTO toColourDto(PriceColour colour) {
        PriceColourDTO dto = null;
        if (colour != null) {
            dto = mapper.map(colour, PriceColourDTO.class);
            dto.setSizes(toSizesDto(colour.getSizes()));
        }
        return dto;
    }

    private static Set<PriceSizeDTO> toSizesDto(Set<PriceSize> sizes) {
        return sizes == null ? null : sizes.stream()
                .map(size -> mapper.map(size, PriceSizeDTO.class))
                .collect(Collectors.toSet());
    }

    public static Price toEntity(PriceDTO priceDTO) {
        Price entity = null;
        if (priceDTO != null) {
            entity = mapper.map(priceDTO, Price.class);
            entity.setColours(toColoursEntity(priceDTO.getColours()));
        }
        return entity;
    }

    private static Set<PriceColour> toColoursEntity(Set<PriceColourDTO> colours) {
        return colours == null ? null : colours.stream()
                .map(colour -> toColourEnitity(colour))
                .collect(Collectors.toSet());
    }

    private static PriceColour toColourEnitity(PriceColourDTO colour) {
        PriceColour entity = null;
        if (colour != null) {
            entity = mapper.map(colour, PriceColour.class);
            entity.setSizes(toSizesEntity(colour.getSizes()));
        }
        return entity;
    }

    private static Set<PriceSize> toSizesEntity(Set<PriceSizeDTO> sizes) {
        return sizes == null ? null : sizes.stream()
                .map(size -> mapper.map(size, PriceSize.class))
                .collect(Collectors.toSet());
    }
}
