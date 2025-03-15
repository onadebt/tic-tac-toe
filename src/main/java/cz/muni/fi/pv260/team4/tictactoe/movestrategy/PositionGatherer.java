package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.validators.ColumnBoundsValidator;
import cz.muni.fi.pv260.team4.tictactoe.validators.RowBoundsValidator;
import kotlin.Pair;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PositionGatherer implements MoveParameterGatherer<Pair<Integer, Integer>> {
    private final IOProvider ioProvider;
    private final MatchConfiguration configuration;

    /**
     * Asks user for row and column of the move.
     *
     * @return List of two Longs, first is row, second is column
     */
    @Override
    public Pair<Integer, Integer> gatherMoveParameters() {
        int row = this.ioProvider.readInt(
                "Enter row: ", new RowBoundsValidator(configuration.getBoardHeight())
        );

        int column = this.ioProvider.readInt(
                "Enter column: ", new ColumnBoundsValidator(configuration.getBoardWidth())
        );
        return new Pair<>(row, column);
    }
}
