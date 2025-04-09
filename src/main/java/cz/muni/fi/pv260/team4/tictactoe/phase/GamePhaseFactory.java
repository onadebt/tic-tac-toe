package cz.muni.fi.pv260.team4.tictactoe.phase;

import cz.muni.fi.pv260.team4.tictactoe.GameState;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.evaluator.WinningPositionEvaluator;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.BoardDisplay;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.movestrategy.StrategyFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GamePhaseFactory {
    private final IOProvider ioProvider;
    private final ElementSupplier elementSupplier;
    private final BoardDisplay boardDisplay;
    private final MatchConfiguration matchConfiguration;
    private final GameState gameState;
    private final StrategyFactory strategyFactory;
    private final WinningPositionEvaluator winningPositionEvaluator;

    /**
     * Construct match phase.
     *
     * @return match game phase
     */
    public GamePhase getMatchPhase() {
        return new MatchPhase(
                ioProvider,
                matchConfiguration,
                gameState,
                strategyFactory,
                boardDisplay,
                elementSupplier,
                winningPositionEvaluator
        );
    }
}
