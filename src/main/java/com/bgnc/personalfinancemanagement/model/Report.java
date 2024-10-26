package com.bgnc.personalfinancemanagement.model;

import com.bgnc.personalfinancemanagement.enums.ReportPeriod;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "report")
public class Report extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // This refers to the User entity

    @Enumerated(EnumType.STRING)
    private ReportPeriod reportPeriod;

    @Column(name = "total_income")
    private BigDecimal totalIncome;

    @Column(name = "total_expense")
    private BigDecimal totalExpense;

    @Column(name = "net_savings")
    private BigDecimal netSavings;
}
