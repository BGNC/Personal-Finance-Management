package com.bgnc.personalfinancemanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;


import static jakarta.persistence.GenerationType.*;
import static org.springframework.security.web.access.AuthorizationManagerWebInvocationPrivilegeEvaluator.HttpServletRequestTransformer.IDENTITY;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createTime;
}
