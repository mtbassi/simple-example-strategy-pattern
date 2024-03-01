package br.com.mtbassi.simpleexamplestrategypattern.factory;

import br.com.mtbassi.simpleexamplestrategypattern.domain.SeniorityEnum;
import br.com.mtbassi.simpleexamplestrategypattern.strategy.SeniorityStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SeniorityFactory {

    private final List<SeniorityStrategy> seniorityStrategies;

    public SeniorityStrategy defineStrategy(SeniorityEnum seniorityEnum){
        return seniorityStrategies.stream()
                .filter(strategy -> strategy.matchBySeniority(seniorityEnum))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
