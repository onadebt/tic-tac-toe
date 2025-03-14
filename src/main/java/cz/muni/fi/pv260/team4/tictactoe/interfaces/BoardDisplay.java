package cz.muni.fi.pv260.team4.tictactoe.interfaces;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;

public interface BoardDisplay {
    /**
     * Displays the current state of the Tic Tac Toe board. The board is dynamically generated based
     * on the provided match configuration, supporting an arbitrary number of rows and columns. The
     * method includes labeled column identifiers (A, B, C, ...) and row numbers (1, 2, 3, ...),
     * similar to a chessboard. Each cell is separated by vertical dividers, and horizontal dividers
     * are placed between rows.
     *
     * @param board Board to display.
     */
    void displayBoard(Board board);
}
