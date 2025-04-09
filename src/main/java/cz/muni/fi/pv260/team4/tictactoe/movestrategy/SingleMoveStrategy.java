package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.GameState;
import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import kotlin.Pair;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class SingleMoveStrategy implements MoveStrategy<Pair<Integer, Integer>> {
    private final IOProvider ioProvider;
    private final MatchConfiguration configuration;

    /**
     * Execute the move.
     *
     * @param player Character
     */
    @Override
    public void executeMove(final GameState gameState, final Character player) {
        final Board board = gameState.getCurrentBoard();
        Pair<Integer, Integer> positions = getMoveParameterGatherer().gatherMoveParameters();
        int row = positions.component1();
        int col = positions.component2();

        while (!board.isCellEmpty(row - 1, col - 1)) {
            System.err.println("This cell is already taken. Please choose another one.");
            System.err.println();
            positions = getMoveParameterGatherer().gatherMoveParameters();
            row = positions.component1();
            col = positions.component2();
        }

        board.setCell(row - 1, col - 1, player);
    }

    /**
     * Get the move parameter gatherer.
     *
     * @return MoveParameterGatherer
     */
    @Override
    public MoveParameterGatherer<Pair<Integer, Integer>> getMoveParameterGatherer() {
        return new PositionGatherer(ioProvider, configuration);
    }

    @Override
    public String toString() {
        return "Single Move";
    }
}
