package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.GameState;
import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.board.BoardCell;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public final class PlaceNMoveStrategyTest {

    private IOProvider mockIOProvider;
    private Random mockRandom;
    private ElementSupplier mockElementSupplier;
    private PlaceNMoveStrategy strategy;
    private GameState mockGameState;
    private Board mockBoard;
    private char emptyCell = ' ';

    @BeforeEach
    void setUp() {
        mockIOProvider = mock(IOProvider.class);
        mockRandom = mock(Random.class);
        mockElementSupplier = mock(ElementSupplier.class);
        strategy = new PlaceNMoveStrategy(mockIOProvider, mockRandom, mockElementSupplier);

        mockGameState = mock(GameState.class);
        mockBoard = mock(Board.class);
        MatchConfiguration mockConfig = mock(MatchConfiguration.class);

        when(mockGameState.getCurrentBoard()).thenReturn(mockBoard);
        when(mockBoard.getMatchConfiguration()).thenReturn(mockConfig);
        when(mockConfig.getPlayerCount()).thenReturn(2);

    }

    @Test
    void testExecuteMovePlaceSymbolsWithValidN() {
        List<BoardCell> freePositions = List.of(
                new BoardCell(0, 0, emptyCell),
                new BoardCell(0, 1, emptyCell),
                new BoardCell(1, 0, emptyCell),
                new BoardCell(1, 1, emptyCell),
                new BoardCell(2, 2, emptyCell)
        );

        int selectedN = 3;
        when(mockBoard.getEmptyCells()).thenReturn(freePositions);
        when(mockIOProvider.readInt(anyString(), any())).thenReturn(selectedN);

        // Mock random indices selection (select first 3 positions)
        when(mockRandom.ints(0, freePositions.size()))
                .thenReturn(IntStream.of(0, 1, 2).boxed().mapToInt(i -> i));

        // Mock player symbols selection (alternate between X and O)
        when(mockRandom.ints(0, 2))
                .thenReturn(IntStream.of(0, 1, 0).boxed().mapToInt(i -> i));
        when(mockElementSupplier.getElement(0)).thenReturn('X');
        when(mockElementSupplier.getElement(1)).thenReturn('O');

        // Execute
        strategy.executeMove(mockGameState, 'X');

        // Verify
        ArgumentCaptor<Integer> rowCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> colCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Character> playerCaptor = ArgumentCaptor.forClass(Character.class);

        verify(mockBoard, times(selectedN))
                .setCell(rowCaptor.capture(), colCaptor.capture(), playerCaptor.capture());

        // Verify the positions that were set
        List<Integer> rows = rowCaptor.getAllValues();
        List<Integer> cols = colCaptor.getAllValues();
        List<Character> players = playerCaptor.getAllValues();

        assertEquals(selectedN, rows.size());
        assertEquals(selectedN, cols.size());
        assertEquals(selectedN, players.size());

        // Verify the players are either X or O (as we mocked)
        assertTrue(players.contains('X'));
        assertTrue(players.contains('O'));
    }

    @Test
    void testExecuteMovePlaceSymbolsWithNoEmptyCells() {
        // Setup - no empty cells
        List<BoardCell> occupiedPositions = List.of(
                new BoardCell(0, 0, 'X'),
                new BoardCell(0, 1, 'O'),
                new BoardCell(1, 0, 'X')
        );

        when(mockBoard.getEmptyCells()).thenReturn(occupiedPositions);

        // Execute
        strategy.executeMove(mockGameState, 'X');

        // Verify
        verify(mockBoard, never()).setCell(anyInt(), anyInt(), anyChar());
    }

    @Test
    void testExecuteMovePlaceSymbolsWithNZero() {
        // Setup
        List<BoardCell> freePositions = List.of(
                new BoardCell(0, 0, emptyCell),
                new BoardCell(0, 1, emptyCell),
                new BoardCell(1, 0, emptyCell)
        );

        when(mockBoard.getEmptyCells()).thenReturn(freePositions);
        when(mockIOProvider.readInt(anyString(), any())).thenReturn(0);

        // Execute
        strategy.executeMove(mockGameState, 'X');

        // Verify
        verify(mockBoard, never()).setCell(anyInt(), anyInt(), anyChar());
    }

    @Test
    void testToStringReturnsCorrectValue() {
        assertEquals("Place N", strategy.toString());
    }
}
