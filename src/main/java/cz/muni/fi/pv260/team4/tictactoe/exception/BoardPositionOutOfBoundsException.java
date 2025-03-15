package cz.muni.fi.pv260.team4.tictactoe.exception;

/**
 * Exception thrown when attempting to access a board cell with out-of-bounds coordinates.
 */
public class BoardPositionOutOfBoundsException extends RuntimeException {
    /**
     * Constructs a BoardIndexOutOfBoundsException with a detailed message.
     *
     * @param row    The row index that was accessed.
     * @param column The column index that was accessed.
     * @param maxRow The maximum valid row index.
     * @param maxCol The maximum valid column index.
     */
    public BoardPositionOutOfBoundsException(final int row, final int column, final int maxRow, final int maxCol) {
        super("Invalid board cell access: (%d, %d). Valid range is (0-%d, 0-%d).".formatted(
                row, column, maxRow - 1, maxCol - 1));
    }
}
