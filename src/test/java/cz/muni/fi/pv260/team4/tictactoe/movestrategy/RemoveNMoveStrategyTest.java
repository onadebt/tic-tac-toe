package cz.muni.fi.pv260.team4.tictactoe.movestrategy;


import cz.muni.fi.pv260.team4.tictactoe.GameState;
import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.board.BoardCell;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
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
class RemoveNMoveStrategyTest {
    @Mock
    private IOProvider ioProvider;

    @Mock
    private java.util.Random random;

    @Mock
    private ElementSupplier elementSupplier;

    @InjectMocks
    private RemoveNMoveStrategy removeNMoveStrategy;

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

    @Mock
    private BoardCell cell3;

    @BeforeEach
    void setup() {
        when(gameState.getCurrentBoard()).thenReturn(board);
    }

    @Test
    void testExecuteMoveSingleRemove() {
        when(cell1.row()).thenReturn(0);
        when(cell1.column()).thenReturn(0);

        when(board.getFilledCells()).thenReturn(List.of(cell1));
        when(board.getElementSupplier()).thenReturn(elementSupplier);
        when(elementSupplier.getEmptyElement()).thenReturn(' ');
        when(ioProvider.readInt(anyString(), any(NValidator.class))).thenReturn(1);

        when(random.ints(eq(0), eq(1))).thenReturn(IntStream.of(0));

        removeNMoveStrategy.executeMove(gameState, 'X');

        verify(board).setCell(0, 0, elementSupplier.getEmptyElement());
    }

    @Test
    void testExecuteMoveMultipleRemove() {
        when(cell1.row()).thenReturn(0);
        when(cell1.column()).thenReturn(0);

        when(cell3.row()).thenReturn(2);
        when(cell3.column()).thenReturn(2);

        when(board.getFilledCells()).thenReturn(List.of(cell1, cell2, cell3));
        when(board.getElementSupplier()).thenReturn(elementSupplier);
        when(elementSupplier.getEmptyElement()).thenReturn(' ');
        when(ioProvider.readInt(anyString(), any(NValidator.class))).thenReturn(2);
        when(random.ints(eq(0), eq(3)))
                .thenReturn(IntStream.of(0, 2));

        removeNMoveStrategy.executeMove(gameState, 'X');

        // Remove cell1 ('X')
        verify(board).setCell(0, 0, elementSupplier.getEmptyElement());
        // Remove cell3 ('X')
        verify(board).setCell(2, 2, elementSupplier.getEmptyElement());
    }

    @Test
    void testExecuteMoveZeroRemove() {
        when(board.getFilledCells()).thenReturn(List.of(cell1));
        when(ioProvider.readInt(anyString(), any(NValidator.class))).thenReturn(0);

        removeNMoveStrategy.executeMove(gameState, 'X');

        verify(board, never()).setCell(anyInt(), anyInt(), anyChar());
    }
}
