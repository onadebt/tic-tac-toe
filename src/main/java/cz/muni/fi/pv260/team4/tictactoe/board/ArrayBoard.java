package cz.muni.fi.pv260.team4.tictactoe.board;

import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.exception.BoardPositionOutOfBoundsException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
public final class ArrayBoard implements Board {

    private final ElementSupplier elementSupplier;

    @Getter
    private final MatchConfiguration matchConfiguration;

    private final Character[][] grid;

    /**
     * Allocates and fills a new grid with empty elements.
     * @param matchConfiguration Configuration for the match, from which the grid dimensions are obtained
     * @param elementSupplier Element supplier for the match that defines the empty element
     * @return Allocated grid filled with empty characters
     */
    public static Character[][] getEmptyGrid(
            final MatchConfiguration matchConfiguration,
            final ElementSupplier elementSupplier) {
        Character[][] grid = new Character
                [(int) matchConfiguration.boardHeight()]
                [(int) matchConfiguration.boardWidth()];
        for (int i = 0; i < matchConfiguration.boardHeight(); i++) {
            Arrays.fill(grid[i], elementSupplier.getEmptyElement());
        }

        return grid;
    }

    @Override
    public Character getCell(final int row, final int column) {
        validateBounds(row, column);
        return grid[row][column];
    }

    @Override
    public void setCell(final int row, final int column, final Character cell) {
        validateBounds(row, column);
        grid[row][column] = cell;
    }

    /**
     * Validates whether the given row and column indices are within the board's bounds.
     *
     * @param row    The row index to check.
     * @param column The column index to check.
     * @throws BoardPositionOutOfBoundsException if the row or column index is out of bounds.
     */
    private void validateBounds(final int row, final int column) {
        if (row < 0 || row >= getMatchConfiguration().boardHeight()
                || column < 0 || column >= getMatchConfiguration().boardWidth()) {
            throw new BoardPositionOutOfBoundsException(row, column, grid.length, grid[0].length);
        }
    }

    @Override
    public ElementSupplier getElementSupplier() {
        return elementSupplier;
    }

    @Override
    public Board createCopy() {
        Character[][] gridCopy = Arrays.copyOf(grid, grid.length); // Copies top-level array references

        for (int i = 0; i < grid.length; i++) {
            gridCopy[i] = Arrays.copyOf(grid[i], grid[i].length); // Copies actual data
        }

        return new ArrayBoard(elementSupplier, matchConfiguration, gridCopy);
    }

}
