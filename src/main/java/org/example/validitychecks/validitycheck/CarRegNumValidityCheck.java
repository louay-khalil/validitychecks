package org.example.validitychecks.validitycheck;

import java.util.regex.Pattern;

/**
 * This class implements the ValidityCheck interface and checks whether
 * the given data is a valid Swedish vehicle registration number.
 */
public class CarRegNumValidityCheck implements ValidityCheck {

    private static final String REG_PATTERN_EQUAL = "^[A-Ö]{3}\\d{3}$";
    private static final String REG_PATTERN_MIX = "^[A-Ö]{3}\\d{2}[A-Ö]$";

    /**
     * The check method checks the data according to the known patterns in Sweden,
     * first not null and length is.
     * It returns true if the data is a valid vehicle registration number,
     * otherwise it returns false.
     *
     * @param data
     * @return boolean
     */
    @Override
    public boolean check(String data) {
        if (data == null || data.length() != 6) {
            return false;
        } else {
            String upperCaseData = data.toUpperCase();
            if (!upperCaseData.matches(REG_PATTERN_EQUAL) && !upperCaseData.matches(REG_PATTERN_MIX)) {
                return false;
            }
        }
        return true;
    }


    /**
     * The getName method returns the name of the validity check,
     * which is the name of current class.
     * Using a variable to store the name of a type of validation check can make it easier
     * to change the name later if needed. On the other hand, using a direct string return
     * can ensure that the name is always correct and up-to-date in all places where it is used.
     *
     * using getClass().getSimpleName() is safer than hard-coding the class name into a
     * method like getName(). This is because if you change the name of the class in
     * code but don't update the name in getName(), getName() will return the old name,
     * while getClass().getSimpleName() will always return the current name of the class.
     * This way potential bugs and inaccuracies in the code can be avoided.
     *
     * @return String the name of the validity check
     */
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
