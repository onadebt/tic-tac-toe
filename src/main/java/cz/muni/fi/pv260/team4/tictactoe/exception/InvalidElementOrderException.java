package cz.muni.fi.pv260.team4.tictactoe.exception;

/**
 * Exception thrown when an invalid element order is provided.
 */
public class InvalidElementOrderException extends RuntimeException {
    /**
     * Constructs an InvalidElementOrderException with the specified detail message.
     *
     * @param order The invalid order that was provided.
     * @param maxOrder The maximum allowed order.
     */
    public InvalidElementOrderException(int order, int maxOrder) {
        super("Invalid element order: %d. Valid range is 0 to %d.".formatted(order, maxOrder));
    }
}
