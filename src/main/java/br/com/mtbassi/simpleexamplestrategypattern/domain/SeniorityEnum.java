package br.com.mtbassi.simpleexamplestrategypattern.domain;

import java.math.BigDecimal;

public enum SeniorityEnum {

    JUNIOR {
        @Override
        public BigDecimal calculatesSalaryAdjustment(BigDecimal currentWage) {
            return currentWage.add(currentWage.multiply(BigDecimal.valueOf(0.2)));
        }
    },
    PLENO {
        @Override
        public BigDecimal calculatesSalaryAdjustment(BigDecimal currentWage) {
            return currentWage.add(currentWage.multiply(BigDecimal.valueOf(0.3)));
        }
    },
    SENIOR {
        @Override
        public BigDecimal calculatesSalaryAdjustment(BigDecimal currentWage) {
            return currentWage.add(currentWage.multiply(BigDecimal.valueOf(0.4)));
        }
    },
    TECHNICAL_LIDER {
        @Override
        public BigDecimal calculatesSalaryAdjustment(BigDecimal currentWage) {
            return currentWage.add(currentWage.multiply(BigDecimal.valueOf(0.5)));
        }
    },
    MANAGER {
        @Override
        public BigDecimal calculatesSalaryAdjustment(BigDecimal currentWage) {
            return currentWage.add(currentWage.multiply(BigDecimal.valueOf(0.6)));
        }
    };

    public abstract BigDecimal calculatesSalaryAdjustment(BigDecimal currentWage);

}
