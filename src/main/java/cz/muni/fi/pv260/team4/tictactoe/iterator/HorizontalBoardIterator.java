package cz.muni.fi.pv260.team4.tictactoe.iterator;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;

public final class HorizontalBoardIterator extends BoardIterator {
    /**
     * Constructs a {@code HorizontalBoardIterator} to iterate over a specific row of the board.
     * <p>
     * This iterator moves from left to right within the given row and retrieves board elements
     * using the {@link Board#getCell(int, int)} method.
     * </p>
     *
     * @param board the Tic-Tac-Toe board to iterate over
     * @param matchConfiguration the configuration defining match rules (e.g., winning sequence length)
     * @param row the row index to be iterated (zero-based)
     */
    public HorizontalBoardIterator(
            final Board board, final MatchConfiguration matchConfiguration, final int row) {
        super(board, matchConfiguration, row, 0);
    }

    @Override
    public void updatePosition() {
        incrementColumn();
    }
}
