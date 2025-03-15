package cz.muni.fi.pv260.team4.tictactoe.iterator;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import lombok.AllArgsConstructor;

import java.util.Iterator;

/**
 * Abstract iterator for traversing a Tic-Tac-Toe board.
 * <p>
 * Provides base logic for iterating over the board while allowing subclasses to define
 * their own movement pattern using {@link #updatePosition()}.
 * </p>
 * <p>
 * This class should be extended by specific iterators, such as
 * {@code HorizontalBoardIterator}, {@code VerticalBoardIterator}, etc.
 * </p>
 */
@AllArgsConstructor
public abstract class BoardIterator implements Iterator<Character> {

    private final Board board;
    private final MatchConfiguration matchConfiguration;

    private int row;
    private int column;

    /**
     * Checks if the iterator has more elements within the board's boundaries.
     * <p>
     * Subclasses should ensure that {@code updatePosition()} modifies {@code row} and {@code column}
     * correctly to avoid out-of-bounds access.
     * </p>
     *
     * @return {@code true} if the iterator can continue, otherwise {@code false}
     */
    @Override
    public boolean hasNext() {
        return column >= 0 && row >= 0
                && column < matchConfiguration.getBoardWidth() && row < matchConfiguration.getBoardHeight();
    }

    /**
     * Retrieves the next character in the board sequence and updates the position.
     * <p>
     * This method fetches the current board cell, then calls {@link #updatePosition()} to advance.
     * </p>
     *
     * @return the next character in the iteration
     */
    @Override
    public Character next() {
        Character cell = board.getCell(row, column);

        updatePosition();

        return cell;
    }

    /**
     * Defines how the iterator should move to the next position.
     * <p>
     * Each subclass must implement this method to determine how the row and column values change.
     * </p>
     */
    public abstract void updatePosition();

    /**
     * Moves the iterator one column to the right.
     */
    public final void incrementColumn() {
        column++;
    }

    /**
     * Moves the iterator one row downward.
     */
    public final void incrementRow() {
        row++;
    }

    /**
     * Moves the iterator one row upward.
     */
    public final void decrementRow() {
        row--;
    }
}
