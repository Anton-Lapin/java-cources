package ru.lesson.lessons.calculate;

/**
 * This interface contains abstract methods for calculatable classes
 * @author Anton Lapin
 * @version date March 16, 2018
 */

public interface Calculatable {

    void sum(String[] args);

    void difference(String[] args);

    void multiplicate(String[] args);

    void division(String[] args) throws UserException;

    void exponent(String[] args);

    float getResult();

    void clearResult();
}
