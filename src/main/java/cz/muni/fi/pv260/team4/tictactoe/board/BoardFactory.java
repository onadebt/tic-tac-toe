package cz.muni.fi.pv260.team4.tictactoe.board;

import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;

public class BoardFactory {

    public Board createEmptyBoard(MatchConfiguration matchConfiguration, ElementSupplier elementSupplier) {
        return new ArrayBoard(elementSupplier, matchConfiguration, ArrayBoard.getEmptyGrid(matchConfiguration, elementSupplier));
    }

}
