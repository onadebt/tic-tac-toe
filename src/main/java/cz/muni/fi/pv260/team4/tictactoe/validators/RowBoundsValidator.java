package cz.muni.fi.pv260.team4.tictactoe.validators;

import java.util.Optional;

public final class RowBoundsValidator implements InputValidator<Integer> {
    private final int maxRows;

    /**
     * Validates if the potential move is within the bounds of the board's rows.
     *
     * @param maxRowsNumber maximum number of rows
     */
    public RowBoundsValidator(final Integer maxRowsNumber) {
        this.maxRows = maxRowsNumber;
    }

    @Override
    public Optional<String> validate(final Integer row) {
        if (row < 1 || row > maxRows) {
            return Optional.of("Row must be between 1 and " + (maxRows));
        }
        return Optional.empty();
    }
}
