package cz.muni.fi.pv260.team4.tictactoe.iterator;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;

public class HorizontalBoardIterator extends BoardIterator {
    public HorizontalBoardIterator(Board board, MatchConfiguration matchConfiguration, int row) {
        super(board, matchConfiguration, row, 0);
    }

    @Override
    public void updatePosition() {
        incrementColumn();
    }
}
