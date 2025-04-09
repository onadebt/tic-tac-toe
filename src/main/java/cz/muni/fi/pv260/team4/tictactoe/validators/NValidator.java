package cz.muni.fi.pv260.team4.tictactoe.validators;

import java.util.Optional;

public final class NValidator implements InputValidator<Integer> {
    private final Integer maxN;

    /**
     * Validates if N is valid and bigger than 0 and less than potential max.
     *
     * @param maximumNValue optional max value of N, null if unset
     */
    public NValidator(final Integer maximumNValue) {
        this.maxN = maximumNValue;
    }

    @Override
    public Optional<String> validate(final Integer n) {
        if (n < 0) {
            return Optional.of("N must be greater than 0");
        }
        if (maxN != null && n > maxN) {
            return Optional.of("N must be less than or equal to " + maxN);
        }
        return Optional.empty();
    }
}
