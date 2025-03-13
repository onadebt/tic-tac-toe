package cz.muni.fi.pv260.team4.tictactoe.iterator;

import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;

public class IteratorTestConfig {
    public static final MatchConfiguration DEFAULT_MATCH_CONFIG = new MatchConfiguration(2, 3, 7, 3);

    public static final char[][] TEST_BOARD = {
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
            {'O', 'X', 'X'},
            {'O', 'X', 'O'},
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
            {'O', 'X', 'X'}
    };

    public static final char[][] EMPTY_BOARD = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public static final char[][] NO_WINNER_1 = {
            {' ', 'X', ' '},
            {'X', ' ', 'X'},
            {' ', 'O', ' '},
            {'O', ' ', 'O'},
            {' ', 'X', ' '},
            {'X', ' ', 'X'},
            {' ', 'O', ' '}
    };

    public static final char[][] NO_WINNER_2 = {
            {' ', 'X', 'O'},
            {'X', 'O', 'X'},
            {'X', 'O', 'O'},
            {'O', 'X', 'O'},
            {'X', 'X', ' '},
            {'X', 'O', 'X'},
            {'O', 'O', 'X'}
    };

    public static final char[][] WINNER_X_1 = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {'X', 'X', 'X'},
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public static final char[][] WINNER_X_2 = {
            {'X', ' ', ' '},
            {' ', 'X', ' '},
            {' ', ' ', 'X'},
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public static final char[][] WINNER_X_3 = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', 'X'},
            {' ', 'X', ' '},
            {'X', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public static final char[][] WINNER_X_4 = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', 'X'},
            {' ', ' ', 'X'},
            {' ', ' ', 'X'},
            {' ', ' ', ' '}
    };
}