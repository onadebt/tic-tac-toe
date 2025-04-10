package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.GameState;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class StrategyFactory {
    private final List<MoveStrategy<?>> moveStrategyList = new ArrayList<>();

    /**
     * StrategyFactory constructor.
     *
     * @param ioProvider          IOProvider
     * @param matchConfiguration  MatchConfiguration
     * @param random              Random
     * @param elementSupplier     ElementSupplier
     * @param gameState           GameState
     */
    public StrategyFactory(
            final IOProvider ioProvider,
            final MatchConfiguration matchConfiguration,
            final GameState gameState,
            final Random random,
            final ElementSupplier elementSupplier
    ) {
        moveStrategyList.add(new SingleMoveStrategy(ioProvider, matchConfiguration));
        moveStrategyList.add(new RollbackStrategy(ioProvider, gameState));
        moveStrategyList.add(new SwapNMoveStrategy(ioProvider, random, elementSupplier));
        moveStrategyList.add(new RemoveNMoveStrategy(ioProvider, random));
        moveStrategyList.add(new PlaceNMoveStrategy(ioProvider, random, elementSupplier));
    }

    /**
     * Get list of all available move strategies.
     *
     * @return List of MoveStrategy
     */
    public List<MoveStrategy<?>> getMoveStrategyList() {
        return moveStrategyList;
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
