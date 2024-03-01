package br.com.mtbassi.simpleexamplestrategypattern.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Response {

    private BigDecimal bonusPercentage;
    private BigDecimal previousSalary;
    private BigDecimal updatedSalary;
}
