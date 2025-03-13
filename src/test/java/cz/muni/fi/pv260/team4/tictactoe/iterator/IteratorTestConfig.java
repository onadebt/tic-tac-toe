package cz.muni.fi.pv260.team4.tictactoe.iterator;

import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;

public class IteratorTestConfig {
    public static final MatchConfiguration DEFAULT_MATCH_CONFIG = new MatchConfiguration(2, 3, 7, 3);

    public static final char[][] testBoard = {
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
            {'O', 'X', 'X'},
            {'O', 'X', 'O'},
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
            {'O', 'X', 'X'}
    };
}