package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.GameState;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.validators.RollbackValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MoveCountGatherer implements MoveParameterGatherer<Integer> {
    private final IOProvider ioProvider;
    private final GameState gameState;

    /**
     * Asks user for row and column of the move.
     */
    @Override
    public Integer gatherMoveParameters() {
        return this.ioProvider.readInt(
                "Enter number of moves to rollback: ", new RollbackValidator(gameState.getMoveHistory().size())
        );
    }
}
