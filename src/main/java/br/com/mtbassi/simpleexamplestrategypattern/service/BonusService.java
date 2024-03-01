package br.com.mtbassi.simpleexamplestrategypattern.service;

import br.com.mtbassi.simpleexamplestrategypattern.domain.Request;
import br.com.mtbassi.simpleexamplestrategypattern.domain.Response;
import br.com.mtbassi.simpleexamplestrategypattern.factory.SeniorityFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BonusService {

    private final SeniorityFactory seniorityFactory;

    public Response calculateSalaryBonus(Request data){
        var strategy = seniorityFactory.defineStrategy(data.getSeniority());
        return strategy.calculateSalaryBonus(data.getSalary());
    }
}
