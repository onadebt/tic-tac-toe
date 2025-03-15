package cz.muni.fi.pv260.team4.tictactoe.evaluator;

import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.iterator.IteratorTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class WinningPositionEvaluatorTest {

    @Mock
    private ElementSupplier elementSupplier;

    @BeforeEach
    void setUp() {
        Mockito.when(elementSupplier.getEmptyElement()).thenReturn(' ');
    }

    private Optional<Character> evaluateBoard(final char[][] stub) {
        return new WinningPositionEvaluator(
                new TestBoard(stub, elementSupplier),
                IteratorTestConfig.DEFAULT_MATCH_CONFIG)
                .getWinner();
    }

    @Test
    void shouldReturnNoWinnerOnEmptyBoard() {
        assertEquals(Optional.empty(), evaluateBoard(IteratorTestConfig.getEmptyBoard()));
    }

    @Test
    void shouldReturnNoWinnerOnNoWinnerBoardInstances() {
        assertEquals(Optional.empty(), evaluateBoard(IteratorTestConfig.getNoWinner1()));
        assertEquals(Optional.empty(), evaluateBoard(IteratorTestConfig.getNoWinner2()));
    }

    @Test
    void shouldReturnWinnerXOnWinnerXBoardInstances() {
        assertEquals(Optional.of('X'), evaluateBoard(IteratorTestConfig.getWinnerX1()));
        assertEquals(Optional.of('X'), evaluateBoard(IteratorTestConfig.getWinnerX2()));
        assertEquals(Optional.of('X'), evaluateBoard(IteratorTestConfig.getWinnerX3()));
        assertEquals(Optional.of('X'), evaluateBoard(IteratorTestConfig.getWinnerX4()));
    }
}
