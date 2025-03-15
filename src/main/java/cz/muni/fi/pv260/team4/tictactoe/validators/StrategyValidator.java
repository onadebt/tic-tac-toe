package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.movestrategy.StrategyFactory;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public final class StrategyValidator implements InputValidator<Integer> {

    private final StrategyFactory strategyFactory;

    /**
     * Validates if the given value is a valid strategy number.
     *
     * @param value the value to be validated
     * @return an empty optional if the value is valid, otherwise an optional with an error message
     */
    @Override
    public Optional<String> validate(final Integer value) {
        if (value < 1 || value > strategyFactory.getMoveStrategyList().size()) {
            return Optional.of("Invalid move type, please choose another one");
        }
        return Optional.empty();
    }
}
