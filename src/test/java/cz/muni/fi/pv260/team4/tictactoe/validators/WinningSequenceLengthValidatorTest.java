package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.Const;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WinningSequenceLengthValidatorTest {
    private static final int BOARD_WIDTH = 5;
    private static final int BOARD_HEIGHT = 5;
    private WinningSequenceLengthValidator validator;

    @BeforeEach
    void setUp() {
        validator = new WinningSequenceLengthValidator(BOARD_WIDTH, BOARD_HEIGHT);
    }

    @Test
    void shouldAllowAboveMinimalWinningSequenceLength() {
        assertTrue(validator.validate(Const.MINIMAL_LENGTH_OF_WINNING_SEQUENCE).isEmpty());
    }

    @Test
    void shouldRejectBelowMinimalWinningSequenceLength() {
        assertTrue(validator.validate(Const.MINIMAL_LENGTH_OF_WINNING_SEQUENCE - 1).isPresent());
    }

    @Test
    void shouldRejectAboveMaximalWinningSequenceLength() {
        assertTrue(validator.validate(Math.min(BOARD_WIDTH, BOARD_HEIGHT) + 1).isPresent());
    }
}
