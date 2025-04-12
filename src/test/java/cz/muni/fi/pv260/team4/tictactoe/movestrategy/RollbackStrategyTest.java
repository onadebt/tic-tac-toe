package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.GameState;
import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Stack;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RollbackStrategyTest {

    @Mock
    private IOProvider ioProvider;

    @Mock
    private GameState gameState;

    @Spy
    @InjectMocks
    private RollbackStrategy rollbackStrategy;

    @Mock
    private Stack<Board> moveHistory;

    @BeforeEach
    void setUp() {
        when(gameState.getMoveHistory()).thenReturn(moveHistory);
    }

    @Test
    void testPopCalledCorrectNumberOfTimes() {
        // Arrange
        when(ioProvider.readInt(anyString(), any())).thenReturn(2);

        // Act
        rollbackStrategy.executeMove(gameState, 'X');

        // Assert
        verify(moveHistory, times(3)).pop(); // 2 + 1 = 3
    }
}
