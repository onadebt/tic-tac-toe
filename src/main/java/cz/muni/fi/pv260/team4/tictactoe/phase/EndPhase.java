package cz.muni.fi.pv260.team4.tictactoe.phase;

import cz.muni.fi.pv260.team4.tictactoe.evaluator.WinningPositionEvaluator;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public final class EndPhase implements GamePhase {
    private final IOProvider ioProvider;
    private final WinningPositionEvaluator evaluator;

    @Override
    public GamePhase execute() {
        final Optional<Character> winner = evaluator.getWinner();

        ioProvider.writeString("================================");
        ioProvider.newline();
        final StringBuilder sb = new StringBuilder();
        sb.append("Game over! ");
        if (winner.isEmpty()) {
            sb.append("DRAW");
        } else {
            sb.append(String.format("WINNER: %s", winner.get()));
        }
        ioProvider.writeString(sb.toString());
        return null;
    }
}
