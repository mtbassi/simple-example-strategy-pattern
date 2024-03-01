package br.com.mtbassi.simpleexamplestrategypattern.strategy.impl;

import br.com.mtbassi.simpleexamplestrategypattern.domain.Response;
import br.com.mtbassi.simpleexamplestrategypattern.domain.SeniorityEnum;
import br.com.mtbassi.simpleexamplestrategypattern.strategy.SeniorityStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class SeniorityJuniorStrategy implements SeniorityStrategy {
    @Override
    public boolean matchBySeniority(SeniorityEnum seniorityEnum) {
        return SeniorityEnum.JUNIOR.equals(seniorityEnum);
    }

    @Override
    public Response calculateSalaryBonus(BigDecimal salary) {
        var salaryIncrease = salary.add(SeniorityEnum.JUNIOR.calculateSalaryBonus(salary)).setScale(2, RoundingMode.HALF_EVEN);
        return Response.builder()
                .bonusPercentage(SeniorityEnum.calculateBonusPercentage(salary, salaryIncrease))
                .previousSalary(salary.setScale(2, RoundingMode.HALF_EVEN))
                .updatedSalary(salaryIncrease)
                .build();
    }
}
