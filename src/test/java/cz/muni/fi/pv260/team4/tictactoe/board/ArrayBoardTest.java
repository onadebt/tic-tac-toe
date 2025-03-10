package cz.muni.fi.pv260.team4.tictactoe.board;

import cz.muni.fi.pv260.team4.tictactoe.element.AlphabeticElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayBoardTest {

    public static MatchConfiguration getDummyMatchConfiguration() {
        return new MatchConfiguration(2, 3, 5, 3);
    }

    public static ElementSupplier getDummyElementSupplier() {
        return new AlphabeticElementSupplier();
    }

    @Test
    public void testEmptyGrid() {
        final MatchConfiguration matchConfiguration = getDummyMatchConfiguration();
        final ElementSupplier elementSupplier = getDummyElementSupplier();
        Character[][] grid = ArrayBoard.getEmptyGrid(matchConfiguration, elementSupplier);
        Board board = new ArrayBoard(elementSupplier, matchConfiguration, grid);

        for (int row = 0; row < matchConfiguration.boardHeight(); row++) {
            for (int col = 0; col < matchConfiguration.boardWidth(); col++) {
                assertEquals(elementSupplier.getEmptyElement(), grid[row][col]);
                assertEquals(elementSupplier.getEmptyElement(), board.getCell(row, col));
                assertTrue(board.isCellEmpty(row, col));
            }
        }
    }

    @Test
    public void testSingleInsertAndGet() {
        final MatchConfiguration matchConfiguration = getDummyMatchConfiguration();
        final ElementSupplier elementSupplier = getDummyElementSupplier();
        Character[][] grid = ArrayBoard.getEmptyGrid(matchConfiguration, elementSupplier);
        Board board = new ArrayBoard(elementSupplier, matchConfiguration, grid);

        Character player1 = elementSupplier.getElement(0);

        board.setCell(0, 0, player1);
        assertEquals(player1, board.getCell(0, 0));
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testRandomInsertAndGet() {
        final MatchConfiguration matchConfiguration = new MatchConfiguration(10, 12, 7, 3);
        final ElementSupplier elementSupplier = getDummyElementSupplier();
        Character[][] grid = ArrayBoard.getEmptyGrid(matchConfiguration, elementSupplier);
        Board board = new ArrayBoard(elementSupplier, matchConfiguration, grid);

        int attempts = 1000;

        Random random = new SecureRandom();

        for (int attempt = 0; attempt < attempts; attempt++) {
            int row = random.nextInt((int) matchConfiguration.boardHeight());
            int col = random.nextInt((int) matchConfiguration.boardWidth());
            int playerNum = random.nextInt((int) matchConfiguration.playerCount());
            Character player = elementSupplier.getElement(playerNum);
            board.setCell(row, col, player);
            assertEquals(player, board.getCell(row, col));
            assertFalse(board.isCellEmpty(row, col));
        }
    }
}
