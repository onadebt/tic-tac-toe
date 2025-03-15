package cz.muni.fi.pv260.team4.tictactoe.validators;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ColumnBoundsValidatorTest {
    private static final long MAX_COLUMNS = 3L;

    @InjectMocks
    private ColumnBoundsValidator validator =  new ColumnBoundsValidator(MAX_COLUMNS);

    @Test
    void shouldAllowValidColumn() {
        assertTrue(validator.validate(1L).isEmpty());
    }

    @Test
    void shouldRejectNegativeColumn() {
        assertTrue(validator.validate(-1L).isPresent());
    }

    @Test
    void shouldRejectColumnEqualToMaxColumns() {
        assertTrue(validator.validate(MAX_COLUMNS).isPresent());
    }

    @Test
    void shouldRejectColumnAboveMaxColumns() {
        assertTrue(validator.validate(MAX_COLUMNS + 1).isPresent());
    }
}