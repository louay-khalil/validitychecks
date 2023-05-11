package org.example.validitychecks.validitycheck;

/**
 * This class implements the ValidityCheck interface and contains a single
 * method, "check", that checks whether the data passed in is null or not.
 * If the data is null, false is returned, otherwise true is returned.
 */
public class NotNullValidityCheck implements ValidityCheck{
    @Override
    public boolean check(String data) {
        if (data == null) {
            return false;
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
     * @return the name of the validity check
     */
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
