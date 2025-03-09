package cz.muni.fi.pv260.team4.tictactoe.element;

public class AlphabeticElementSupplier<T> implements ElementSupplier {
    @Override
    public Character getElement(int order) {
        return (char) ('a' + order);
    }

    @Override
    public Character getEmptyElement() {
        return ' ';
    }
}
