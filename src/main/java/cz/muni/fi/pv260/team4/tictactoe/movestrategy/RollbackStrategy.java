package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.GameState;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class RollbackStrategy implements MoveStrategy<Integer> {
    private final IOProvider ioProvider;
    private final GameState gameState;

    /**
     * Execute the move.
     *
     * @param player Character
     */
    @Override
    public void executeMove(final GameState gameState, final Character player) {
        int rollbackAmount = getMoveParameterGatherer().gatherMoveParameters();

        // +1 because we also have to revert the current rollback move
        for (int i = 0; i < rollbackAmount + 1; i++) {
            gameState.getMoveHistory().pop();
        }
    }

    /**
     * Get the move parameter gatherer.
     *
     * @return MoveParameterGatherer
     */
    @Override
    public MoveParameterGatherer<Integer> getMoveParameterGatherer() {
        return new MoveCountGatherer(ioProvider, gameState);
    }

    @Override
    public String toString() {
        return "Rollback";
    }
}
