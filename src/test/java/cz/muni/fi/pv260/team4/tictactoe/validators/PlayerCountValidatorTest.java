package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.Const;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayerCountValidatorTest {
    @Mock
    private ElementSupplier elementSupplier;

    @InjectMocks
    private PlayerCountValidator validator;

    @Test
    void shouldAllowAboveMinimalPlayerCount() {
        when(elementSupplier.getMaxOrder()).thenReturn(10);
        assertTrue(validator.validate(Const.MINIMAL_PLAYER_COUNT + 1).isEmpty());
    }

    @Test
    void shouldRejectBelowMinimalPlayerCount() {
        when(elementSupplier.getMaxOrder()).thenReturn(10);
        assertTrue(validator.validate(Const.MINIMAL_PLAYER_COUNT - 1).isPresent());
    }

    @Test
    void shouldRejectAboveMaximalPlayerCount() {
        when(elementSupplier.getMaxOrder()).thenReturn(2);
        assertTrue(validator.validate(3).isPresent());
    }
}
