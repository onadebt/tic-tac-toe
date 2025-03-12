package cz.muni.fi.pv260.team4.tictactoe.phase;

import cz.muni.fi.pv260.team4.tictactoe.board.BoardFactory;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GamePhaseFactory {
    private final IOProvider ioProvider;
    private final ElementSupplier elementSupplier;

    private final BoardFactory boardFactory = new BoardFactory();

    /**
     * Construct setup phase.
     *
     * @return setup game phase
     */
    public GamePhase getSetupPhase() {
        return new SetupPhase(ioProvider, this, elementSupplier);
    }

    /**
     * Construct match phase.
     *
     * @param configuration Configuration of game match
     * @param elementSupplier Element supplier for the board
     * @return match game phase
     */
    public GamePhase getMatchPhase(final MatchConfiguration configuration, final ElementSupplier elementSupplier) {
        return new MatchPhase(
                this,
                ioProvider,
                configuration,
                boardFactory.createEmptyBoard(configuration, elementSupplier));
    }
}
