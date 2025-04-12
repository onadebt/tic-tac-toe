package cz.muni.fi.pv260.team4.tictactoe;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import lombok.Getter;

import java.util.Stack;

/**
 * Represents the state of a TicTacToe game, maintaining a history of board states.
 *
 * <p>This class allows tracking of moves and provides functionality to access
 * the current board and save new states after each move, which is necessary for the rollback strategy.</p>
 */
@Getter
public final class GameState {

    private final Stack<Board> moveHistory = new Stack<>();

    /**
     * Constructs a new {@code GameState} with the initial board state.
     *
     * @param board the initial state of the game board
     */
    public GameState(final Board board) {
        moveHistory.push(board);
    }

    /**
     * Returns the current board state.
     *
     * @return the board at the top of the move history stack
     */
    public Board getCurrentBoard() {
        return moveHistory.peek();
    }

    /**
     * Saves the current board state to the move history by adding a deep copy of it.
     * This should be called after each valid move to preserve the state.
     */
    public void saveState() {
        moveHistory.add(getCurrentBoard().createCopy());
    }
}
