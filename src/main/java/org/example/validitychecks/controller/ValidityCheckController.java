package org.example.validitychecks.controller;

import org.example.validitychecks.validitycheck.CarRegNumValidityCheck;
import org.example.validitychecks.validitycheck.NotNullValidityCheck;
import org.example.validitychecks.validitycheck.SINValidityCheck;
import org.example.validitychecks.validitycheck.ValidityChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;


@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@RestController
@RequestMapping("/validity-check")
public class ValidityCheckController {
    private String errorMessage = "Error 404 - Missing input data";

    @GetMapping("/car-reg-num")
    public ResponseEntity<String> emptyCarData() {
        return ResponseEntity.status(404).body(errorMessage);
    }
    @GetMapping("/sin")
    public ResponseEntity<String> emptySINData() {
        return ResponseEntity.status(404).body(errorMessage);
    }
    @GetMapping("/notnull")
    public ResponseEntity<String> emptyData() {
        return ResponseEntity.ok("Failed");
    }

    @GetMapping("/car-reg-num/{data}")
    public ResponseEntity<String> checkCarRegNumValidity(@PathVariable String data) {
        try {
            boolean checkResultat = ValidityChecker.checkValidity(data.toUpperCase(), new CarRegNumValidityCheck());
            return checkValidity(checkResultat);
        } catch(Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/sin/{data}")
    public ResponseEntity<String> checkSINValidity(@PathVariable String data) {
        try {
            boolean checkResultat = ValidityChecker.checkValidity(data, new SINValidityCheck());
            return checkValidity(checkResultat);
        } catch(Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/notnull/{data}")
    public ResponseEntity<String> checkNotNullValidity(@PathVariable String data) {
        try {
            boolean checkResultat = ValidityChecker.checkValidity(data, new NotNullValidityCheck());
            return checkValidity(checkResultat);
        } catch(Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    private ResponseEntity<String> checkValidity(boolean value)  {
        if(!value) {
            return ResponseEntity.ok("Failed");
        }
        return ResponseEntity.ok("Passed");
    }
}
