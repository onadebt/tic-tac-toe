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
        // Returns a dummy MatchConfiguration with predefined values for testing
        return new MatchConfiguration(2, 3, 5, 3);
    }

    public static ElementSupplier getDummyElementSupplier() {
        // Returns a simple alphabetic element supplier for test purposes
        return new AlphabeticElementSupplier();
    }

    @Test
    public void testEmptyGrid() {
        // Test: Verify that a newly created board is completely empty

        final MatchConfiguration matchConfiguration = getDummyMatchConfiguration();
        final ElementSupplier elementSupplier = getDummyElementSupplier();

        // Create an empty grid and board
        Character[][] grid = ArrayBoard.getEmptyGrid(matchConfiguration, elementSupplier);
        Board board = new ArrayBoard(elementSupplier, matchConfiguration, grid);

        // Ensure every cell in the grid is initialized to the empty element
        for (int row = 0; row < matchConfiguration.boardHeight(); row++) {
            for (int col = 0; col < matchConfiguration.boardWidth(); col++) {
                assertEquals(elementSupplier.getEmptyElement(), grid[row][col]);
                assertEquals(elementSupplier.getEmptyElement(), board.getCell(row, col));
                assertTrue(board.isCellEmpty(row, col)); // Ensure cells are empty
            }
        }
    }

    @Test
    public void testSingleInsertAndGet() {
        // Test: Insert a single element into the board and verify retrieval

        final MatchConfiguration matchConfiguration = getDummyMatchConfiguration();
        final ElementSupplier elementSupplier = getDummyElementSupplier();

        // Create an empty board
        Character[][] grid = ArrayBoard.getEmptyGrid(matchConfiguration, elementSupplier);
        Board board = new ArrayBoard(elementSupplier, matchConfiguration, grid);

        // Get the first player element
        Character player1 = elementSupplier.getElement(0);

        // Insert element at (0,0)
        board.setCell(0, 0, player1);

        // Verify that the inserted element is correctly stored
        assertEquals(player1, board.getCell(0, 0));
        assertFalse(board.isCellEmpty(0, 0)); // Ensure cell is no longer empty
    }

    @Test
    public void testRandomInsertAndGet() {
        // Test: Randomly insert multiple elements into the board and verify correctness

        final MatchConfiguration matchConfiguration = new MatchConfiguration(10, 12, 7, 3);
        final ElementSupplier elementSupplier = getDummyElementSupplier();

        // Create an empty board
        Character[][] grid = ArrayBoard.getEmptyGrid(matchConfiguration, elementSupplier);
        Board board = new ArrayBoard(elementSupplier, matchConfiguration, grid);

        int attempts = 1000;
        Random random = new SecureRandom();

        for (int attempt = 0; attempt < attempts; attempt++) {
            // Generate random row, column, and player
            int row = random.nextInt((int) matchConfiguration.boardHeight());
            int col = random.nextInt((int) matchConfiguration.boardWidth());
            int playerNum = random.nextInt((int) matchConfiguration.playerCount());

            // Get the player's element and insert into the board
            Character player = elementSupplier.getElement(playerNum);
            board.setCell(row, col, player);

            // Verify that the correct element was inserted and the cell is occupied
            assertEquals(player, board.getCell(row, col));
            assertFalse(board.isCellEmpty(row, col));
        }
    }


    @Test
    public void testCreateCopyDoesNotAffectOriginalBoard() {
        // Arrange: Create initial board and insert some elements
        MatchConfiguration matchConfiguration = new MatchConfiguration(5, 5, 5, 3);
        ElementSupplier elementSupplier = getDummyElementSupplier();
        Character[][] grid = ArrayBoard.getEmptyGrid(matchConfiguration, elementSupplier);
        Board originalBoard = new ArrayBoard(elementSupplier, matchConfiguration, grid);

        // Insert elements into the original board
        originalBoard.setCell(1, 1, 'X');
        originalBoard.setCell(2, 2, 'O');

        // Act: Create a copy of the board
        Board copiedBoard = originalBoard.createCopy();

        // Modify the copied board
        copiedBoard.setCell(3, 3, 'X');
        copiedBoard.setCell(4, 4, 'O');

        // Assert: Original board remains unchanged
        assertEquals('X', originalBoard.getCell(1, 1));
        assertEquals('O', originalBoard.getCell(2, 2));
        assertTrue(originalBoard.isCellEmpty(3, 3)); // Should still be empty in original
        assertTrue(originalBoard.isCellEmpty(4, 4)); // Should still be empty in original

        // Assert: Copied board contains new modifications
        assertEquals('X', copiedBoard.getCell(3, 3));
        assertEquals('O', copiedBoard.getCell(4, 4));
    }
}
