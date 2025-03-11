package cz.muni.fi.pv260.team4.tictactoe.element;

import cz.muni.fi.pv260.team4.tictactoe.exception.InvalidElementOrderException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AlphabeticElementSupplierTest {
    @Test
    public void shouldReturnEmptyElement() {
        AlphabeticElementSupplier supplier = new AlphabeticElementSupplier();
        assertNotNull(supplier.getEmptyElement());
        assertEquals(' ', supplier.getEmptyElement());
    }

    @Test
    public void shouldReturnCorrectFirstFewElements() {
        AlphabeticElementSupplier supplier = new AlphabeticElementSupplier();
        assertEquals('a', supplier.getElement(0));
        assertEquals('b', supplier.getElement(1));
        assertEquals('c', supplier.getElement(2));
        assertEquals('d', supplier.getElement(3));
    }

    @Test
    public void shouldReturnLastElementForMaxOrder() {
        AlphabeticElementSupplier supplier = new AlphabeticElementSupplier();
        assertEquals('z', supplier.getElement(supplier.getMaxOrder()));
    }

    @Test
    public void shouldThrowExceptionForInvalidElementOrder() {
        AlphabeticElementSupplier supplier = new AlphabeticElementSupplier();
        assertThrows(InvalidElementOrderException.class, () -> supplier.getElement(-1));
        assertThrows(InvalidElementOrderException.class, () -> supplier.getElement(supplier.getMaxOrder() + 1));
    }

}
