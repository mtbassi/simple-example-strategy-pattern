package br.com.mtbassi.simpleexamplestrategypattern.strategy;

import br.com.mtbassi.simpleexamplestrategypattern.domain.Response;
import br.com.mtbassi.simpleexamplestrategypattern.domain.SeniorityEnum;

import java.math.BigDecimal;

public interface SeniorityStrategy {

    boolean matchBySeniority(SeniorityEnum seniorityEnum);

    Response calculateSalaryBonus(BigDecimal salary);
}
