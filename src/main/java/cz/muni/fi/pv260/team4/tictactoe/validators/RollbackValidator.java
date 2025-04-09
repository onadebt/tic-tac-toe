package cz.muni.fi.pv260.team4.tictactoe.validators;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public final class RollbackValidator implements InputValidator<Integer> {
    private final int historySize;

    /**
     * Validate the number of players.
     *
     * @return Optional containing error message if validation fails, otherwise empty
     */
    @Override
    public Optional<String> validate(final Integer numberOfMoves) {
        int maxMoves = historySize / 2;

        if (numberOfMoves < 1) {
            return Optional.of("Rollback requires at least one move");
        }

        if (numberOfMoves > maxMoves) {
            return Optional.of("Cannot rollback more than %d moves".formatted(maxMoves));
        }

        return Optional.empty();
    }
}
