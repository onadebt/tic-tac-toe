package cz.muni.fi.pv260.team4.tictactoe.element;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
