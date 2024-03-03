package br.com.mtbassi.simpleexamplestrategypattern.controller;

import br.com.mtbassi.simpleexamplestrategypattern.domain.Request;
import br.com.mtbassi.simpleexamplestrategypattern.domain.Response;
import br.com.mtbassi.simpleexamplestrategypattern.domain.SeniorityEnum;
import br.com.mtbassi.simpleexamplestrategypattern.service.BonusService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
public class BonusControllerTest {

    private static final String URL = "/bonus";

    @InjectMocks
    private BonusController controller;

    @Mock
    private BonusService service;

    private MockMvc mockMvc;

    private Response response;

    private Request request;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .alwaysDo(MockMvcResultHandlers.print())
                .build();

        response = Response.builder()
                .bonusPercentage(BigDecimal.TEN)
                .updatedSalary(BigDecimal.valueOf(1000L))
                .previousSalary(BigDecimal.valueOf(1100L))
                .build();

        request = Request.builder()
                .salary(BigDecimal.valueOf(1000L))
                .seniority(SeniorityEnum.SENIOR)
                .build();
    }

    @Test
    @SneakyThrows
    void shouldReturnOkForValidRequest() {
        when(service.calculateSalaryBonus(any())).thenReturn(response);

        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getRequest(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.bonusPercentage", CoreMatchers.isA(Number.class)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.previousSalary", CoreMatchers.isA(Number.class)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.updatedSalary", CoreMatchers.isA(Number.class)))
                .andReturn();

        verify(service).calculateSalaryBonus(any());
        verifyNoMoreInteractions(service);
    }

    @Test
    @SneakyThrows
    void shouldReturnErrorForInvalidRequest() {
        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getRequest(Request.builder().build())))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andReturn();

        verifyNoInteractions(service);
    }

    @SneakyThrows
    private String getRequest(Object value) {
        return new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer()
                .withDefaultPrettyPrinter()
                .writeValueAsString(value);
    }

}
