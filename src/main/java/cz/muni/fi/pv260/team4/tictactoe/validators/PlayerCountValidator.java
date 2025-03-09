package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.Const;
import cz.muni.fi.pv260.team4.tictactoe.util.InputValidator;

import java.util.Optional;

public final class PlayerCountValidator implements InputValidator<Long> {
    @Override
    public Optional<String> validate(final Long numOfPlayers) {
        if (numOfPlayers < Const.MINIMAL_PLAYER_COUNT) {
            return Optional.of("There have to be at least 2 players");
        }

        return Optional.empty();
    }
}
