package cz.muni.fi.pv260.team4.tictactoe.validators;

import java.util.Optional;

public final class ColumnBoundsValidator implements InputValidator<Integer> {
    private final long maxColumns;

    /**
     * Validates if the potential move is within the bounds of the board's columns.
     *
     * @param maxColumnsNumber maximum number of columns
     */
    public ColumnBoundsValidator(final int maxColumnsNumber) {
        this.maxColumns = maxColumnsNumber;
    }

    @Override
    public Optional<String> validate(final Integer column) {
        if (column < 1 || column > maxColumns) {
            return Optional.of("Column must be between 0 and " + (maxColumns));
        }
        return Optional.empty();
    }
}
