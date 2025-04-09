package cz.muni.fi.pv260.team4.tictactoe;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import lombok.Getter;

import java.util.Stack;

@Getter
public final class GameState {

    private final Stack<Board> moveHistory = new Stack<>();

    public GameState(Board board) {
        moveHistory.push(board);
    }

    public Board getCurrentBoard() {
        return moveHistory.peek();
    }

    public void saveState() {
        moveHistory.add(getCurrentBoard().createCopy());
    }
}
