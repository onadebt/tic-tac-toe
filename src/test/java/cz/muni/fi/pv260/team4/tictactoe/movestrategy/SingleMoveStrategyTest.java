package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class SingleMoveStrategyTest {
    @Mock
    private IOProvider ioProvider;

    @Mock
    private MatchConfiguration matchConfiguration;

    @InjectMocks
    private SingleMoveStrategy singleMoveStrategy;


    @Mock
    private Board board;

    @Test
    void testExecuteMove() {
        when(ioProvider.readInt(anyString(), any())).thenReturn(1, 1);
        when(board.isCellEmpty(0, 0)).thenReturn(true);
        Mockito.doNothing().when(board).setCell(anyInt(), anyInt(), anyChar());

        singleMoveStrategy.executeMove(board, 'X');

        verify(ioProvider, times(2)).readInt(anyString(), any());
        verify(board).setCell(0, 0, 'X');
    }

    @Test
    void testExecuteMoveCellTaken() {
        doReturn(1, 1, 2, 2).when(ioProvider).readInt(anyString(), any());
        doReturn(false).when(board).isCellEmpty(0, 0);
        doReturn(true).when(board).isCellEmpty(1, 1);

        singleMoveStrategy.executeMove(board, 'X');

        verify(ioProvider, times(4)).readInt(anyString(), any());
        verify(board, never()).setCell(0, 0, 'X');
        verify(board).setCell(1, 1, 'X');
    }
}
