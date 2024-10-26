package com.bgnc.personalfinancemanagement.dto;

import com.bgnc.personalfinancemanagement.enums.CategoryType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryRequest {

    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;
}
