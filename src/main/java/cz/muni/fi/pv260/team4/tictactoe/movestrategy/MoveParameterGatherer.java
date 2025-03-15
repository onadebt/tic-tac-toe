package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

public interface MoveParameterGatherer<T> {

    /**
     * Gather move parameters for different strategies.
     * For example, for SingleMoveStrategy it gathers row and column as Pair<Integer, Integer>.
     * For SwapNStrategy it gathers only one number, as it swaps N random cells' values.
     *
     * @return move parameters
     */
    T gatherMoveParameters();
}
