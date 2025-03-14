package cz.muni.fi.pv260.team4.tictactoe.evaluator;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

@AllArgsConstructor
public final class WinningPositionEvaluator {

    private Board board;
    private MatchConfiguration matchConfiguration;

    /**
     * Determines if there is a winning sequence on the board.
     * <p>
     * This method iterates through all possible winning lines (rows, columns, and diagonals)
     * to check for a sequence that meets the winning conditions specified in the
     * {@link MatchConfiguration}.
     * </p>
     *
     * <p>It collects iterators for:</p>
     * <ul>
     *     <li>All rows (left to right)</li>
     *     <li>All columns (top to bottom)</li>
     *     <li>All ascending diagonals (bottom-left to top-right)</li>
     *     <li>All descending diagonals (top-left to bottom-right)</li>
     * </ul>
     *
     * <p>The method applies the {@link #detectWinningSequence(Iterator)} function to each iterator and
     * returns the first non-empty winning result found.</p>
     *
     * @return an {@link Optional} containing the winning character if a winning sequence is found,
     * otherwise {@code Optional.empty()}
     */
    public Optional<Character> getWinner() {
        Collection<Iterator<Character>> iterators = createBoardIterators();

        return processIterators(iterators);
    }

    @NotNull
    private Optional<Character> processIterators(final Collection<Iterator<Character>> iterators) {
        return iterators.stream()
                .map(this::detectWinningSequence)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
    }

    @NotNull
    private Collection<Iterator<Character>> createBoardIterators() {
        Collection<Iterator<Character>> iterators = new ArrayList<>();

        // First construct all possible iterators for the Board

        for (int row = 0; row < matchConfiguration.boardHeight(); row++) {
            iterators.add(board.getHorizontalIterator(matchConfiguration, row));
            iterators.add(board.getAscendingDiagonalIterator(matchConfiguration, row));
            iterators.add(board.getDescendingDiagonalIterator(matchConfiguration, row));
        }

        for (int column = 0; column < matchConfiguration.boardWidth(); column++) {
            iterators.add(board.getVerticalIterator(matchConfiguration, column));
        }
        return iterators;
    }

    private Optional<Character> detectWinningSequence(final Iterator<Character> characterIterator) {
        Optional<Character> currentSequence = Optional.empty();
        int currentSequenceLength = 0;
        while (characterIterator.hasNext()) {
            Character character = characterIterator.next();

            if (character.equals(board.getElementSupplier().getEmptyElement())) {
                currentSequence = Optional.empty();
                currentSequenceLength = 0;
                continue;
            }

            if (currentSequence.isEmpty() || !currentSequence.get().equals(character)) {
                currentSequence = Optional.of(character);
                currentSequenceLength = 1;
            } else {
                currentSequenceLength++;
            }

            if (currentSequenceLength == matchConfiguration.winningSequenceLength()) {
                return currentSequence;
            }
        }

        return Optional.empty();
    }
}
