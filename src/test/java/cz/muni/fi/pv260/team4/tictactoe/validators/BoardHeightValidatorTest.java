package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.Const;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BoardHeightValidatorTest {

    @Test
    void shouldAllowAboveMinimalBoardHeight() {
        BoardHeightValidator validator = new BoardHeightValidator();
        assertTrue(validator.validate(Const.MINIMAL_BOARD_HEIGHT).isEmpty());
    }


    @Test
    void shouldRejectBelowMinimalBoardHeight() {
        BoardHeightValidator validator = new BoardHeightValidator();
        assertTrue(validator.validate(Const.MINIMAL_BOARD_HEIGHT - 1).isPresent());
    }
}
