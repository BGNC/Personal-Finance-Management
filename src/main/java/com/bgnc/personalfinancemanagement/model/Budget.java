package com.bgnc.personalfinancemanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Fetch;


import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "budget")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Budget extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // This refers to the User entity


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    @Column(name = "budget_amount")
    private BigDecimal budgetAmount;

    @NotNull(message = "Transaction date cannot be null")
    @Column(name = "start_date")
    private Date startDate;

    @NotNull(message = "Transaction date cannot be null")
    @Column(name = "end_date")
    private Date endDate;
}
