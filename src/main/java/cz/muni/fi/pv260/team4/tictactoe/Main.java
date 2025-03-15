package cz.muni.fi.pv260.team4.tictactoe;

import cz.muni.fi.pv260.team4.tictactoe.element.AlphabeticElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.infrastructure.TerminalIOProvider;
import cz.muni.fi.pv260.team4.tictactoe.phase.GamePhase;
import cz.muni.fi.pv260.team4.tictactoe.phase.GamePhaseFactory;

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
        var elementSupplier = new AlphabeticElementSupplier();

        var gamePhaseFactory = new GamePhaseFactory(ioProvider, elementSupplier);

        GamePhase gamePhase = gamePhaseFactory.getSetupPhase();

        while (gamePhase != null) {
            ioProvider.writeString("Welcome to Tic Tac Toe!\n");
            ioProvider.writeString("================================\n");

            gamePhase = gamePhase.execute();

        }

        ioProvider.writeString("Game over!\n");
        ioProvider.writeString("================================\n");
    }
}
