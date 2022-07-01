package com.eid.temperature.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v2/stats/")
public class StatsController {

    private final StatsService statsService;

    @Autowired
    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("compute")
    private ResponseEntity<Long> compute(@Valid @RequestBody Readings readings) {

        if (!isSemanticallyValid(readings)) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Long maxIncrement = statsService.computeMaxIncrement(readings);
        return ResponseEntity.ok(maxIncrement);

    }

    private boolean isSemanticallyValid(Readings readings) {
        return new ReadingsValidator().isValid(readings);
    }


}
