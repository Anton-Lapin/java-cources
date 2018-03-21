package ru.lesson.lessons.calculate;

/**
 * Special exception class
 * @author Anton Lapin
 * @since March 21, 2018
 */
public class UserException extends Exception {

    /**
     * Constructor of this class
     * @param message
     */
    public UserException(final String message) {
        super(message);
    }
}
