package cz.muni.fi.pv260.team4.tictactoe.board;

import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;

public interface Board {

    Character getCell(int row, int column);

    void setCell(int row, int column, Character cell);

    ElementSupplier getElementSupplier();

    default boolean isCellEmpty(int row, int column) {
        return getElementSupplier().getEmptyElement().equals(getCell(row, column));
    }

    Board createCopy();
}
