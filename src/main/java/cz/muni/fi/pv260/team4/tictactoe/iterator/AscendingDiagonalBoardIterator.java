package cz.muni.fi.pv260.team4.tictactoe.iterator;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;

public final class AscendingDiagonalBoardIterator extends BoardIterator {
    /**
     * Constructs an {@code AscendingDiagonalBoardIterator} to traverse the board diagonally
     * from bottom-left to top-right.
     * <p>
     * This iterator moves diagonally across the board, starting at the specified row and
     * moving in an upward-right direction. It retrieves board elements using
     * the {@link Board#getCell(int, int)} method.
     * </p>
     *
     * @param board              the Tic-Tac-Toe board to iterate over
     * @param matchConfiguration the configuration defining match rules (e.g., winning sequence length)
     * @param row                the row index where the diagonal traversal starts (zero-based)
     */
    public AscendingDiagonalBoardIterator(
            final Board board, final MatchConfiguration matchConfiguration, final int row) {
        super(board, matchConfiguration, row, 0);
    }

    @Override
    public void updatePosition() {
        decrementRow();
        incrementColumn();
    }
}
