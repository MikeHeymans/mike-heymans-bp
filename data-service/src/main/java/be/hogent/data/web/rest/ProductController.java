package be.hogent.data.web.rest;

import be.hogent.data.model.Product;
import be.hogent.data.service.ProductService;
import be.hogent.data.web.dto.ProductDTO;
import be.hogent.data.web.dto.mapper.ProductDTOMapper;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody ProductDTO productDTO) {
        productService.save(ProductDTOMapper.toEntity(productDTO));
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/bulk", method = RequestMethod.POST)
    public ResponseEntity saveBulk(@RequestBody List<ProductDTO> productDTOList) {
        List<Product> productList = productDTOList.stream()
                .map(dto -> ProductDTOMapper.toEntity(dto))
                .collect(Collectors.toList());
        productService.save(productList);
        return new ResponseEntity(HttpStatus.OK);
    }
    @RequestMapping(value = "/mock", method = RequestMethod.POST)
    public ResponseEntity saveMock(@RequestBody List<ProductDTO> productDTOList) {
        List<Product> productList = productDTOList.stream()
                .map(dto -> ProductDTOMapper.toEntity(dto))
                .collect(Collectors.toList());
        productList.forEach(product -> {
            product.setActive(true);
            product.setCategoryId(product.getId() % 3);
        });
        productService.save(productList);
        return new ResponseEntity(HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductDTO> findOne(@PathVariable("id") Long id) {
        ResponseEntity<ProductDTO> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Product product = productService.findOne(id);
        if (product != null) {
            responseEntity = new ResponseEntity<>(ProductDTOMapper.toDto(product), HttpStatus.OK);
        }
        return responseEntity;
    }
}
