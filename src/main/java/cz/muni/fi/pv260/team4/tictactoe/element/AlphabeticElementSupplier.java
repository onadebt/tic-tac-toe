package cz.muni.fi.pv260.team4.tictactoe.element;

import cz.muni.fi.pv260.team4.tictactoe.exception.InvalidElementOrderException;

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
     * Returns the character corresponding to the given order.
     * <p>
     * The first order (0) corresponds to 'a', the next (1) to 'b', and so on up to 'z'.
     * If the provided order is out of the valid range (0 to {@link #getMaxOrder()} - 1),
     * an {@link InvalidElementOrderException} is thrown.
     * </p>
     *
     * @param order the index of the character to retrieve (0 for 'a', 1 for 'b', etc.)
     * @return the character corresponding to the given order
     * @throws InvalidElementOrderException if the order is negative or exceeds the maximum allowed order
     */
    @Override
    public Character getElement(final int order) {
        if (order < 0 || order >= getMaxOrder()) {
            throw new InvalidElementOrderException(order, getMaxOrder());
        }
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

    /**
     * Here we allow all letters from a to z.
     * @return Order of the last possible element. In this case, 'z'
     */
    @Override
    public int getMaxOrder() {
        return 'z' - 'a';
    }
}
