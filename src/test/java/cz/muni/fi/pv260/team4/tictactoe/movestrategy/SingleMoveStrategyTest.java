package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;

@ExtendWith(MockitoExtension.class)
class SingleMoveStrategyTest {
    @Mock
    private IOProvider ioProvider;
    @Mock
    private Board board;

    @InjectMocks
    private SingleMoveStrategy singleMoveStrategy;

    @Test
    void testExecuteMove() {
        when(ioProvider.readInt(anyString(), any())).thenReturn(1, 1);
        when(board.isCellEmpty(0, 0)).thenReturn(true);

        singleMoveStrategy.executeMove(board, 'X');

        verify(ioProvider, times(2)).readInt(anyString(), any());
        verify(board).setCell(0, 0, 'X');
    }

    @Test
    void testExecuteMoveCellTaken() {
        when(ioProvider.readInt(anyString(), any())).thenReturn(1, 1, 2, 2);
        when(board.isCellEmpty(0, 0)).thenReturn(false);
        when(board.isCellEmpty(1, 1)).thenReturn(true);

        singleMoveStrategy.executeMove(board, 'X');

        verify(ioProvider, times(4)).readInt(anyString(), any());
        verify(board, never()).setCell(0, 0, 'X');
        verify(board).setCell(1, 1, 'X');
    }
}
