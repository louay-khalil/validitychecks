package org.example.validitychecks.validitycheck;

/**
 * This class implements the ValidityCheck interface to check if a
 * given string represents a valid Swedish personal identity number.
 * SIN stands for "Swedish Identity Number".
 */
public class SINValidityCheck implements ValidityCheck {

    /**
     * This method checks if the given string represents a
     * valid Swedish personal identity number.
     * @param data the string to be checked
     * @return true if the string represents a valid Swedish
     * personal identity number, false otherwise
     */
    @Override
    public boolean check(String data) {
        if (data == null) {
            return false;
        } else if (data.length() < 10 || data.length() > 13) {
            return false;
        }

        // "trimData", which returns the clean social
        // security number in string format.
        // No requirement for checking if the date is a real date
        // the Swedish social security number algorithm will return false if given a false date
        String trimmedData = trimData(data);
        try {
            int[] digits = new int[9];
            // tries to convert each digit of the social security number
            // to an integer and store it in an array of length 9.
            for (int i = 0; i < 9; i++) {
                digits[i] = Integer.parseInt(trimmedData.substring(i, i + 1));
            }

            //The last digit of the social security number is stored in a separate variable, "checkDigit".
            int checkDigit = Integer.parseInt(trimmedData.substring(9));

            // "controlDigit", which performs a check by using the Swedish social security number algorithm. If valid,
            // "controlDigit" returns true, otherwise it returns false.
            return controlDigit(digits, checkDigit);
        } catch (NumberFormatException e) {
            // If a NumberFormatException occurs when the string is converted to an integer,
            // the code returns false because the social security number is not valid.
            return false;
        }
    }

    /**
     * This method returns the name of the validity check.
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
     * @return the name of the validity check
     */
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    private String trimData(String data) {
        int length = data.length();
        StringBuilder sb = new StringBuilder(data);
        switch (length) {
            case 11:
                sb.deleteCharAt(7);
                data = sb.toString();
                break;
            case 12:
                data = data.substring(2, 12);
                break;
            case 13:
                sb.deleteCharAt(8);
                data = sb.toString();
                data = data.substring(2, 12);
                break;
        }
        return data;
    }

    private boolean controlDigit(int[] digits, int checkDigit) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = digits[i];
            if (i % 2 == 0) {
                digit *= 2;
                if (digit >= 10) {
                    digit = digit % 10 + digit / 10;
                }
            }
            sum += digit;
        }
        int controlDigit = 10 - (sum % 10);
        if (controlDigit == 10) {
            controlDigit = 0;
        }
        if (controlDigit != checkDigit) {
            return false;
        } else
            return true;
    }
}