package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.GameState;
import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.board.BoardCell;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.validators.NValidator;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public final class PlaceNMoveStrategy implements MoveStrategy<Integer> {
    private final IOProvider ioProvider;
    private final Random random;
    private final ElementSupplier elementSupplier;


    @Override
    public void executeMove(
            final GameState gameState,
            final Character player
    ) {
        var board = gameState.getCurrentBoard();
        var freePositions = board.getEmptyCells();

        var n = askN(freePositions.size());

        placeSymbols(n, board, freePositions);
    }

    private int askN(final int maxN) {
        return ioProvider.readInt(
                "Enter how many to place: ", new NValidator(maxN, "Number of random symbols to place")
        );
    }

    private void placeSymbols(
            final int howManyToPlace,
            final Board board,
            final List<BoardCell> freePositions
    ) {
        var selectedPositions = random.ints(0, freePositions.size())
                .distinct()
                .limit(howManyToPlace)
                .boxed()
                .map(freePositions::get)
                .toList();

        var playerSymbols = random.ints(0, board.getMatchConfiguration().getPlayerCount())
                .limit(howManyToPlace)
                .boxed()
                .map(elementSupplier::getElement)
                .toList();

        for (var position : selectedPositions) {
            board.setCell(position.row(), position.column(), playerSymbols.get(selectedPositions.indexOf(position)));
        }
    }

    @Override
    public String toString() {
        return "Place N";
    }
}
