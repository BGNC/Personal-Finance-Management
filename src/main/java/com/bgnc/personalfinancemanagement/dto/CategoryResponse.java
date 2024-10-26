package com.bgnc.personalfinancemanagement.dto;

import com.bgnc.personalfinancemanagement.enums.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryResponse extends ResponseEntity{

    private CategoryType categoryType;
    private String name;

}
