package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.Const;

import java.util.Optional;

public final class BoardHeightValidator implements InputValidator<Long> {
    @Override
    public Optional<String> validate(final Long heightOfTheBoard) {
        if (heightOfTheBoard < Const.MINIMAL_BOARD_HEIGHT) {
            return Optional.of("Minimum height of the board is 3");
        }

        return Optional.empty();
    }
}
