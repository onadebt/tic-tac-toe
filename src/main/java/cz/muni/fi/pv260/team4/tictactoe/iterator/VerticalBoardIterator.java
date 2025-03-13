package cz.muni.fi.pv260.team4.tictactoe.iterator;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;

public class VerticalBoardIterator extends BoardIterator {
    public VerticalBoardIterator(Board board, MatchConfiguration matchConfiguration, int column) {
        super(board, matchConfiguration, 0, column);
    }

    @Override
    public void updatePosition() {
        incrementRow();
    }
}
