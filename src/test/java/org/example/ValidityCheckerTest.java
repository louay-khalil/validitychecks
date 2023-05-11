package org.example;


import org.example.validitychecks.validitycheck.CarRegNumValidityCheck;
import org.example.validitychecks.validitycheck.NotNullValidityCheck;
import org.example.validitychecks.validitycheck.SINValidityCheck;
import org.example.validitychecks.validitycheck.ValidityChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidityCheckerTest {
    @Test
    public void testNotNullWithNull() {
        assertFalse(ValidityChecker.checkValidity(null, new NotNullValidityCheck()));
    }
    public void testNotNullWithEmpty() {
        assertTrue(ValidityChecker.checkValidity("", new NotNullValidityCheck()));
    }
    public void testNotNullWithNoNull() {
        assertTrue(ValidityChecker.checkValidity("string", new NotNullValidityCheck()));
    }

    @Test
    public void testPersonnummerValidityCheck() {
        assertFalse(ValidityChecker.checkValidity("19930821-1234", new SINValidityCheck()));
        assertTrue(ValidityChecker.checkValidity("19930821-1235", new SINValidityCheck()));
        assertFalse(ValidityChecker.checkValidity("58ghkl56ghjkgh6", new SINValidityCheck()));
        assertFalse(ValidityChecker.checkValidity("19930821-", new SINValidityCheck()));
        assertFalse(ValidityChecker.checkValidity("-1235", new SINValidityCheck()));
        assertFalse(ValidityChecker.checkValidity("", new SINValidityCheck()));
        assertFalse(ValidityChecker.checkValidity(null, new SINValidityCheck()));
    }

    @Test
    public void testBilRegistreringNrValidityCheck() {
        assertTrue(ValidityChecker.checkValidity("ABC123", new CarRegNumValidityCheck()));
    }
}
