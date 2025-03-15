package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.validators.ColumnBoundsValidator;
import cz.muni.fi.pv260.team4.tictactoe.validators.RowBoundsValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PositionGathererTest {
    @Mock
    private IOProvider ioProvider;

    @InjectMocks
    private PositionGatherer positionGatherer;

    @BeforeEach
    void setUp() {
        positionGatherer = new PositionGatherer(ioProvider);
    }

    @Test
    void testGatherMoveParameters() {
        when(ioProvider.readLong(anyString(), any(RowBoundsValidator.class))).thenReturn(1L);
        when(ioProvider.readLong(anyString(), any(ColumnBoundsValidator.class))).thenReturn(2L);

        List<Long> moveParameters = positionGatherer.gatherMoveParameters();

        assertEquals(1L, moveParameters.get(0));
        assertEquals(2L, moveParameters.get(1));
    }

    //todo: add more tests for wrong input
}
