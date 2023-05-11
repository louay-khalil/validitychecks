package org.example.validitychecks.validitycheck;

/**
 * It is usually not necessary to annotate every method and
 * property contained in an interface, as these only describe
 * the interface implemented by classes that implement the
 * interface. However, it can be useful to comment on the purpose of
 * the interface, its scope of use, and which classes are expected to implement it.
 *
 * ValidityChecks must be atomic
 * and independently of each other can be combined in ValidityChecker.
 */
public interface ValidityCheck {
    boolean check(String data);
    String getName();
}
