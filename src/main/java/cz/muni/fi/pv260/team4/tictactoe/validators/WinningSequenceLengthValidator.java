package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.Const;

import java.util.Optional;

public final class WinningSequenceLengthValidator implements InputValidator<Long> {
    private final Long boardWidth;
    private final Long boardHeight;

    public WinningSequenceLengthValidator(Long boardWidth, Long boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
    }

    @Override
    public Optional<String> validate(final Long lengthOfTheWinningSequence) {
        if (lengthOfTheWinningSequence < Const.MINIMAL_LENGTH_OF_WINNING_SEQUENCE) {
            return Optional.of("Length of the winning sequence has to be at least " + Const.MINIMAL_LENGTH_OF_WINNING_SEQUENCE);
        }

        if (lengthOfTheWinningSequence > Math.min(boardWidth, boardHeight)) {
            return Optional.of("Winning sequence length cannot exceed one of the board's dimensions");
        }

        return Optional.empty();
    }
}

