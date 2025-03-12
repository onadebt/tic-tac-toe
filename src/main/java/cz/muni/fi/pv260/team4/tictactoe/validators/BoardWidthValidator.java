package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.Const;

import java.util.Optional;

public final class BoardWidthValidator implements InputValidator<Long> {
    @Override
    public Optional<String> validate(final Long widthOfTheBoard) {
        if (widthOfTheBoard < Const.MINIMAL_BOARD_WIDTH) {
            return Optional.of("Minimum width of the board is " + Const.MINIMAL_BOARD_WIDTH);
        }

        if (widthOfTheBoard > Const.MAXIMAL_BOARD_WIDTH) {
            return Optional.of("Maximum width of the board is " + Const.MAXIMAL_BOARD_WIDTH);
        }

        return Optional.empty();
    }
}
