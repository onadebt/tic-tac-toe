package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.GameState;

public interface MoveStrategy<T> {

    /**
     * Executes the move on the board.
     *
     * @param player player who is making the move
     * @param gameState state of the game
     */
    void executeMove(GameState gameState, Character player);

    /**
     * Returns MoveParameterGatherer, which contains all needed parameters for the specific move strategy.
     *
     * @return MoveParameterGatherer
     */
    MoveParameterGatherer<T> getMoveParameterGatherer();
}
