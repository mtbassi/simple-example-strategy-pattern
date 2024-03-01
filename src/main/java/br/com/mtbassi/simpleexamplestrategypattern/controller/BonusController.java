package br.com.mtbassi.simpleexamplestrategypattern.controller;

import br.com.mtbassi.simpleexamplestrategypattern.domain.Request;
import br.com.mtbassi.simpleexamplestrategypattern.domain.Response;
import br.com.mtbassi.simpleexamplestrategypattern.service.BonusService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bonus")
@RequiredArgsConstructor
public class BonusController {

    private final BonusService bonusService;

    @PostMapping
    public ResponseEntity<Response> calculateSalaryBonus(@RequestBody @Valid Request data){
        return ResponseEntity.ok().body(bonusService.calculateSalaryBonus(data));
    }
}
