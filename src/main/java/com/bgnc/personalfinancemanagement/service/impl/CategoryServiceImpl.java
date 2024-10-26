package com.bgnc.personalfinancemanagement.service.impl;

import com.bgnc.personalfinancemanagement.dto.CategoryRequest;
import com.bgnc.personalfinancemanagement.dto.CategoryResponse;
import com.bgnc.personalfinancemanagement.model.Category;
import com.bgnc.personalfinancemanagement.repository.CategoryRepository;
import com.bgnc.personalfinancemanagement.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository categoryRepository;

    private Category  createCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setCreateTime(LocalDate.now());
        category.setCategoryType(categoryRequest.getCategoryType());
        category.setName(categoryRequest.getName());
        categoryRepository.save(category);
        return category;
    }

    @Override
    public CategoryResponse saveCategory(CategoryRequest request) {

        Category category = createCategory(request);
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setName(category.getName());
        categoryResponse.setCategoryType(category.getCategoryType());
        categoryResponse.setCreateTime(category.getCreateTime());

        return categoryResponse;
    }
}
