package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;

public interface MoveStrategy {

    /**
     * Execute move.
     *
     * @param board  board
     * @param player player
     */
    void executeMove(Board board, Character player);

    /**
     * Get move parameter gatherer.
     *
     * @return move parameter gatherer
     */
    MoveParameterGatherer getMoveParameterGatherer();
}
