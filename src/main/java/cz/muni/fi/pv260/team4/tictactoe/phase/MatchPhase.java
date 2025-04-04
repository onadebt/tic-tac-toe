package cz.muni.fi.pv260.team4.tictactoe.phase;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.evaluator.WinningPositionEvaluator;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.BoardDisplay;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.movestrategy.MoveStrategy;
import cz.muni.fi.pv260.team4.tictactoe.movestrategy.StrategyFactory;
import cz.muni.fi.pv260.team4.tictactoe.validators.StrategyValidator;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public final class MatchPhase implements GamePhase {
    private final IOProvider ioProvider;
    private final MatchConfiguration matchConfiguration;
    private final Board board;
    private final StrategyFactory strategyFactory;
    private final BoardDisplay boardDisplay;
    private final ElementSupplier elementSupplier;
    private final WinningPositionEvaluator evaluator;

    private int currentPlayerIndex = 0;

    @Override
    public GamePhase execute() {
        while (!isGameOver()) {
            ioProvider.writeString("Player " + (currentPlayerIndex + 1) + " turn");
            ioProvider.newline();
            MoveStrategy<?> moveStrategy = selectStrategy();
            boardDisplay.displayBoard(board);
            executePlayerTurn(moveStrategy);
            advancePlayer();
        }
        return new EndPhase(ioProvider, evaluator);
    }

    private MoveStrategy<?> selectStrategy() {
        StringBuilder sb = new StringBuilder("Choose strategy:");
        sb.append(System.lineSeparator());
        List<MoveStrategy<?>> moveStrategyList = strategyFactory.getMoveStrategyList();
        for (int i = 0; i < moveStrategyList.size(); i++) {
            MoveStrategy<?> strategy = moveStrategyList.get(i);
            sb.append(i + 1).append(" - ").append(strategy).append(System.lineSeparator());
        }

        int strategyIndex = ioProvider.readInt(sb.toString(), new StrategyValidator(strategyFactory));
        return strategyFactory.chooseStrategy(strategyIndex);
    }

    private void executePlayerTurn(final MoveStrategy<?> moveStrategy) {
        // todo saving board state for memento pattern
        moveStrategy.executeMove(board, getCurrentPlayer());
        boardDisplay.displayBoard(board);
    }

    private void advancePlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % matchConfiguration.getPlayerCount();
    }

    private boolean isGameOver() {
        return evaluator.getWinner().isPresent();
    }

    private Character getCurrentPlayer() {
        return elementSupplier.getElement(currentPlayerIndex);
    }
}
