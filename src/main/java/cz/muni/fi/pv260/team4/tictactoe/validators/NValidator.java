package cz.muni.fi.pv260.team4.tictactoe.validators;

import java.util.Optional;

public final class NValidator implements InputValidator<Integer> {
    private final Integer maxN;
    private final String name;

    /**
     * Validates if N is valid and bigger than 0 and less than potential max.
     *
     * @param maximumNValue optional max value of N, null if unset
     * @param nameOfN meaning of the value
     */
    public NValidator(
            final Integer maximumNValue,
            final String nameOfN
    ) {
        this.maxN = maximumNValue;
        this.name = nameOfN;
    }

    @Override
    public Optional<String> validate(final Integer n) {
        if (n <= 0) {
            return Optional.of(name + " must at least 1");
        }
        if (maxN != null && n > maxN) {
            return Optional.of(name + " must be less than or equal to " + maxN);
        }
        return Optional.empty();
    }
}
