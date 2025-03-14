package cz.muni.fi.pv260.team4.tictactoe.board;

import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.iterator.AscendingDiagonalBoardIterator;
import cz.muni.fi.pv260.team4.tictactoe.iterator.DescendingDiagonalBoardIterator;
import cz.muni.fi.pv260.team4.tictactoe.iterator.HorizontalBoardIterator;
import cz.muni.fi.pv260.team4.tictactoe.iterator.VerticalBoardIterator;

import java.util.Iterator;

public interface Board {

    /**
     * Obtains the character at a given position from the board.
     * <p>
     * If the specified row or column is out of bounds, an exception is thrown.
     * </p>
     *
     * @param row    the row number of the cell
     * @param column the column number of the cell
     * @return the character at the specified position on the board
     * @throws cz.muni.fi.pv260.team4.tictactoe.exception.BoardPositionOutOfBoundsException if the
     *                                                                                      row or column is outside the
     *                                                                                      valid range
     */
    Character getCell(int row, int column);

    /**
     * Sets a character at a given position on the board.
     * <p>
     * If the specified row or column is out of bounds, an exception is thrown.
     * </p>
     *
     * @param row    the row number of the cell
     * @param column the column number of the cell
     * @param cell   the character to be set at the specified position
     * @throws cz.muni.fi.pv260.team4.tictactoe.exception.BoardPositionOutOfBoundsException if the
     *                                                                                      row or column is outside the
     *                                                                                      valid range
     */
    void setCell(int row, int column, Character cell);

    /**
     * Retrieves the {@link ElementSupplier} associated with this board. The element supplier
     * provides the empty and player's elements (characters) for the board.
     *
     * @return the element supplier instance used by this board
     */
    ElementSupplier getElementSupplier();

    /**
     * Checks if the specified cell is empty based on the board's element supplier.
     *
     * @param row    the row number of the cell
     * @param column the column number of the cell
     * @return {@code true} if the cell is empty, {@code false} otherwise
     */
    default boolean isCellEmpty(int row, int column) {
        return getElementSupplier().getEmptyElement().equals(getCell(row, column));
    }

    /**
     * Creates a copy of the current board instance.
     *
     * @return a new {@code Board} instance that is a copy of the current board
     */
    Board createCopy();

    /**
     * Creates a horizontal iterator that traverses a specific row from left to right.
     * <p>
     * The iterator moves through all columns in the given row, returning each cell in sequence.
     * </p>
     *
     * @param matchConfiguration the configuration defining board dimensions and winning conditions
     * @param row the row index to iterate over (zero-based)
     * @return an {@link Iterator} that iterates horizontally across the specified row
     */
    default Iterator<Character> getHorizontalIterator(MatchConfiguration matchConfiguration, int row) {
        return new HorizontalBoardIterator(this, matchConfiguration, row);
    }

    /**
     * Creates a vertical iterator that traverses a specific column from top to bottom.
     * <p>
     * The iterator moves through all rows in the given column, returning each cell in sequence.
     * </p>
     *
     * @param matchConfiguration the configuration defining board dimensions and winning conditions
     * @param column the column index to iterate over (zero-based)
     * @return an {@link Iterator} that iterates vertically down the specified column
     */
    default Iterator<Character> getVerticalIterator(MatchConfiguration matchConfiguration, int column) {
        return new VerticalBoardIterator(this, matchConfiguration, column);
    }

    /**
     * Creates a diagonal iterator that traverses from top-left to bottom-right.
     * <p>
     * The iterator moves diagonally downward and rightward, starting at the specified row.
     * </p>
     *
     * @param matchConfiguration the configuration defining board dimensions and winning conditions
     * @param row the row index where the diagonal traversal starts (zero-based)
     * @return an {@link Iterator} that iterates diagonally downward
     */
    default Iterator<Character> getDescendingDiagonalIterator(MatchConfiguration matchConfiguration, int row) {
        return new DescendingDiagonalBoardIterator(this, matchConfiguration, row);
    }

    /**
     * Creates a diagonal iterator that traverses from bottom-left to top-right.
     * <p>
     * The iterator moves diagonally upward and rightward, starting at the specified row.
     * </p>
     *
     * @param matchConfiguration the configuration defining board dimensions and winning conditions
     * @param row the row index where the diagonal traversal starts (zero-based)
     * @return an {@link Iterator} that iterates diagonally upward
     */
    default Iterator<Character> getAscendingDiagonalIterator(MatchConfiguration matchConfiguration, int row) {
        return new AscendingDiagonalBoardIterator(this, matchConfiguration, row);
    }

    /**
     * Retrieves the match configuration associated with the board.
     *
     * @return the {@link MatchConfiguration} used by this board.
     */
    MatchConfiguration getMatchConfiguration();
}
