package cz.muni.fi.pv260.team4.tictactoe.validators;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RollbackValidatorTest {
    private static final int MOVE_COUNT = 11;
    private static final int MAX_ALLOWED = (MOVE_COUNT / 2);
    @InjectMocks
    private final RollbackValidator validator = new RollbackValidator(MOVE_COUNT);

    @Test
    void shouldRejectNegativeMoveCount() {
        assertTrue(validator.validate(-1).isPresent());
    }

    @Test
    void shouldRejectZeroMoveCount() {
        assertTrue(validator.validate(0).isPresent());
    }

    @Test
    void shouldAllowValidMoveCount() {
        for (int moveCount = 1; moveCount <= MAX_ALLOWED; moveCount++) {
            assertFalse(validator.validate(moveCount).isPresent());
        }
    }

    @Test
    void shouldRejectTooHighMoveCount() {
        assertTrue(validator.validate(MAX_ALLOWED + 1).isPresent());
    }
}
