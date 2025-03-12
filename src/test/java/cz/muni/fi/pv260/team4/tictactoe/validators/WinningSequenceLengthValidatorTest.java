package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.Const;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WinningSequenceLengthValidatorTest {
    private final long boardWidth = 5L;
    private final long boardHeight = 5L;

    @Test
    void shouldAllowAboveMinimalWinningSequenceLength() {
        WinningSequenceLengthValidator validator = new WinningSequenceLengthValidator(boardWidth, boardHeight);
        assertTrue(validator.validate(Const.MINIMAL_LENGTH_OF_WINNING_SEQUENCE).isEmpty());
    }

    @Test
    void shouldRejectBelowMinimalWinningSequenceLength() {
        WinningSequenceLengthValidator validator = new WinningSequenceLengthValidator(boardWidth, boardHeight);
        assertTrue(validator.validate(Const.MINIMAL_LENGTH_OF_WINNING_SEQUENCE - 1).isPresent());
    }

    @Test
    void shouldRejectAboveMaximalWinningSequenceLength() {
        WinningSequenceLengthValidator validator = new WinningSequenceLengthValidator(boardWidth, boardHeight);
        assertTrue(validator.validate(Math.min(boardWidth, boardHeight) + 1).isPresent());
    }
}
