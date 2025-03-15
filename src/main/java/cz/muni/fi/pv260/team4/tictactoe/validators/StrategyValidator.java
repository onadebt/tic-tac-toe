package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.movestrategy.enums.MoveStrategyEnum;

import java.util.Optional;

public final class StrategyValidator implements InputValidator<Long> {

    @Override
    public Optional<String> validate(final Long value) {
        if (value < 1 || value > MoveStrategyEnum.values().length) {
            return Optional.of("Invalid strategy number");
        }
        return Optional.empty();
    }
}
