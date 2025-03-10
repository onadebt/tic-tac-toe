package cz.muni.fi.pv260.team4.tictactoe.phase;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class MatchPhase implements GamePhase {
    private final GamePhaseFactory gamePhaseFactory;
    private final IOProvider ioProvider;
    private final MatchConfiguration configuration;
    private final Board board;

    @Override
    public GamePhase execute() {
        return null;
    }
}
