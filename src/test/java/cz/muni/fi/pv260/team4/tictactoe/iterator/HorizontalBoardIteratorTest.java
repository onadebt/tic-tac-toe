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
class HorizontalBoardIteratorTest {

    public static final char[][] TEST_BOARD = IteratorTestConfig.getTestBoard();
    @Mock
    private Board board;

    private HorizontalBoardIterator iterator;

    @BeforeEach
    void setUp() {
        iterator = new HorizontalBoardIterator(board, IteratorTestConfig.DEFAULT_MATCH_CONFIG, 0);
    }


    @Test
    public void shouldCallGetElementCorrectAmountOfTimes()  {
        Mockito.when(board.getCell(anyInt(), anyInt())).thenReturn('X');

        while (iterator.hasNext()) {
            iterator.next();
        }

        Mockito.verify(board, Mockito.times(3)).getCell(anyInt(), anyInt());
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
            responses.add(iterator.next());
        }

        Assertions.assertEquals('X', responses.poll());
        Assertions.assertEquals('O', responses.poll());
        Assertions.assertEquals('X', responses.poll());
    }
}
