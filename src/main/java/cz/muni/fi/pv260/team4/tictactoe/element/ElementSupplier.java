package cz.muni.fi.pv260.team4.tictactoe.element;

/**
 * A class dedicated to supplying elements (characters) into each cell of the game board.
 */
public interface ElementSupplier {

    /**
     * Obtain n-th element (character).
     * @param order Element order - player number in our case
     * @return Symbol for n-th element
     */
    Character getElement(int order);

    /**
     * Obtain character that the game is going to consider as 'empty' cell.
     * @return Character that is going to be considered as 'empty' cell
     */
    Character getEmptyElement();

}
