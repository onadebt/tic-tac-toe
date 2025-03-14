package cz.muni.fi.pv260.team4.tictactoe.infrastructure;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.BoardDisplay;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class TerminalBoardDisplay implements BoardDisplay {
    private final IOProvider ioProvider;

    @Override
    public void displayBoard(final Board board) {
        StringBuilder boardRepresentation = new StringBuilder();

        long rows = board.getMatchConfiguration().boardHeight();
        long cols = board.getMatchConfiguration().boardWidth();
        int rowIdentifierLength = String.valueOf(rows).length() + 1;

        appendColumnIdentifiers(boardRepresentation, cols, rowIdentifierLength);
        appendBoardRows(boardRepresentation, board, rows, cols, rowIdentifierLength);

        ioProvider.writeString(boardRepresentation.toString());
    }

    private void appendColumnIdentifiers(final StringBuilder boardRepresentation,
                                         final long cols, final int rowIdentifierLength) {
        boardRepresentation.append(" ".repeat(rowIdentifierLength)).append(" "); // Space for row identifiers

        for (int col = 0; col < cols; col++) {
            boardRepresentation.append((char) ('A' + col));
            if (col < cols - 1) {
                boardRepresentation.append("   ");
            }
        }
        boardRepresentation.append("\n");
    }

    private void appendBoardRows(final StringBuilder boardRepresentation, final Board board,
                                 final long rows, final long cols, final int rowIdentifierLength) {
        for (int row = 0; row < rows; row++) {
            boardRepresentation.append(row + 1)
                    .append(" ".repeat(rowIdentifierLength - String.valueOf(row + 1).length())); // Row identifier
            for (int col = 0; col < cols; col++) { // Row cells
                boardRepresentation.append(" ").append(board.getCell(row, col));
                if (col < cols - 1) {
                    boardRepresentation.append(" |");
                }
            }
            boardRepresentation.append("\n");

            if (row < rows - 1) {
                appendRowSeparator(boardRepresentation, cols, rowIdentifierLength);
            }
        }
    }

    private void appendRowSeparator(final StringBuilder boardRepresentation,
                                    final long cols, final int rowIdentifierLength) {
        boardRepresentation.append(" ".repeat(rowIdentifierLength));
        for (int i = 0; i < cols; i++) {
            boardRepresentation.append("---");
            if (i < cols - 1) {
                boardRepresentation.append("+");
            }
        }
        boardRepresentation.append("\n");
    }
}
