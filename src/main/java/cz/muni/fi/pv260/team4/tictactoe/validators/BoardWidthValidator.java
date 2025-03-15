package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.Const;

import java.util.Optional;

public final class BoardWidthValidator implements InputValidator<Integer> {

    /**
     * Validates if the value given during setup is a valid width of the board.
     *
     * @param widthOfTheBoard the width of the board to be validated
     * @return an empty optional if the value is valid, otherwise an optional with an error message
     */
    @Override
    public Optional<String> validate(final Integer widthOfTheBoard) {
        if (widthOfTheBoard < Const.MINIMAL_BOARD_WIDTH) {
            return Optional.of("Minimum width of the board is " + Const.MINIMAL_BOARD_WIDTH);
        }

        if (widthOfTheBoard > Const.MAXIMAL_BOARD_WIDTH) {
            return Optional.of("Maximum width of the board is " + Const.MAXIMAL_BOARD_WIDTH);
        }

        return Optional.empty();
    }
}
