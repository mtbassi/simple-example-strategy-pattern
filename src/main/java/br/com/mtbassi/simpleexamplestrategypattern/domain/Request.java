package br.com.mtbassi.simpleexamplestrategypattern.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Request {

    @Positive
    private BigDecimal salary;

    @NotNull
    private SeniorityEnum seniority;

}
