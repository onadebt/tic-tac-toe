package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.movestrategy.enums.MoveStrategyEnum;
import kotlin.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class StrategyFactoryTest {
    private IOProvider ioProvider;
    private StrategyFactory strategyFactory;

    @Mock
    private MatchConfiguration configuration;

    @BeforeEach
    void setUp() {
        ioProvider = mock(IOProvider.class);
        strategyFactory = new StrategyFactory(ioProvider, configuration);
    }

    @Test
    void testChooseSingleMoveStrategy() {
        MoveStrategy<Pair<Integer, Integer>> strategy = strategyFactory.chooseStrategy(MoveStrategyEnum.SINGLE_MOVE);
        assertInstanceOf(SingleMoveStrategy.class, strategy);
    }

    //todo add test for invalid strategy
}
