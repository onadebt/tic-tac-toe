package cz.muni.fi.pv260.team4.tictactoe;

import cz.muni.fi.pv260.team4.tictactoe.board.BoardFactory;
import cz.muni.fi.pv260.team4.tictactoe.element.AlphabeticElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.evaluator.WinningPositionEvaluator;
import cz.muni.fi.pv260.team4.tictactoe.infrastructure.TerminalBoardDisplay;
import cz.muni.fi.pv260.team4.tictactoe.infrastructure.TerminalIOProvider;
import cz.muni.fi.pv260.team4.tictactoe.movestrategy.StrategyFactory;
import cz.muni.fi.pv260.team4.tictactoe.phase.GamePhase;
import cz.muni.fi.pv260.team4.tictactoe.phase.GamePhaseFactory;
import org.jetbrains.annotations.NotNull;

public final class Main {
    private Main() {
    }

    /**
     * Run the program.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        runGame();
    }

    private static void runGame() {
        var ioProvider = new TerminalIOProvider();
        var gamePhaseFactory = getGamePhaseFactory(ioProvider);

        GamePhase gamePhase = gamePhaseFactory.getSetupPhase();

        ioProvider.writeString("Welcome to Tic Tac Toe!\n");
        ioProvider.writeString("================================\n");

        while (gamePhase != null) {
            gamePhase = gamePhase.execute();
        }

        ioProvider.writeString("Game over!\n");
        ioProvider.writeString("================================\n");
    }

    private static final int DEFAULT_PLAYERS_COUNT = 2;
    private static final int DEFAULT_BOARD_WIDTH = 3;
    private static final int DEFAULT_BOARD_HEIGHT = 3;
    private static final int DEFAULT_WIN_SEQUENCE = 3;

    @NotNull
    private static GamePhaseFactory getGamePhaseFactory(final TerminalIOProvider ioProvider) {
        var elementSupplier = new AlphabeticElementSupplier();
        var boardFactory = new BoardFactory();
        var boardDisplay = new TerminalBoardDisplay(ioProvider);
        var matchConfiguration = new MatchConfiguration(
                DEFAULT_PLAYERS_COUNT,
                DEFAULT_BOARD_WIDTH,
                DEFAULT_BOARD_HEIGHT,
                DEFAULT_WIN_SEQUENCE
        );
        var board = boardFactory.createEmptyBoard(matchConfiguration, elementSupplier);
        var strategyFactory = new StrategyFactory(ioProvider, matchConfiguration);
        var winningPositionEvaluator = new WinningPositionEvaluator(board, matchConfiguration);

        return new GamePhaseFactory(
                ioProvider,
                elementSupplier,
                boardDisplay,
                matchConfiguration,
                board,
                strategyFactory,
                winningPositionEvaluator);
    }
}
