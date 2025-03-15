package cz.muni.fi.pv260.team4.tictactoe.board;

import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;

/**
 * A factory class responsible for creating instances of {@link Board}.
 * This class provides methods to create different types of board instances.
 */
public final class BoardFactory {

    /**
     * Constructs a new {@code BoardFactory} instance.
     * This class does not maintain any state and serves as a utility for board creation.
     */
    public BoardFactory() {
        // Default constructor
    }

    /**
     * Creates an empty board instance based on the provided match configuration and element supplier.
     *
     * @param matchConfiguration the configuration defining the board's size and other properties
     * @param elementSupplier the supplier providing default elements for the board
     * @return a new {@link Board} instance initialized as empty
     */
    public Board createEmptyBoard(final MatchConfiguration matchConfiguration, final ElementSupplier elementSupplier) {
        return new ArrayBoard(
                elementSupplier,
                matchConfiguration,
                ArrayBoard.getEmptyGrid(matchConfiguration, elementSupplier));
    }
}
