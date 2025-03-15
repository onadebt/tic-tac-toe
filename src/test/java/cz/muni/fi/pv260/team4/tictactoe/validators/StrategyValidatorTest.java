package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.movestrategy.MoveStrategy;
import cz.muni.fi.pv260.team4.tictactoe.movestrategy.SingleMoveStrategy;
import cz.muni.fi.pv260.team4.tictactoe.movestrategy.StrategyFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class StrategyValidatorTest {

    @Mock
    private StrategyFactory strategyFactory;

    @InjectMocks
    private StrategyValidator validator;

    @Mock
    private IOProvider ioProvider;

    @Mock
    private MatchConfiguration configuration;

    @BeforeEach
    void setUp() {
        List<MoveStrategy<?>> moveStrategyList = new ArrayList<>();
        moveStrategyList.add(new SingleMoveStrategy(ioProvider, configuration));
        lenient().when(strategyFactory.getMoveStrategyList()).thenReturn(moveStrategyList);
    }

    @Test
    void shouldAllowValidStrategy() {
        assertTrue(validator.validate(1).isEmpty());
        assertTrue(validator.validate(strategyFactory.getMoveStrategyList().size()).isEmpty());
    }

    @Test
    void shouldRejectNegativeStrategy() {
        assertTrue(validator.validate(-1).isPresent());
    }

    @Test
    void shouldRejectZeroStrategy() {
        assertTrue(validator.validate(0).isPresent());
    }

    @Test
    void shouldRejectStrategyAboveMax() {
        assertTrue(validator.validate(strategyFactory.getMoveStrategyList().size() + 1).isPresent());
    }
}
