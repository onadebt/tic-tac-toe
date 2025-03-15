package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.validators.ColumnBoundsValidator;
import cz.muni.fi.pv260.team4.tictactoe.validators.RowBoundsValidator;
import kotlin.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PositionGathererTest {
    @Mock
    private IOProvider ioProvider;

    @Mock
    private MatchConfiguration configuration;

    @InjectMocks
    private PositionGatherer positionGatherer;

    @BeforeEach
    void setUp() {
        positionGatherer = new PositionGatherer(ioProvider, configuration);
    }

    @Test
    void testGatherMoveParameters() {
        when(ioProvider.readInt(anyString(), any(RowBoundsValidator.class))).thenReturn(1);
        when(ioProvider.readInt(anyString(), any(ColumnBoundsValidator.class))).thenReturn(2);

        Pair<Integer, Integer> moveParameters = positionGatherer.gatherMoveParameters();

        assertEquals(1, moveParameters.component1());
        assertEquals(2, moveParameters.component2());
    }

    //todo: add more tests for wrong input
}
