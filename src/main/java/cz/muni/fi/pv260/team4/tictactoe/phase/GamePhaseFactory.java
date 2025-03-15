package cz.muni.fi.pv260.team4.tictactoe.phase;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.board.BoardFactory;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.evaluator.WinningPositionEvaluator;
import cz.muni.fi.pv260.team4.tictactoe.infrastructure.TerminalBoardDisplay;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.BoardDisplay;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.movestrategy.StrategyFactory;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GamePhaseFactory {
    private final IOProvider ioProvider;
    private final ElementSupplier elementSupplier;
    private final BoardFactory boardFactory;
    private final BoardDisplay boardDisplay;

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
        Board board = boardFactory.createEmptyBoard(configuration, supplier);
        StrategyFactory strategyFactory = new StrategyFactory(ioProvider, configuration);

        return new MatchPhase(
                ioProvider,
                configuration,
                board,
                strategyFactory,
                boardDisplay,
                supplier,
                new WinningPositionEvaluator(board, configuration)
        );
    }
}
