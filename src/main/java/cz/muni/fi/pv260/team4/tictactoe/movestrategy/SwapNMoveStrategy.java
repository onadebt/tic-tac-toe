package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.board.BoardCell;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.validators.NValidator;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@AllArgsConstructor
public final class SwapNMoveStrategy implements MoveStrategy<Integer> {
    private final IOProvider ioProvider;
    private final Random random;
    private final ElementSupplier elementSupplier;

    @Override
    public void executeMove(
            final Board board,
            final Character player
    ) {
        var setPositions = board.getFilledCells();

        var n = askN(setPositions.size());

        swapPositions(n, board, setPositions);
    }

    @Override
    public MoveParameterGatherer<Integer> getMoveParameterGatherer() {
        return null;
    }

    @Override
    public String toString() {
        return "Swap N Move";
    }

    private int askN(final int maxN) {
        return this.ioProvider.readInt(
                "Enter N: ", new NValidator(maxN)
        );
    }

    private void swapPositions(
            final int howManyToSwap,
            final Board board,
            final List<BoardCell> setPositions
    ) {
        var selectedPositions = random.ints(0, setPositions.size())
                .distinct()
                .limit(howManyToSwap)
                .boxed()
                .map(setPositions::get)
                .toList();

        var playerSymbols = IntStream.range(0, board.getMatchConfiguration().getPlayerCount())
                .boxed()
                .map(elementSupplier::getElement)
                .toList();

        for (var position : selectedPositions) {
            swapPosition(board, position, playerSymbols);
        }
    }

    private void swapPosition(
            final Board board,
            final BoardCell position,
            final List<Character> playerSymbols
    ) {
        var symbolIndex = playerSymbols.indexOf(position.player());

        var newIndex = random.ints(0, playerSymbols.size())
                .filter(i -> symbolIndex != i)
                .limit(1)
                .findFirst()
                .orElse(symbolIndex + 1 % playerSymbols.size());

        var newSymbol = playerSymbols.get(newIndex);
        board.setCell(position.row(), position.column(), newSymbol);
    }

}
