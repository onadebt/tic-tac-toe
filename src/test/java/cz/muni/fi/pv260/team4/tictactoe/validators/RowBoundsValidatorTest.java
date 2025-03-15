package cz.muni.fi.pv260.team4.tictactoe.validators;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class RowBoundsValidatorTest {
    private static final long MAX_ROWS = 3L;

    @InjectMocks
    private RowBoundsValidator validator = new RowBoundsValidator(MAX_ROWS);

    @Test
    void shouldAllowValidRow() {
        assertTrue(validator.validate(1L).isEmpty());
    }

    @Test
    void shouldRejectNegativeRow() {
        assertTrue(validator.validate(-1L).isPresent());
    }

    @Test
    void shouldRejectRowEqualToMaxRows() {
        assertTrue(validator.validate(MAX_ROWS).isPresent());
    }

    @Test
    void shouldRejectRowAboveMaxRows() {
        assertTrue(validator.validate(MAX_ROWS + 1).isPresent());
    }
}
