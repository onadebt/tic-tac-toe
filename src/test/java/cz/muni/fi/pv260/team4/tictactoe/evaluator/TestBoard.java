package cz.muni.fi.pv260.team4.tictactoe.evaluator;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TestBoard implements Board {

    char[][] board;
    private ElementSupplier elementSupplier;

    @Override
    public Character getCell(int row, int column) {
        return board[row][column];
    }

    @Override
    public void setCell(int row, int column, Character cell) {
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
