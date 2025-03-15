package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.movestrategy.enums.MoveStrategyEnum;

import java.util.Optional;

public final class StrategyValidator implements InputValidator<Integer> {

    /**
     * Validates if the given value is a valid strategy number.
     *
     * @param value the value to be validated
     * @return an empty optional if the value is valid, otherwise an optional with an error message
     */
    @Override
    public Optional<String> validate(final Integer value) {
        if (value < 1 || value > MoveStrategyEnum.values().length) {
            return Optional.of("Invalid strategy number");
        }
        return Optional.empty();
    }
}
