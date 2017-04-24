package be.hogent.data.service;

import be.hogent.data.model.Product;
import be.hogent.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModificationLogService modificationLogService;

    public Product findOne(Long id) {
        return productRepository.findOne(id);
    }

    public void save(Product product) {
        modificationLogService.create(product);
        productRepository.save(product);
    }

    public void save(List<Product> productList) {
        if (productList != null) {
            productList.forEach(this::save);
        }
    }
}
