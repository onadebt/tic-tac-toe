package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.Const;

import java.util.Optional;

public final class WinningSequenceLengthValidator implements InputValidator<Long> {
    @Override
    public Optional<String> validate(final Long lengthOfTheWinningSequence) {
        if (lengthOfTheWinningSequence < Const.MINIMAL_LENGTH_OF_WINNING_SEQUENCE) {
            return Optional.of("Length of the winning sequence has to be at least 3");
        }

        return Optional.empty();
    }
}
