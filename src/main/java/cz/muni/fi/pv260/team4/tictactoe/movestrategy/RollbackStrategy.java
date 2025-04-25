package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.GameState;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.validators.RollbackValidator;
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
    public void executeMove(final GameState ignored, final Character player) {
        int rollbackAmount = askRollbackAmount();

        // +1 because we also have to revert the current rollback move
        for (int i = 0; i < rollbackAmount + 1; i++) {
            gameState.getMoveHistory().pop();
        }
    }

    private int askRollbackAmount() {
        return this.ioProvider.readInt(
                "Enter number of moves to rollback", new RollbackValidator(gameState.getMoveHistory().size())
        );
    }

    @Override
    public String toString() {
        return "Rollback";
    }
}
