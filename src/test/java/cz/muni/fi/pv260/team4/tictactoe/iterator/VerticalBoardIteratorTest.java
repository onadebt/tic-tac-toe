package cz.muni.fi.pv260.team4.tictactoe.iterator;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.Queue;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
class VerticalBoardIteratorTest {

    public static final char[][] TEST_BOARD = IteratorTestConfig.getTestBoard();
    @Mock
    private Board board;

    private VerticalBoardIterator iterator;

    @BeforeEach
    void setUp() {
        iterator = new VerticalBoardIterator(board, IteratorTestConfig.DEFAULT_MATCH_CONFIG, 0);
    }


    @Test
    public void shouldCallGetElementCorrectAmountOfTimes() {
        Mockito.when(board.getCell(anyInt(), anyInt())).thenReturn('X');

        while (iterator.hasNext()) {
            iterator.next();
        }

        Mockito.verify(board, Mockito.times(7)).getCell(anyInt(), anyInt());
    }

    @Test
    public void shouldReturnCorrectCharactersWhenIterating() {
        Mockito.when(board.getCell(anyInt(), anyInt())).thenAnswer(invocation -> {
            int row = invocation.getArgument(0); // First parameter (row)
            int col = invocation.getArgument(1); // Second parameter (column)

            return TEST_BOARD[row][col];
        });

        Queue<Character> responses = new LinkedList<>();
        while (iterator.hasNext()) {
            Character next = iterator.next();
            responses.add(next);
        }

        Assertions.assertEquals('X', responses.remove());
        Assertions.assertEquals('O', responses.remove());
        Assertions.assertEquals('O', responses.remove());
        Assertions.assertEquals('O', responses.remove());
        Assertions.assertEquals('X', responses.remove());
        Assertions.assertEquals('O', responses.remove());
        Assertions.assertEquals('O', responses.remove());
    }
}
