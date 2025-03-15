package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.movestrategy.enums.MoveStrategyEnum;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class StrategyFactory {
    private final IOProvider ioProvider;


    /**
     * Choose strategy based on the move type.
     *
     * @param moveType move type
     * @return MoveStrategy
     */
    public MoveStrategy chooseStrategy(final MoveStrategyEnum moveType) {
        return switch (moveType) {
            case SINGLE_MOVE -> new SingleMoveStrategy(ioProvider);

            default -> throw new IllegalArgumentException("Invalid move type, please choose another one");
        };
    }
}
