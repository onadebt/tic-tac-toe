package cz.muni.fi.pv260.team4.tictactoe.phase;

import cz.muni.fi.pv260.team4.tictactoe.Const;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.validators.BoardHeightValidator;
import cz.muni.fi.pv260.team4.tictactoe.validators.BoardWidthValidator;
import cz.muni.fi.pv260.team4.tictactoe.validators.PlayerCountValidator;
import cz.muni.fi.pv260.team4.tictactoe.validators.WinningSequenceLengthValidator;
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
                new PlayerCountValidator()
        );

        var boardWidth = ioProvider.readLong(
                "Width of the board",
                Const.MINIMAL_BOARD_WIDTH,
                new BoardWidthValidator()
        );

        var boardHeight = ioProvider.readLong(
                "Height of the board",
                Const.MINIMAL_BOARD_HEIGHT,
                new BoardHeightValidator()
        );

        var lengthOfWinningSequence = ioProvider.readLong(
                "Length of the winning sequence",
                Const.MINIMAL_LENGTH_OF_WINNING_SEQUENCE,
                new WinningSequenceLengthValidator()
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
