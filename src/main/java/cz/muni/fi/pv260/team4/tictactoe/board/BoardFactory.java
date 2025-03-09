package cz.muni.fi.pv260.team4.tictactoe.board;

import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;

public final class BoardFactory {

    public BoardFactory() {

    }

    public Board createEmptyBoard(final MatchConfiguration matchConfiguration, final ElementSupplier elementSupplier) {
        return new ArrayBoard(
                elementSupplier,
                matchConfiguration,
                ArrayBoard.getEmptyGrid(matchConfiguration, elementSupplier));
    }

}
