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

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RollbackStrategyTest {

    @Mock
    private IOProvider ioProvider;

    @Mock
    private GameState gameState;

    @Mock
    private MoveParameterGatherer<Integer> moveParameterGatherer;

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
        when(moveParameterGatherer.gatherMoveParameters()).thenReturn(2); // Will result in 3 pop() calls

        // Override the gatherer using Spy
        doReturn(moveParameterGatherer).when(rollbackStrategy).getMoveParameterGatherer();

        // Act
        rollbackStrategy.executeMove(gameState, 'X');

        // Assert
        verify(moveHistory, times(3)).pop(); // 2 + 1 = 3
    }

}