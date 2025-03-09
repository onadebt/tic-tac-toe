package cz.muni.fi.pv260.team4.tictactoe.board;

import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import lombok.Getter;

import java.util.Arrays;


public class ArrayBoard implements Board {

    private final ElementSupplier elementSupplier;

    @Getter
    private final MatchConfiguration matchConfiguration;

    private final Character[][] grid;

    public ArrayBoard(ElementSupplier elementSupplier, MatchConfiguration matchConfiguration, Character[][] grid) {
        this.elementSupplier = elementSupplier;
        this.matchConfiguration = matchConfiguration;
        this.grid = grid;
    }

    public static Character[][] getEmptyGrid(MatchConfiguration matchConfiguration, ElementSupplier elementSupplier) {
        Character[][] grid = new Character[(int) matchConfiguration.boardHeight()][(int) matchConfiguration.boardWidth()];
        for(int i = 0; i < matchConfiguration.boardHeight(); i++) {
            Arrays.fill(grid[i], elementSupplier.getEmptyElement());
        }

        return grid;
    }

    @Override
    public Character getCell(int row, int column) {
        return grid[row][column];
    }

    @Override
    public void setCell(int row, int column, Character cell) {
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
