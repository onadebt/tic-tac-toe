package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.GameState;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public final class StrategyFactory {
    /**
     * -- GETTER --
     *  Get list of all available move strategies.
     *
     * @return List of MoveStrategy
     */
    private final List<MoveStrategy<?>> moveStrategyList = new ArrayList<>();

    /**
     * StrategyFactory constructor.
     *
     * @param ioProvider          IOProvider
     * @param matchConfiguration  MatchConfiguration
     */
    public StrategyFactory(final IOProvider ioProvider, final MatchConfiguration matchConfiguration, final GameState gameState) {
        moveStrategyList.add(new SingleMoveStrategy(ioProvider, matchConfiguration));
        moveStrategyList.add(new RollbackStrategy(ioProvider, gameState));
    }

    /**
     * Choose strategy based on the user input.
     *
     * @param strategy move type
     * @return MoveStrategy
     */
    public MoveStrategy<?> chooseStrategy(final int strategy) {
        return moveStrategyList.get(strategy - 1);
    }
}
