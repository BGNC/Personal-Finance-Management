package com.bgnc.personalfinancemanagement.model;

import com.bgnc.personalfinancemanagement.enums.CategoryType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "category")
public class Category extends BaseEntity{

    @Column(name = "name")
    @NotEmpty(message = "Category field is required")
    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;
}
