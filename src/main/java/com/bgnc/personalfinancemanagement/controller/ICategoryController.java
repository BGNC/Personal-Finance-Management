package com.bgnc.personalfinancemanagement.controller;

import com.bgnc.personalfinancemanagement.dto.CategoryRequest;
import com.bgnc.personalfinancemanagement.dto.CategoryResponse;

public interface ICategoryController {
    RootEntity<CategoryResponse> saveCategory(CategoryRequest categoryRequest);
}
