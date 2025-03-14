package cz.muni.fi.pv260.team4.tictactoe.iterator;

import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;

/**
 * Provides predefined Tic-Tac-Toe board configurations for testing iterators.
 * <p>
 * This class contains various static final board setups used in test cases.
 * It is a utility class and cannot be instantiated.
 * </p>
 *
 * @author Jakub Španger
 * @version 1.0
 */
public final class IteratorTestConfig {

    /**
     * Prevents instantiation of this utility class.
     */
    private IteratorTestConfig() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * Default match configuration for tests.
     */
    public static final MatchConfiguration DEFAULT_MATCH_CONFIG =
            new MatchConfiguration(2, 3, 7, 3);

    /**
     * Returns a standard test board with a mixture of 'X' and 'O' values.
     *
     * @return a 7x3 Tic-Tac-Toe board.
     */
    public static char[][] getTestBoard() {
        return new char[][]{
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'O', 'X', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'O', 'X', 'X'}
        };
    }

    /**
     * Returns an empty board with all cells containing spaces.
     *
     * @return a 7x3 empty Tic-Tac-Toe board.
     */
    public static char[][] getEmptyBoard() {
        return new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
    }

    /**
     * Returns a board setup with no winner (variant 1).
     *
     * @return a 7x3 Tic-Tac-Toe board with no winning sequence.
     */
    public static char[][] getNoWinner1() {
        return new char[][]{
                {' ', 'X', ' '},
                {'X', ' ', 'X'},
                {' ', 'O', ' '},
                {'O', ' ', 'O'},
                {' ', 'X', ' '},
                {'X', ' ', 'X'},
                {' ', 'O', ' '}
        };
    }

    /**
     * Returns another board setup with no winner (variant 2).
     *
     * @return a 7x3 Tic-Tac-Toe board with no winning sequence.
     */
    public static char[][] getNoWinner2() {
        return new char[][]{
                {' ', 'X', 'O'},
                {'X', 'O', 'X'},
                {'X', 'O', 'O'},
                {'O', 'X', 'O'},
                {'X', 'X', ' '},
                {'X', 'O', 'X'},
                {'O', 'O', 'X'}
        };
    }

    /**
     * Returns a board setup where 'X' has won (horizontal win).
     *
     * @return a 7x3 Tic-Tac-Toe board where 'X' has a winning row.
     */
    public static char[][] getWinnerX1() {
        return new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {'X', 'X', 'X'},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
    }

    /**
     * Returns a board setup where 'X' has won (descending diagonal).
     *
     * @return a 7x3 Tic-Tac-Toe board where 'X' has a diagonal win.
     */
    public static char[][] getWinnerX2() {
        return new char[][]{
                {'X', ' ', ' '},
                {' ', 'X', ' '},
                {' ', ' ', 'X'},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
    }

    /**
     * Returns a board setup where 'X' has won (ascending diagonal).
     *
     * @return a 7x3 Tic-Tac-Toe board where 'X' has a diagonal win.
     */
    public static char[][] getWinnerX3() {
        return new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', 'X'},
                {' ', 'X', ' '},
                {'X', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
    }

    /**
     * Returns a board setup where 'X' has won (vertical win).
     *
     * @return a 7x3 Tic-Tac-Toe board where 'X' has a vertical win.
     */
    public static char[][] getWinnerX4() {
        return new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', 'X'},
                {' ', ' ', 'X'},
                {' ', ' ', 'X'},
                {' ', ' ', ' '}
        };
    }
}
