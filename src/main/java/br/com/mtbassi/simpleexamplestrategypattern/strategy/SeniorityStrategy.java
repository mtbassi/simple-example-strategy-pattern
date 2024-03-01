package br.com.mtbassi.simpleexamplestrategypattern.strategy;

import br.com.mtbassi.simpleexamplestrategypattern.domain.Response;
import br.com.mtbassi.simpleexamplestrategypattern.domain.SeniorityEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface SeniorityStrategy {

    boolean matchBySeniority(SeniorityEnum seniorityEnum);

    Response calculateSalaryBonus(BigDecimal salary);

    default BigDecimal formatValue(BigDecimal value){
        return value.setScale(2, RoundingMode.HALF_EVEN);
    }
}
