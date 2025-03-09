package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.Const;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerCountValidatorTest {

    @Test
    void shouldAllowAboveMinimalPlayerCount() {
        PlayerCountValidator validator = new PlayerCountValidator();
        assertTrue(validator.validate(Const.MINIMAL_PLAYER_COUNT).isEmpty());
    }


    @Test
    void shouldRejectBelowMinimalPlayerCount() {
        PlayerCountValidator validator = new PlayerCountValidator();
        assertTrue(validator.validate(Const.MINIMAL_PLAYER_COUNT - 1).isPresent());
    }
}
