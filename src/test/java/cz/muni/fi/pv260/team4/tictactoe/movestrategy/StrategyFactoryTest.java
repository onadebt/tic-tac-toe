package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.GameState;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.mock;

class StrategyFactoryTest {
    private StrategyFactory strategyFactory;

    @Mock
    private MatchConfiguration configuration;

    @Mock
    private GameState gameState;

    @BeforeEach
    void setUp() {
        IOProvider ioProvider = mock(IOProvider.class);
        Random random = mock(Random.class);
        ElementSupplier elementSupplier = mock(ElementSupplier.class);
        strategyFactory = new StrategyFactory(ioProvider, configuration, gameState, random, elementSupplier);
    }

    @Test
    void testChooseSingleMoveStrategy() {
        MoveStrategy<?> strategy = strategyFactory.chooseStrategy(1);
        assertInstanceOf(SingleMoveStrategy.class, strategy);
    }

    //todo add test for invalid strategy
}
