package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;

public interface MoveStrategy<T> {

    /**
     * Executes the move on the board.
     *
     * @param board  board to be modified
     * @param player player who is making the move
     */
    void executeMove(Board board, Character player);

    /**
     * Returns MoveParameterGatherer, which contains all needed parameters for the specific move strategy.
     *
     * @return MoveParameterGatherer
     */
    MoveParameterGatherer<T> getMoveParameterGatherer();
}
