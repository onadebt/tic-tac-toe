package cz.muni.fi.pv260.team4.tictactoe.entity;

/**
 * Entity holding match configuration.
 *
 * @param playerCount number of players
 * @param boardWidth width of the playing board
 * @param boardHeight height of the playing board
 * @param winningSequenceLength minimum length of same player sequence needed to win
 */
public record MatchConfiguration(
        int playerCount,
        int boardWidth,
        int boardHeight,
        int winningSequenceLength
) {
}
