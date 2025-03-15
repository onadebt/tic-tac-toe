package cz.muni.fi.pv260.team4.tictactoe.phase;

import cz.muni.fi.pv260.team4.tictactoe.Const;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.validators.BoardHeightValidator;
import cz.muni.fi.pv260.team4.tictactoe.validators.BoardWidthValidator;
import cz.muni.fi.pv260.team4.tictactoe.validators.PlayerCountValidator;
import cz.muni.fi.pv260.team4.tictactoe.validators.WinningSequenceLengthValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class MatchConfigurationGenerator {
    private final IOProvider ioProvider;
    private final ElementSupplier elementSupplier;


    /**
     * Creates a new match configuration by prompting the user for required settings.
     *
     * @return a {@link MatchConfiguration} instance containing the collected settings.
     */
    public MatchConfiguration createMatchConfiguration() {
        var playerCount = ioProvider.readInt(
                "How many players",
                Const.MINIMAL_PLAYER_COUNT,
                new PlayerCountValidator(elementSupplier)
        );

        var boardWidth = ioProvider.readInt(
                "Width of the board",
                Const.MINIMAL_BOARD_WIDTH,
                new BoardWidthValidator()
        );

        var boardHeight = ioProvider.readInt(
                "Height of the board",
                Const.MINIMAL_BOARD_HEIGHT,
                new BoardHeightValidator()
        );

        var lengthOfWinningSequence = ioProvider.readInt(
                "Length of the winning sequence",
                Const.MINIMAL_LENGTH_OF_WINNING_SEQUENCE,
                new WinningSequenceLengthValidator(boardWidth, boardHeight)
        );

        return new MatchConfiguration(playerCount, boardWidth, boardHeight, lengthOfWinningSequence);
    }
}
