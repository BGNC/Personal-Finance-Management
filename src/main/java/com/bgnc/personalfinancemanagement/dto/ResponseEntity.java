package com.bgnc.personalfinancemanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class ResponseEntity {

    private Long id;
    private LocalDate createTime;
}
