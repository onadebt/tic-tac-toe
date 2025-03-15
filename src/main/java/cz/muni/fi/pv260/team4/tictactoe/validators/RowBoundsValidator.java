package cz.muni.fi.pv260.team4.tictactoe.validators;

import java.util.Optional;

public final class RowBoundsValidator implements InputValidator<Long> {
    private final long maxRows;

    /**
     * Constructor for RowBoundsValidator.
     *
     * @param maxRowsNumber maximum number of rows
     */
    public RowBoundsValidator(final long maxRowsNumber) {
        this.maxRows = maxRowsNumber;
    }

    @Override
    public Optional<String> validate(final Long row) {
        if (row < 1 || row >= maxRows) {
            return Optional.of("Row must be between 1 and " + (maxRows));
        }
        return Optional.empty();
    }
}
