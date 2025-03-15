package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public final class SingleMoveStrategy implements MoveStrategy {
    private final IOProvider ioProvider;

    /**
     * Execute the move.
     *
     * @param board  Board
     * @param player Character
     */
    @Override
    public void executeMove(final Board board, final Character player) {
        List<Long> positions = getMoveParameterGatherer().gatherMoveParameters();
        int row = positions.get(0).intValue() - 1;
        int col = positions.get(1).intValue() - 1;

        if (!board.isCellEmpty(row, col)) {
            ioProvider.writeString("This cell is already taken. Please choose another one.\n");
            executeMove(board, player);
            return;
        }

        board.setCell(row, col, player);
    }

    /**
     * Get the move parameter gatherer.
     *
     * @return MoveParameterGatherer
     */
    @Override
    public MoveParameterGatherer getMoveParameterGatherer() {
        return new PositionGatherer(ioProvider);
    }
}
