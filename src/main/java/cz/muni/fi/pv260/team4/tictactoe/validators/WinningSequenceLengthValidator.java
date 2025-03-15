package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.Const;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public final class WinningSequenceLengthValidator implements InputValidator<Integer> {
    private final Integer boardWidth;
    private final Integer boardHeight;

    /**
     * Validate the length of the winning sequence.
     *
     * @param lengthOfTheWinningSequence Length of the winning sequence to validate
     * @return Optional containing error message if validation fails, otherwise empty
     */
    @Override
    public Optional<String> validate(final Integer lengthOfTheWinningSequence) {
        if (lengthOfTheWinningSequence < Const.MINIMAL_LENGTH_OF_WINNING_SEQUENCE) {
            return Optional.of("Length of the winning sequence has to be at least "
                    + Const.MINIMAL_LENGTH_OF_WINNING_SEQUENCE);
        }

        if (lengthOfTheWinningSequence > Math.min(this.boardWidth, this.boardHeight)) {
            return Optional.of("Winning sequence length cannot exceed one of the board's dimensions");
        }

        return Optional.empty();
    }
}

