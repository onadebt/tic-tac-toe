package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.validators.ColumnBoundsValidator;
import cz.muni.fi.pv260.team4.tictactoe.validators.RowBoundsValidator;
import kotlin.Pair;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class SingleMoveStrategy implements MoveStrategy<Pair<Integer, Integer>> {
    private final IOProvider ioProvider;
    private final MatchConfiguration configuration;

    /**
     * Execute the move.
     *
     * @param board  Board
     * @param player Character
     */
    @Override
    public void executeMove(final Board board, final Character player) {
        var position = askRowColumn(board);

        board.setCell(position.getFirst() - 1, position.getSecond() - 1, player);
    }

    private Pair<Integer, Integer> askRowColumn(final Board board) {
        int row = askRow();
        int col = askColumn();

        while (!board.isCellEmpty(row - 1, col - 1)) {
            ioProvider.writeError("This cell is already taken. Please choose another one.");
            ioProvider.writeError("");
            row = askRow();
            col = askColumn();
        }

        return new Pair<>(row, col);
    }

    private int askColumn() {
        return this.ioProvider.readInt(
                "Enter column: ", new ColumnBoundsValidator(configuration.getBoardWidth())
        );
    }

    private int askRow() {
        return this.ioProvider.readInt(
                "Enter row: ", new RowBoundsValidator(configuration.getBoardHeight())
        );
    }

    /**
     * Get the move parameter gatherer.
     *
     * @return MoveParameterGatherer
     */
    @Override
    public MoveParameterGatherer<Pair<Integer, Integer>> getMoveParameterGatherer() {
        return null;
    }

    @Override
    public String toString() {
        return "Single Move";
    }
}
