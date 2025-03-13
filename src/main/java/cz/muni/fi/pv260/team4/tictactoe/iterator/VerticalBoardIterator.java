package cz.muni.fi.pv260.team4.tictactoe.iterator;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;

public final class VerticalBoardIterator extends BoardIterator {
    /**
     * Constructs a {@code VerticalBoardIterator} to iterate over a specific column of the board.
     * <p>
     * This iterator moves from top to bottom within the given column and retrieves board elements
     * using the {@link Board#getCell(int, int)} method.
     * </p>
     *
     * @param board the Tic-Tac-Toe board to iterate over
     * @param matchConfiguration the configuration defining match rules (e.g., winning sequence length)
     * @param column the column index to be iterated (zero-based)
     */
    public VerticalBoardIterator(
            final Board board, final MatchConfiguration matchConfiguration, final int column) {
        super(board, matchConfiguration, 0, column);
    }

    @Override
    public void updatePosition() {
        incrementRow();
    }
}
