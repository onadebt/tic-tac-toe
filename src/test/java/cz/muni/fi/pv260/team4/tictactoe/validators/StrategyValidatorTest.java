package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.movestrategy.enums.MoveStrategyEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class StrategyValidatorTest {

    @InjectMocks
    private StrategyValidator validator;

    @Test
    void shouldAllowValidStrategy() {
        assertTrue(validator.validate(1L).isEmpty());
        assertTrue(validator.validate((long) MoveStrategyEnum.values().length).isEmpty());
    }

    @Test
    void shouldRejectNegativeStrategy() {
        assertTrue(validator.validate(-1L).isPresent());
    }

    @Test
    void shouldRejectZeroStrategy() {
        assertTrue(validator.validate(0L).isPresent());
    }

    @Test
    void shouldRejectStrategyAboveMax() {
        assertTrue(validator.validate((long) MoveStrategyEnum.values().length + 1).isPresent());
    }
}
