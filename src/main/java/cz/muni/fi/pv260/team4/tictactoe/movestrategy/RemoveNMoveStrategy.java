package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.GameState;
import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.board.BoardCell;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.validators.NValidator;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public final class RemoveNMoveStrategy implements MoveStrategy<Integer> {
    private final IOProvider ioProvider;
    private final Random random;

    @Override
    public void executeMove(final GameState gameState, final Character player) {
        var board = gameState.getCurrentBoard();
        var filledCells = board.getFilledCells();
        var howManyToRemove = askN(filledCells.size());
        removeCells(howManyToRemove, board, filledCells);
    }

    @Override
    public String toString() {
        return "Remove N";
    }

    private int askN(final int maxN) {
        return ioProvider.readInt(
                "Enter how many to remove", new NValidator(maxN, "Number of removals")
        );
    }

    private void removeCells(
            final int howManyToRemove,
            final Board board,
            final List<BoardCell> filledCells
    ) {
        var selectedPositions = random.ints(0, filledCells.size())
                .distinct()
                .limit(howManyToRemove)
                .boxed()
                .map(filledCells::get)
                .toList();

        for (var position : selectedPositions) {
            board.setCell(position.row(), position.column(), board.getElementSupplier().getEmptyElement());
        }
    }

}
