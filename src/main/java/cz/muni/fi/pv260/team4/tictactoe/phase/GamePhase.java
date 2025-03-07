package cz.muni.fi.pv260.team4.tictactoe.phase;

public interface GamePhase {
    /**
     * Execute GamePhase and return next phase or null if game should end.
     *
     * @return next phase or null to end the game
     */
    GamePhase execute();
}
