package com.bgnc.personalfinancemanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Transaction extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User cannot be null")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    @NotNull(message = "Category cannot be null")
    private Category category;

    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be greater than zero")
    private BigDecimal amount;

    @NotNull(message = "Transaction date cannot be null")
    @Column(name = "transaction_date")
    private Date transactionDate;

    @NotBlank(message = "Description cannot be empty")
    @Size(max = 255, message = "Description must be at most 255 characters")
    private String description;

}