package cz.muni.fi.pv260.team4.tictactoe.validators;

import java.util.Optional;

public final class ColumnBoundsValidator implements InputValidator<Long> {
    private final long maxColumns;

    /**
     * Constructor for ColumnBoundsValidator.
     *
     * @param maxColumnsNumber maximum number of columns
     */
    public ColumnBoundsValidator(final long maxColumnsNumber) {
        this.maxColumns = maxColumnsNumber;
    }

    @Override
    public Optional<String> validate(final Long column) {
        if (column < 1 || column >= maxColumns) {
            return Optional.of("Column must be between 0 and " + (maxColumns));
        }
        return Optional.empty();
    }
}
