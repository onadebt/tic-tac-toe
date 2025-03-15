package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.validators.ColumnBoundsValidator;
import cz.muni.fi.pv260.team4.tictactoe.validators.RowBoundsValidator;

import java.util.List;

public class PositionGatherer implements MoveParameterGatherer {
    private final IOProvider ioProvider;
    private static final long MAX_COLUMNS = 30;
    private static final long MAX_ROWS = 30; // todo ?board should contain info about its size?


    /**
     * Constructor for PositionGatherer.
     *
     * @param provider IOProvider
     */
    public PositionGatherer(final IOProvider provider) {
        this.ioProvider = provider;
    }

    /**
     * Asks user for row and column of the move.
     *
     * @return List of two Longs, first is row, second is column
     */
    @Override
    public List<Long> gatherMoveParameters() {
        long row = this.ioProvider.readLong("Enter row: ", new RowBoundsValidator(MAX_ROWS));
        long column = this.ioProvider.readLong("Enter column: ", new ColumnBoundsValidator(MAX_COLUMNS));
        return List.of(row, column);
    }
}
