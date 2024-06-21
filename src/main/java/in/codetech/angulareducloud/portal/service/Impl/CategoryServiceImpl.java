package in.codetech.angulareducloud.portal.service.Impl;

import in.codetech.angulareducloud.portal.model.Category;
import in.codetech.angulareducloud.portal.repository.CategoryRepository;
import in.codetech.angulareducloud.portal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        category.setTitle(category.getTitle());
        category.setDescription((category.getDescription()));
        return categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new HashSet<>(categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
