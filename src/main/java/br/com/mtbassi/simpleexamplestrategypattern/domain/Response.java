package br.com.mtbassi.simpleexamplestrategypattern.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Response {

    private BigDecimal bonusPercentage;

    private BigDecimal previousSalary;

    private BigDecimal updatedSalary;
}
