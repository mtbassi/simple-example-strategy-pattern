package br.com.mtbassi.simpleexamplestrategypattern.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum SeniorityEnum {

    JUNIOR {
        @Override
        public BigDecimal calculateSalaryBonus(BigDecimal currentWage) {
            return currentWage.multiply(BigDecimal.valueOf(0.2));
        }
    },
    PLENO {
        @Override
        public BigDecimal calculateSalaryBonus(BigDecimal currentWage) {
            return currentWage.multiply(BigDecimal.valueOf(0.3));
        }
    },
    SENIOR {
        @Override
        public BigDecimal calculateSalaryBonus(BigDecimal currentWage) {
            return currentWage.multiply(BigDecimal.valueOf(0.4));
        }
    },
    TECH_LEAD {
        @Override
        public BigDecimal calculateSalaryBonus(BigDecimal currentWage) {
            return currentWage.multiply(BigDecimal.valueOf(0.5));
        }
    },
    MANAGER {
        @Override
        public BigDecimal calculateSalaryBonus(BigDecimal currentWage) {
            return currentWage.multiply(BigDecimal.valueOf(0.6));
        }
    };

    public abstract BigDecimal calculateSalaryBonus(BigDecimal currentWage);

    public static BigDecimal calculateBonusPercentage(BigDecimal currentWage, BigDecimal salaryIncrease) {
        return salaryIncrease.subtract(currentWage)
                .divide(currentWage, 2, RoundingMode.HALF_EVEN)
                .multiply(BigDecimal.valueOf(100))
                .setScale(0, RoundingMode.HALF_EVEN);
    }

}
