package org.example.validitychecks.validitycheck;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.logging.Logger;

/**
 * ValidityChecker configurable with different ValidityChecks that
 * can be performed on data in some order. The result of a check through ValidityChecker
 * must be that the input passes the validity check or not. In addition,
 * validity checks that are not passed are logged.
 * This code defines a ValidityChecker class that contains a logger.
 */
public class ValidityChecker {
    private static Logger logger = Logger.getLogger("ValidityChecker");

    /**
     * ValidityChecks must be atomic
     * and independently of each other can be combined in ValidityChecker.
     *
     * @param data
     * @param validityCheck
     * @return boolean
     */
    public static boolean checkValidity(String data, ValidityCheck validityCheck) {
        boolean checkResultat = validityCheck.check(data);
        if(!checkResultat) {
            logger.warning( "ValidityCheck " + validityCheck.getName()+ " failed for data: "  + data);
        }
        return checkResultat;
    }
}