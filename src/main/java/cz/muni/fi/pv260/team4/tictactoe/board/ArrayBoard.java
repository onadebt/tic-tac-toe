package cz.muni.fi.pv260.team4.tictactoe.board;

import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
public final class ArrayBoard implements Board {

    private final ElementSupplier elementSupplier;

    @Getter
    private final MatchConfiguration matchConfiguration;

    private final Character[][] grid;

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
        return grid[row][column];
    }

    @Override
    public void setCell(final int row, final int column, final Character cell) {
        grid[row][column] = cell;
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
