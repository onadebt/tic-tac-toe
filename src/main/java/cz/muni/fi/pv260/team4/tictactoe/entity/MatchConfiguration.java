package cz.muni.fi.pv260.team4.tictactoe.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity holding match configuration.
 */
@Getter
@Setter
@AllArgsConstructor
public final class MatchConfiguration {
    private int playerCount;
    private int boardWidth;
    private int boardHeight;
    private int winningSequenceLength;
}
