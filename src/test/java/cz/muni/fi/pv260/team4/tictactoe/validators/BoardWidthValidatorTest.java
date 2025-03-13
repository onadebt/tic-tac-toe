package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.Const;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BoardWidthValidatorTest {

    @Test
    void shouldAllowAboveMinimalBoardWidth() {
        BoardWidthValidator validator = new BoardWidthValidator();
        assertTrue(validator.validate(Const.MINIMAL_BOARD_WIDTH).isEmpty());
    }

    @Test
    void shouldRejectBelowMinimalBoardWidth() {
        BoardWidthValidator validator = new BoardWidthValidator();
        assertTrue(validator.validate(Const.MINIMAL_BOARD_WIDTH - 1).isPresent());
    }

    @Test
    void shouldRejectAboveMaximalBoardWidth() {
        BoardWidthValidator validator = new BoardWidthValidator();
        assertTrue(validator.validate(Const.MAXIMAL_BOARD_WIDTH + 1).isPresent());
    }

    @Test
    void shouldAllowBelowMaximalBoardWidth() {
        BoardWidthValidator validator = new BoardWidthValidator();
        assertTrue(validator.validate(Const.MAXIMAL_BOARD_WIDTH - 1).isEmpty());
    }
}
