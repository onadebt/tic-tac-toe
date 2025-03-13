package cz.muni.fi.pv260.team4.tictactoe.evaluator;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class WinningPositionEvaluator {

    public Board board;
    public MatchConfiguration matchConfiguration;

    public Optional<Character> getWinner() {
        Collection<Iterator<Character>> iterators = new ArrayList<>();

        for(int row = 0; row < matchConfiguration.boardHeight(); row++){
            iterators.add(board.getHorizontalIterator(matchConfiguration, row));
            iterators.add(board.getAscendingDiagonalIterator(matchConfiguration, row));
            iterators.add(board.getDescendingDiagonalIterator(matchConfiguration, row));
        }

        for(int column = 0; column < matchConfiguration.boardWidth(); column++){
            iterators.add(board.getVerticalIterator(matchConfiguration, column));
        }

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

            if(character.equals(board.getElementSupplier().getEmptyElement())) {
                currentSequence = Optional.empty();
                currentSequenceLength = 0;
                continue;
            }

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

        return Optional.empty();
    }
}
