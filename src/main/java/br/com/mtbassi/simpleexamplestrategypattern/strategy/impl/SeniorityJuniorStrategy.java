package br.com.mtbassi.simpleexamplestrategypattern.strategy.impl;

import br.com.mtbassi.simpleexamplestrategypattern.domain.Response;
import br.com.mtbassi.simpleexamplestrategypattern.domain.SeniorityEnum;
import br.com.mtbassi.simpleexamplestrategypattern.strategy.SeniorityStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SeniorityJuniorStrategy implements SeniorityStrategy {
    @Override
    public boolean matchBySeniority(SeniorityEnum seniorityEnum) {
        return SeniorityEnum.JUNIOR.equals(seniorityEnum);
    }

    @Override
    public Response calculateSalaryBonus(BigDecimal salary) {
        var salaryIncrease = salary.add(SeniorityEnum.JUNIOR.calculateSalaryBonus(salary));
        return Response.builder()
                .bonusPercentage(SeniorityEnum.calculateBonusPercentage(salary, salaryIncrease))
                .previousSalary(formatValue(salary))
                .updatedSalary(formatValue(salaryIncrease))
                .build();
    }
}
