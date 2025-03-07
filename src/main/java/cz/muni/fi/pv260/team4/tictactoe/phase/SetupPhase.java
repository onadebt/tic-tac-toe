package cz.muni.fi.pv260.team4.tictactoe.phase;

import cz.muni.fi.pv260.team4.tictactoe.Const;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class SetupPhase implements GamePhase {
    private final IOProvider ioProvider;
    private final GamePhaseFactory gamePhaseFactory;

    @Override
    public GamePhase execute() {
        var playerCount = ioProvider.readLong(
                "How many players",
                Const.MINIMAL_PLAYER_COUNT,
                (numOfPlayers) -> {
                    if (numOfPlayers < Const.MINIMAL_PLAYER_COUNT) {
                        return "There have to be at least 2 players";
                    }

                    return null;
                }
        );

        var boardWidth = ioProvider.readLong(
                "Width of the board",
                Const.MINIMAL_BOARD_WIDTH,
                (widthOfTheBoard) -> {
                    if (widthOfTheBoard < Const.MINIMAL_BOARD_WIDTH) {
                        return "Minimum width of the board is 3";
                    }

                    return null;
                }
        );

        var boardHeight = ioProvider.readLong(
                "Height of the board",
                Const.MINIMAL_BOARD_HEIGHT,
                (heightOfTheBoard) -> {
                    if (heightOfTheBoard < Const.MINIMAL_BOARD_HEIGHT) {
                        return "Minimum height of the board is 3";
                    }

                    return null;
                }
        );

        var lengthOfWinningSequence = ioProvider.readLong(
                "Length of the winning sequence",
                Const.MINIMAL_LENGTH_OF_WINNING_SEQUENCE,
                (lengthOfTheWinningSequence) -> {
                    if (lengthOfTheWinningSequence < Const.MINIMAL_LENGTH_OF_WINNING_SEQUENCE) {
                        return "Length of the winning sequence has to be at least 3";
                    }

                    return null;
                }
        );

        return gamePhaseFactory.getMatchPhase(
                new MatchConfiguration(
                        playerCount,
                        boardWidth,
                        boardHeight,
                        lengthOfWinningSequence
                )
        );
    }
}
