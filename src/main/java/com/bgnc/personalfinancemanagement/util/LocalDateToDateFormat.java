package com.bgnc.personalfinancemanagement.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;



@UtilityClass
public class LocalDateToDateFormat {


    public  Date fromLocalDateToDate(LocalDate localDate){

        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());


    }
}
