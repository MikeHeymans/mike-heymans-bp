package be.hogent.data.web.dto.mapper;

import be.hogent.data.model.Category;
import be.hogent.data.model.Product;
import be.hogent.data.model.ProductColour;
import be.hogent.data.model.ProductSize;
import be.hogent.data.web.dto.CategoryDTO;
import be.hogent.data.web.dto.ProductColourDTO;
import be.hogent.data.web.dto.ProductDTO;
import be.hogent.data.web.dto.ProductSizeDTO;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import java.util.Set;
import java.util.stream.Collectors;

public class CategoryDTOMapper {
    private static final Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

    public static CategoryDTO toDto(Category category) {
        CategoryDTO dto = null;
        if(category != null) {
            dto = mapper.map(category,CategoryDTO.class);
        }
        return dto;
    }

    public static Category toEntity(CategoryDTO dto) {
        Category entity = null;
        if(dto != null) {
            entity = mapper.map(dto,Category.class);
        }
        return entity;
    }
}
