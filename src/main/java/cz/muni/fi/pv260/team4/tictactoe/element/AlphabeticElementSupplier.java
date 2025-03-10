package cz.muni.fi.pv260.team4.tictactoe.element;

/**
 * An {@link ElementSupplier} implementation that provides alphabetic characters
 * based on an ordinal index. It starts from the lowercase letter 'a' and increments
 * based on the provided order.
 * <p>
 * If the order exceeds the number of available lowercase letters (26),
 * it will continue into non-alphabetic Unicode characters.
 * </p>
 */
public final class AlphabeticElementSupplier implements ElementSupplier {

    /**
     * Constructs a new {@code AlphabeticElementSupplier}.
     */
    public AlphabeticElementSupplier() {
        // Default constructor
    }

    /**
     * Returns a character corresponding to the given order.
     * <p>
     * The first order (0) corresponds to 'a', the next (1) to 'b', and so on.
     * If the order exceeds 25, it continues into non-alphabetic Unicode characters.
     * </p>
     *
     * @param order the index of the character to retrieve (0 for 'a', 1 for 'b', etc.)
     * @return the character corresponding to the given order
     */
    @Override
    public Character getElement(final int order) {
        return (char) ('a' + order);
    }

    /**
     * Returns the designated empty element.
     * <p>
     * The empty element is represented by a space character (' ').
     * </p>
     *
     * @return the empty element (' ')
     */
    @Override
    public Character getEmptyElement() {
        return ' ';
    }
}
