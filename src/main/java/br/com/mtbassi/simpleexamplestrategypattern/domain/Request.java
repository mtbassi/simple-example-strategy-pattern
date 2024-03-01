package br.com.mtbassi.simpleexamplestrategypattern.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Request {

    @Positive
    private BigDecimal salary;

    @NotNull
    private SeniorityEnum seniority;

}
