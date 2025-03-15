package cz.muni.fi.pv260.team4.tictactoe.phase;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.evaluator.WinningPositionEvaluator;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.BoardDisplay;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.movestrategy.MoveStrategy;
import cz.muni.fi.pv260.team4.tictactoe.movestrategy.StrategyFactory;
import cz.muni.fi.pv260.team4.tictactoe.movestrategy.enums.MoveStrategyEnum;
import cz.muni.fi.pv260.team4.tictactoe.validators.StrategyValidator;

public final class MatchPhase implements GamePhase {
    private final IOProvider ioProvider;
    private final MatchConfiguration matchConfiguration;
    private final Board board;
    private final StrategyFactory strategyFactory;
    private final BoardDisplay boardDisplay;
    private final ElementSupplier elementSupplier;
    private final WinningPositionEvaluator evaluator;

    /**
     * Constructor for MatchPhase.
     *
     * @param provider IOProvider
     * @param configuration Configuration of game match
     * @param gameBoard Board
     * @param factory Strategy factory
     * @param display Board display
     * @param supplier Element supplier
     */
    public MatchPhase(final IOProvider provider,
                      final MatchConfiguration configuration,
                      final Board gameBoard,
                      final StrategyFactory factory,
                      final BoardDisplay display,
                      final ElementSupplier supplier) {
        this.ioProvider = provider;
        this.matchConfiguration = configuration;
        this.board = gameBoard;
        this.strategyFactory = factory;
        this.boardDisplay = display;
        this.elementSupplier = supplier;
        this.evaluator = new WinningPositionEvaluator(gameBoard, configuration);
    }

    private int currentPlayerIndex = 0;

    @Override
    public GamePhase execute() {
        while (!isGameOver()) {
            ioProvider.writeString("Player " + (currentPlayerIndex + 1) + " turn\n");
            MoveStrategy moveStrategy = selectStrategy();
            boardDisplay.displayBoard(board);
            executePlayerTurn(moveStrategy);
            currentPlayerIndex = (int) ((currentPlayerIndex + 1) % matchConfiguration.playerCount());
        }
        return null;
    }

    private MoveStrategy selectStrategy() {
        StringBuilder sb = new StringBuilder("Choose strategy:\n");
        for (MoveStrategyEnum strategy : MoveStrategyEnum.values()) {
            sb.append(strategy.ordinal() + 1).append(" - ").append(strategy).append("\n");
        }

        long strategyIndex = ioProvider.readLong(sb.toString(), new StrategyValidator());
        return strategyFactory.chooseStrategy(MoveStrategyEnum.values()[(int) strategyIndex - 1]);
    }

    private void executePlayerTurn(final MoveStrategy moveStrategy) {
        // todo saving board state for memento pattern
        moveStrategy.executeMove(board, getCurrentPlayer());
        boardDisplay.displayBoard(board);
    }


    private boolean isGameOver() {
        return evaluator.getWinner().isPresent();
    }

    private Character getCurrentPlayer() {
        return elementSupplier.getElement(currentPlayerIndex);
    }
}
