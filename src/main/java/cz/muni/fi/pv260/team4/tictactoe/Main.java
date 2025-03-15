package cz.muni.fi.pv260.team4.tictactoe;

import cz.muni.fi.pv260.team4.tictactoe.board.BoardFactory;
import cz.muni.fi.pv260.team4.tictactoe.element.AlphabeticElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.evaluator.WinningPositionEvaluator;
import cz.muni.fi.pv260.team4.tictactoe.infrastructure.TerminalBoardDisplay;
import cz.muni.fi.pv260.team4.tictactoe.infrastructure.TerminalIOProvider;
import cz.muni.fi.pv260.team4.tictactoe.movestrategy.StrategyFactory;
import cz.muni.fi.pv260.team4.tictactoe.phase.GamePhase;
import cz.muni.fi.pv260.team4.tictactoe.phase.GamePhaseFactory;
import cz.muni.fi.pv260.team4.tictactoe.phase.MatchConfigurationGenerator;

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

        GamePhase gamePhase = createInitialGamePhase(ioProvider);

        ioProvider.writeString("Welcome to Tic Tac Toe!");
        ioProvider.newline();
        ioProvider.writeString("================================");
        ioProvider.newline();

        while (gamePhase != null) {
            gamePhase = gamePhase.execute();
        }

        ioProvider.writeString("Game over!");
        ioProvider.newline();
        ioProvider.writeString("================================");
        ioProvider.newline();
    }

    private static GamePhase createInitialGamePhase(final TerminalIOProvider ioProvider) {
        var elementSupplier = new AlphabeticElementSupplier();
        var boardFactory = new BoardFactory();
        var boardDisplay = new TerminalBoardDisplay(ioProvider);
        var configuration = new MatchConfigurationGenerator(ioProvider, elementSupplier).createMatchConfiguration();
        var strategyFactory = new StrategyFactory(ioProvider, configuration);
        var board = boardFactory.createEmptyBoard(configuration, elementSupplier);
        var winningPositionEvaluator = new WinningPositionEvaluator(board, configuration);

        var gamePhaseFactory = new GamePhaseFactory(
                ioProvider,
                elementSupplier,
                boardDisplay,
                configuration,
                board,
                strategyFactory,
                winningPositionEvaluator);

        return gamePhaseFactory.getMatchPhase();
    }
}
