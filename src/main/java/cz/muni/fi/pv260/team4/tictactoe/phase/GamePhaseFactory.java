package cz.muni.fi.pv260.team4.tictactoe.phase;

import cz.muni.fi.pv260.team4.tictactoe.board.BoardFactory;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.infrastructure.TerminalBoardDisplay;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.BoardDisplay;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.movestrategy.StrategyFactory;

public class GamePhaseFactory {
    private final IOProvider ioProvider;
    private final ElementSupplier elementSupplier;
    private final BoardFactory boardFactory;
    private final StrategyFactory strategyFactory;
    private final BoardDisplay boardDisplay;

    /**
     * Constructor for GamePhaseFactory.
     *
     * @param provider IOProvider
     * @param supplier   Element supplier
     */
    public GamePhaseFactory(final IOProvider provider, final ElementSupplier supplier) {
        this.ioProvider = provider;
        this.elementSupplier = supplier;
        boardFactory = new BoardFactory();
        strategyFactory = new StrategyFactory(provider);
        boardDisplay = new TerminalBoardDisplay(provider);

    }


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
     * @param configuration   Configuration of game match
     * @param supplier Element supplier for the board
     * @return match game phase
     */
    public GamePhase getMatchPhase(final MatchConfiguration configuration, final ElementSupplier supplier) {
        return new MatchPhase(
                ioProvider,
                configuration,
                boardFactory.createEmptyBoard(configuration, supplier),
                strategyFactory,
                boardDisplay,
                supplier
        );
    }
}
