package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.GameState;
import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.board.BoardCell;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.validators.NValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.IntStream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class SwapNMoveStrategyTest {

    @Mock
    private IOProvider ioProvider;

    @Mock
    private java.util.Random random;

    @Mock
    private ElementSupplier elementSupplier;

    @InjectMocks
    private SwapNMoveStrategy swapNMoveStrategy;

    @Mock
    private Board board;

    @Mock
    private GameState gameState;

    @Mock
    private MatchConfiguration matchConfiguration;

    @Mock
    private BoardCell cell1;

    @Mock
    private BoardCell cell2;

    @BeforeEach
    void setup() {
        when(board.getMatchConfiguration()).thenReturn(matchConfiguration);
        when(matchConfiguration.getPlayerCount()).thenReturn(2);

        when(elementSupplier.getElement(0)).thenReturn('X');
        when(elementSupplier.getElement(1)).thenReturn('O');

        when(gameState.getCurrentBoard()).thenReturn(board);
    }

    @Test
    void testExecuteMoveSingleSwap() {
        when(cell1.row()).thenReturn(0);
        when(cell1.column()).thenReturn(0);
        when(cell1.player()).thenReturn('X');

        when(board.getFilledCells()).thenReturn(List.of(cell1));
        when(ioProvider.readInt(anyString(), any(NValidator.class))).thenReturn(1);

        when(random.ints(eq(0), eq(1))).thenReturn(IntStream.of(0));
        when(random.ints(eq(0), eq(2))).thenReturn(IntStream.of(1));

        swapNMoveStrategy.executeMove(gameState, 'X');

        verify(board).setCell(0, 0, 'O');
    }

    @Test
    void testExecuteMoveMultipleSwap() {
        when(cell1.row()).thenReturn(0);
        when(cell1.column()).thenReturn(0);
        when(cell1.player()).thenReturn('X');

        when(cell2.row()).thenReturn(1);
        when(cell2.column()).thenReturn(1);
        when(cell2.player()).thenReturn('O');

        when(board.getFilledCells()).thenReturn(List.of(cell1, cell2));
        when(ioProvider.readInt(anyString(), any(NValidator.class))).thenReturn(2);
        when(random.ints(eq(0), eq(2)))
                .thenReturn(IntStream.of(0, 1))
                .thenReturn(IntStream.of(1))
                .thenReturn(IntStream.of(0));

        swapNMoveStrategy.executeMove(gameState, 'X');

        // For cell1 ('X'), swap to 'O'
        verify(board).setCell(0, 0, 'O');
        // For cell2 ('O'), swap to 'X'
        verify(board).setCell(1, 1, 'X');
    }

    @Test
    void testExecuteMoveZeroSwap() {
        when(board.getFilledCells()).thenReturn(List.of(cell1));
        when(ioProvider.readInt(anyString(), any(NValidator.class))).thenReturn(0);

        swapNMoveStrategy.executeMove(gameState, 'X');

        verify(board, never()).setCell(anyInt(), anyInt(), anyChar());
    }
}
