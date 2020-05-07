package at.fhj.msd.exceptions;


import java.util.ArrayList;

/**
 *  Exception that will be thrown, if a Cocktail is mixed too strong.
 *
 * @author Michael Lamprecht
 * @version %I%, %G%
 * @since 1.1
 */
public class BlackoutException extends Exception {

    /**
     * Default Error Message for the BlackoutException class
     */
    public static final String ERROR_MESSAGE = "Sie haben zu viel getrunken und wurden Ohnmächtig!";

    /**
     * Creates a new instance of the class BlackoutException with the default message.
     */
    public BlackoutException() {
        super(ERROR_MESSAGE);
    }

    /**
     * Creates a new instance of the class BlackoutException with the provided error message
     *
     * @param message the error message of the exception
     */
    public BlackoutException(String message) {
        super(message);
    }
}
