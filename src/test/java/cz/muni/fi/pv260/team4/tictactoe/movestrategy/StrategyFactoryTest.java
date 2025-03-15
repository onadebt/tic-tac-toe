package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.movestrategy.enums.MoveStrategyEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class StrategyFactoryTest {
    private IOProvider ioProvider;
    private StrategyFactory strategyFactory;

    @BeforeEach
    void setUp() {
        ioProvider = mock(IOProvider.class);
        strategyFactory = new StrategyFactory(ioProvider);
    }

    @Test
    void testChooseSingleMoveStrategy() {
        MoveStrategy strategy = strategyFactory.chooseStrategy(MoveStrategyEnum.SINGLE_MOVE);
        assertInstanceOf(SingleMoveStrategy.class, strategy);
    }

    @Test
    void testChooseInvalidStrategy() {
        try {
            strategyFactory.chooseStrategy(MoveStrategyEnum.RANDOM_INVALID_MOVE);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Invalid move type"));
        }
    }
}
