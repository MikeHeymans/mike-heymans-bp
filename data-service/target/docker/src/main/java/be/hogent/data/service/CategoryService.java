package be.hogent.data.service;

import be.hogent.data.model.Category;
import be.hogent.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModificationLogService modificationLogService;

    public Category findOne(Long id) {
        return categoryRepository.findOne(id);
    }

    public void save(Category price) {
        modificationLogService.create(price);
        categoryRepository.save(price);
    }

    public void save(List<Category> categoryList) {
        if (categoryList != null) {
            categoryList.forEach(this::save);
        }
    }
}
