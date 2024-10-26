package com.bgnc.personalfinancemanagement.service;

import com.bgnc.personalfinancemanagement.dto.CategoryRequest;
import com.bgnc.personalfinancemanagement.dto.CategoryResponse;

public interface ICategoryService {
    CategoryResponse saveCategory(CategoryRequest request);
}
