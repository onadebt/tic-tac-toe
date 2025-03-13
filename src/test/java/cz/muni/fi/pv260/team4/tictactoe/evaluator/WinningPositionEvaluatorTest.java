package cz.muni.fi.pv260.team4.tictactoe.evaluator;

import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.iterator.IteratorTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WinningPositionEvaluatorTest {

    @Mock
    ElementSupplier elementSupplier;

    @BeforeEach
    void setUp() {
        Mockito.when(elementSupplier.getEmptyElement()).thenReturn(' ');
    }

    private Optional<Character> evaluateBoard(TestBoard stub) {
        return new WinningPositionEvaluator(stub, IteratorTestConfig.DEFAULT_MATCH_CONFIG).getWinner();
    }

    @Test
    void shouldReturnNoWinnerOnEmptyBoard() {
        assertEquals(Optional.empty(), evaluateBoard(new TestBoard(IteratorTestConfig.EMPTY_BOARD, elementSupplier)));
    }

    @Test
    void shouldReturnNoWinnerOnNoWinnerBoardInstances() {
        assertEquals(Optional.empty(), evaluateBoard(new TestBoard(IteratorTestConfig.NO_WINNER_1, elementSupplier)));
        assertEquals(Optional.empty(), evaluateBoard(new TestBoard(IteratorTestConfig.NO_WINNER_2, elementSupplier)));
    }

    @Test
    void shouldReturnWinnerXOnWinnerXBoardInstances() {
        assertEquals(Optional.of('X'), evaluateBoard(new TestBoard(IteratorTestConfig.WINNER_X_1, elementSupplier)));
        assertEquals(Optional.of('X'), evaluateBoard(new TestBoard(IteratorTestConfig.WINNER_X_2, elementSupplier)));
        assertEquals(Optional.of('X'), evaluateBoard(new TestBoard(IteratorTestConfig.WINNER_X_3, elementSupplier)));
        assertEquals(Optional.of('X'), evaluateBoard(new TestBoard(IteratorTestConfig.WINNER_X_4, elementSupplier)));
    }

}