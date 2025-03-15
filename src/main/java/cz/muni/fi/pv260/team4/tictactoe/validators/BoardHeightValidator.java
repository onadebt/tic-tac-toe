package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.Const;

import java.util.Optional;

public final class BoardHeightValidator implements InputValidator<Integer> {

    /**
     * Validates if the value given during setup is a valid height of the board.
     *
     * @param heightOfTheBoard the height of the board to be validated
     * @return an empty optional if the value is valid, otherwise an optional with an error message
     */
    @Override
    public Optional<String> validate(final Integer heightOfTheBoard) {
        if (heightOfTheBoard < Const.MINIMAL_BOARD_HEIGHT) {
            return Optional.of("Minimum height of the board is " + Const.MINIMAL_BOARD_HEIGHT);
        }

        if (heightOfTheBoard > Const.MAXIMAL_BOARD_HEIGHT) {
            return Optional.of("Maximum height of the board is " + Const.MAXIMAL_BOARD_HEIGHT);
        }

        return Optional.empty();
    }
}
