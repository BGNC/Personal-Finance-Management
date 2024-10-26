package com.bgnc.personalfinancemanagement.controller.impl;

import com.bgnc.personalfinancemanagement.controller.ICategoryController;
import com.bgnc.personalfinancemanagement.controller.RestBaseController;
import com.bgnc.personalfinancemanagement.controller.RootEntity;
import com.bgnc.personalfinancemanagement.dto.CategoryRequest;
import com.bgnc.personalfinancemanagement.dto.CategoryResponse;
import com.bgnc.personalfinancemanagement.service.ICategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/api/v1/category")
public class CategoryControllerImpl extends RestBaseController implements ICategoryController {

    private final ICategoryService categoryService;


    @PostMapping("/save")
    @Override
    public RootEntity<CategoryResponse> saveCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        return ok(categoryService.saveCategory(categoryRequest));
    }


}
