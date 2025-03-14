package cz.muni.fi.pv260.team4.tictactoe.infrastructure;

import cz.muni.fi.pv260.team4.tictactoe.board.Board;
import cz.muni.fi.pv260.team4.tictactoe.board.BoardFactory;
import cz.muni.fi.pv260.team4.tictactoe.element.AlphabeticElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TerminalBoardDisplayTest {

    @Mock
    private IOProvider ioProvider;

    private TerminalBoardDisplay terminalUI;

    @BeforeEach
    void setUp() {
        terminalUI = new TerminalBoardDisplay(ioProvider);
    }

    @Test
    void shouldDisplayEmptyMinimumBoardCorrectly() {
        // Arrange
        MatchConfiguration matchConfig = new MatchConfiguration(2, 3, 3, 3);
        Board board = new BoardFactory().createEmptyBoard(matchConfig, new AlphabeticElementSupplier());

        String expectedOutput = """
                   A   B   C
                1    |   |\s\s
                  ---+---+---
                2    |   |\s\s
                  ---+---+---
                3    |   |\s\s
                """;

        // Act
        terminalUI.displayBoard(board);

        // Assert
        verify(ioProvider).writeString(expectedOutput);

    }

    @Test
    void shouldDisplayFilledBoardCorrectly() {
        // Arrange
        MatchConfiguration matchConfig = new MatchConfiguration(2, 3, 3, 3);
        Board board = new BoardFactory().createEmptyBoard(matchConfig, new AlphabeticElementSupplier());

        board.setCell(0, 0, 'X');
        board.setCell(1, 0, 'O');
        board.setCell(1, 1, 'X');
        board.setCell(1, 2, 'X');
        board.setCell(2, 1, 'O');
        board.setCell(2, 2, 'O');

        String expectedOutput = """
                   A   B   C
                1  X |   |\s\s
                  ---+---+---
                2  O | X | X
                  ---+---+---
                3    | O | O
                """;

        // Act
        terminalUI.displayBoard(board);

        // Assert
        verify(ioProvider).writeString(expectedOutput);
    }
}
