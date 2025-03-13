package cz.muni.fi.pv260.team4.tictactoe.evaluator;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class WinningPositionEvaluator {

    public Board board;
    public MatchConfiguration matchConfiguration;

    public Optional<Character> getWinner() {
        Collection<Iterator<Character>> iterators = List.of(
                board.getHorizontalIterator(matchConfiguration, 0),
                board.getVerticalIterator(matchConfiguration, 0),
                board.getDescendingDiagonalIterator(matchConfiguration, 0),
                board.getAscendingDiagonalIterator(matchConfiguration, 0)
        );

        return iterators.stream()
                .map(this::applyIterator)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
    }

    private Optional<Character> applyIterator(Iterator<Character> characterIterator) {
        Optional<Character> currentSequence = Optional.empty();
        int currentSequenceLength = 0;
        while (characterIterator.hasNext()) {
            Character character = characterIterator.next();
            if(currentSequence.isEmpty() || !currentSequence.get().equals(character)) {
                currentSequence = Optional.of(character);
                currentSequenceLength = 1;
            } else{
                currentSequenceLength++;
            }

            if(currentSequenceLength == matchConfiguration.winningSequenceLength()) {
                return currentSequence;
            }
        }

        return currentSequence;
    }
}
