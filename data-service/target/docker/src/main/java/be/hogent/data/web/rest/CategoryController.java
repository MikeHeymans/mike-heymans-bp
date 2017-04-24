package be.hogent.data.web.rest;

import be.hogent.data.model.Category;
import be.hogent.data.service.CategoryService;
import be.hogent.data.web.dto.CategoryDTO;
import be.hogent.data.web.dto.mapper.CategoryDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody CategoryDTO categoryDTO) {
        categoryService.save(CategoryDTOMapper.toEntity(categoryDTO));
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/bulk", method = RequestMethod.POST)
    public ResponseEntity saveBulk(@RequestBody List<CategoryDTO> productDTOList) {
        List<Category> categoryList = productDTOList.stream()
                .map(dto -> CategoryDTOMapper.toEntity(dto))
                .collect(Collectors.toList());
        categoryService.save(categoryList);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CategoryDTO> findOne(@PathVariable("id") Long id) {
        ResponseEntity<CategoryDTO> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Category category = categoryService.findOne(id);
        if (category != null) {
            responseEntity = new ResponseEntity<>(CategoryDTOMapper.toDto(category), HttpStatus.OK);
        }
        return responseEntity;
    }
}
