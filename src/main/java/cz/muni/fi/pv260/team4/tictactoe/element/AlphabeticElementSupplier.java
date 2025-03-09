package cz.muni.fi.pv260.team4.tictactoe.element;

public final class AlphabeticElementSupplier<T> implements ElementSupplier {
    public AlphabeticElementSupplier() {

    }

    @Override
    public Character getElement(final int order) {
        return (char) ('a' + order);
    }

    @Override
    public Character getEmptyElement() {
        return ' ';
    }
}
