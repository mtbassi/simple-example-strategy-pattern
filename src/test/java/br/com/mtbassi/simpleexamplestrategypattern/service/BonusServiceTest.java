package br.com.mtbassi.simpleexamplestrategypattern.service;

import br.com.mtbassi.simpleexamplestrategypattern.domain.Request;
import br.com.mtbassi.simpleexamplestrategypattern.domain.SeniorityEnum;
import br.com.mtbassi.simpleexamplestrategypattern.factory.SeniorityFactory;
import br.com.mtbassi.simpleexamplestrategypattern.strategy.impl.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class BonusServiceTest {

    @InjectMocks
    private BonusService service;

    @Mock
    private SeniorityFactory seniorityFactory;

    @Test
    void calculateSeniorityJuniorShouldReturnSuccess(){
        when(seniorityFactory.defineStrategy(any(SeniorityEnum.class))).thenReturn(new SeniorityJuniorStrategy());
        var result = service.calculateSalaryBonus(Request.builder()
                .salary(BigDecimal.valueOf(100L))
                .seniority(SeniorityEnum.JUNIOR)
                .build());
        assertNotNull("Response is null.",result);
        assertEquals("Bonus differs from what is expected for junior seniority.",
                BigDecimal.valueOf(20L),
                result.getBonusPercentage());
        assertEquals("Previous salary differs from what is expected for junior seniority.",
                BigDecimal.valueOf(10000, 2),
                result.getPreviousSalary());
        assertEquals("New salary differs from what is expected for junior seniority.",
                BigDecimal.valueOf(12000, 2),
                result.getUpdatedSalary());
        verify(seniorityFactory).defineStrategy(any(SeniorityEnum.class));
        verifyNoMoreInteractions(seniorityFactory);
    }

    @Test
    void calculateSeniorityPlenoShouldReturnSuccess(){
        when(seniorityFactory.defineStrategy(any(SeniorityEnum.class))).thenReturn(new SeniorityPlenoStrategy());
        var result = service.calculateSalaryBonus(Request.builder()
                .salary(BigDecimal.valueOf(100L))
                .seniority(SeniorityEnum.PLENO)
                .build());
        assertNotNull("Response is null.",result);
        assertEquals("Bonus differs from what is expected for junior seniority.",
                BigDecimal.valueOf(30L),
                result.getBonusPercentage());
        assertEquals("Previous salary differs from what is expected for junior seniority.",
                BigDecimal.valueOf(10000, 2),
                result.getPreviousSalary());
        assertEquals("New salary differs from what is expected for junior seniority.",
                BigDecimal.valueOf(13000, 2),
                result.getUpdatedSalary());
        verify(seniorityFactory).defineStrategy(any(SeniorityEnum.class));
        verifyNoMoreInteractions(seniorityFactory);
    }

    @Test
    void calculateSenioritySeniorShouldReturnSuccess(){
        when(seniorityFactory.defineStrategy(any(SeniorityEnum.class))).thenReturn(new SenioritySeniorStrategy());
        var result = service.calculateSalaryBonus(Request.builder()
                .salary(BigDecimal.valueOf(100L))
                .seniority(SeniorityEnum.SENIOR)
                .build());
        assertNotNull("Response is null.",result);
        assertEquals("Bonus differs from what is expected for junior seniority.",
                BigDecimal.valueOf(40L),
                result.getBonusPercentage());
        assertEquals("Previous salary differs from what is expected for junior seniority.",
                BigDecimal.valueOf(10000, 2),
                result.getPreviousSalary());
        assertEquals("New salary differs from what is expected for junior seniority.",
                BigDecimal.valueOf(14000, 2),
                result.getUpdatedSalary());
        verify(seniorityFactory).defineStrategy(any(SeniorityEnum.class));
        verifyNoMoreInteractions(seniorityFactory);
    }

    @Test
    void calculateSeniorityTechLeadShouldReturnSuccess(){
        when(seniorityFactory.defineStrategy(any(SeniorityEnum.class))).thenReturn(new SeniorityTechLeadStrategy());
        var result = service.calculateSalaryBonus(Request.builder()
                .salary(BigDecimal.valueOf(100L))
                .seniority(SeniorityEnum.TECH_LEAD)
                .build());
        assertNotNull("Response is null.",result);
        assertEquals("Bonus differs from what is expected for junior seniority.",
                BigDecimal.valueOf(50L),
                result.getBonusPercentage());
        assertEquals("Previous salary differs from what is expected for junior seniority.",
                BigDecimal.valueOf(10000, 2),
                result.getPreviousSalary());
        assertEquals("New salary differs from what is expected for junior seniority.",
                BigDecimal.valueOf(15000, 2),
                result.getUpdatedSalary());
        verify(seniorityFactory).defineStrategy(any(SeniorityEnum.class));
        verifyNoMoreInteractions(seniorityFactory);
    }

    @Test
    void calculateSeniorityManagerShouldReturnSuccess(){
        when(seniorityFactory.defineStrategy(any(SeniorityEnum.class))).thenReturn(new SeniorityManagerStrategy());
        var result = service.calculateSalaryBonus(Request.builder()
                .salary(BigDecimal.valueOf(100L))
                .seniority(SeniorityEnum.MANAGER)
                .build());
        assertNotNull("Response is null.",result);
        assertEquals("Bonus differs from what is expected for junior seniority.",
                BigDecimal.valueOf(60L),
                result.getBonusPercentage());
        assertEquals("Previous salary differs from what is expected for junior seniority.",
                BigDecimal.valueOf(10000, 2),
                result.getPreviousSalary());
        assertEquals("New salary differs from what is expected for junior seniority.",
                BigDecimal.valueOf(16000, 2),
                result.getUpdatedSalary());
        verify(seniorityFactory).defineStrategy(any(SeniorityEnum.class));
        verifyNoMoreInteractions(seniorityFactory);
    }

}
