package cz.muni.fi.pv260.team4.tictactoe.element;

import cz.muni.fi.pv260.team4.tictactoe.exception.InvalidElementOrderException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlphabeticElementSupplierTest {

    @Test
    public void testEmptyElement() {
        AlphabeticElementSupplier supplier = new AlphabeticElementSupplier();
        assertNotNull(supplier.getEmptyElement());
        assertEquals(' ', supplier.getEmptyElement());
    }

    @Test
    public void testFewElements() {
        AlphabeticElementSupplier supplier = new AlphabeticElementSupplier();
        assertEquals('a', supplier.getElement(0));
        assertEquals('b', supplier.getElement(1));
        assertEquals('c', supplier.getElement(2));
        assertEquals('d', supplier.getElement(3));
    }

    @Test
    public void testMaxElement() {
        AlphabeticElementSupplier supplier = new AlphabeticElementSupplier();
        assertEquals('z', supplier.getElement(supplier.getMaxOrder()));
    }

    @Test
    public void testInvalidElementOrder() {
        AlphabeticElementSupplier supplier = new AlphabeticElementSupplier();
        assertThrows(InvalidElementOrderException.class, () -> supplier.getElement(-1));
        assertThrows(InvalidElementOrderException.class, () -> supplier.getElement(supplier.getMaxOrder() + 1));
    }
}
