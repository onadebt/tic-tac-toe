package cz.muni.fi.pv260.team4.tictactoe.evaluator;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class TestBoard implements Board {

    private char[][] board;
    private ElementSupplier elementSupplier;

    @Override
    public Character getCell(final int row, final int column) {
        return board[row][column];
    }

    @Override
    public void setCell(final int row, final int column, final Character cell) {
        board[row][column] = cell;
    }

    @Override
    public ElementSupplier getElementSupplier() {
        return elementSupplier;
    }

    @Override
    public Board createCopy() {
        throw new UnsupportedOperationException("Test Board does not support clone");
    }
}
