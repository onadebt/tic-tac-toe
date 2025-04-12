package cz.muni.fi.pv260.team4.tictactoe.validators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NValidatorTest {

    @Test
    void shouldRejectNegativeN() {
        NValidator validator = new NValidator(10, "");
        assertTrue(validator.validate(-1).isPresent());
    }

    @Test
    void shouldAllowZeroN() {
        NValidator validator = new NValidator(10, "");
        assertTrue(validator.validate(0).isPresent());
    }

    @Test
    void shouldAllowNEqualToMaxN() {
        NValidator validator = new NValidator(10, "");
        assertTrue(validator.validate(10).isEmpty());
    }

    @Test
    void shouldRejectNGreaterThanMaxN() {
        NValidator validator = new NValidator(10, "");
        assertTrue(validator.validate(11).isPresent());
    }

    @Test
    void shouldAllowNWithinBounds() {
        NValidator validator = new NValidator(10, "");
        assertFalse(validator.validate(5).isPresent());
    }

    @Test
    void shouldAllowNWhenMaxNIsNull() {
        NValidator validator = new NValidator(null, "");
        assertTrue(validator.validate(10).isEmpty());
    }
}
