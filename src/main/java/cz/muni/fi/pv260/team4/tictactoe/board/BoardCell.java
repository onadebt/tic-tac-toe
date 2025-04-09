package cz.muni.fi.pv260.team4.tictactoe.board;

/**
 * Represents a cell on the board.
 *
 * @param row row index of the cell, 0-based
 * @param column column index of the cell, 0-based
 * @param player character of the player occupying the cell
 */
public record BoardCell(int row, int column, char player) {
}
