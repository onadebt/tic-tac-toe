package cz.muni.fi.pv260.team4.tictactoe.iterator;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import lombok.AllArgsConstructor;

import java.util.Iterator;

@AllArgsConstructor
public abstract class BoardIterator implements Iterator<Character> {

    private final Board board;
    private final MatchConfiguration matchConfiguration;

    private int row;
    private int column;

    @Override
    public boolean hasNext() {
        return column < matchConfiguration.boardWidth() && row < matchConfiguration.boardHeight();
    }

    @Override
    public Character next() {
        Character cell = board.getCell(row, column);

        updatePosition();

        return cell;
    }

    public abstract void updatePosition();

    public void incrementColumn() {
        column++;
    }

    public void incrementRow() {
        row++;
    }

    public void decrementRow(){
        row--;
    }
}
