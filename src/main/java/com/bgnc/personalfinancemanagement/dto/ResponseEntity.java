package com.bgnc.personalfinancemanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
public class ResponseEntity {

    private Long id;
    private Date createTime;
}
