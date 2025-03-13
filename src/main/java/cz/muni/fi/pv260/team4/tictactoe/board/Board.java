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
     * @param row the row number of the cell
     * @param column the column number of the cell
     * @return the character at the specified position on the board
     * @throws cz.muni.fi.pv260.team4.tictactoe.exception.BoardPositionOutOfBoundsException
     * if the row or column is outside the valid range
     */
    Character getCell(int row, int column);

    /**
     * Sets a character at a given position on the board.
     * <p>
     * If the specified row or column is out of bounds, an exception is thrown.
     * </p>
     *
     * @param row the row number of the cell
     * @param column the column number of the cell
     * @param cell the character to be set at the specified position
     * @throws cz.muni.fi.pv260.team4.tictactoe.exception.BoardPositionOutOfBoundsException
     * if the row or column is outside the valid range
     */
    void setCell(int row, int column, Character cell);

    /**
     * Retrieves the {@link ElementSupplier} associated with this board.
     * The element supplier provides the empty and player's elements (characters) for the board.
     *
     * @return the element supplier instance used by this board
     */
    ElementSupplier getElementSupplier();

    /**
     * Checks if the specified cell is empty based on the board's element supplier.
     *
     * @param row the row number of the cell
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

    default Iterator<Character> getHorizontalIterator(MatchConfiguration matchConfiguration, int column) {
        return new HorizontalBoardIterator(this, matchConfiguration, column);
    }

    default Iterator<Character> getVerticalIterator(MatchConfiguration matchConfiguration, int row) {
        return new VerticalBoardIterator(this, matchConfiguration, row);
    }

    default Iterator<Character> getDescendingDiagonalIterator(MatchConfiguration matchConfiguration, int row) {
        return new DescendingDiagonalBoardIterator(this, matchConfiguration, row);
    }

    default Iterator<Character> getAscendingDiagonalIterator(MatchConfiguration matchConfiguration, int row) {
        return new AscendingDiagonalBoardIterator(this, matchConfiguration, row);
    }
}
