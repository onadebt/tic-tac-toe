package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.Const;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public final class PlayerCountValidator implements InputValidator<Integer> {
    private final ElementSupplier elementSupplier;

    /**
     * Validate the number of players.
     *
     * @param numOfPlayers Number of players to validate
     * @return Optional containing error message if validation fails, otherwise empty
     */
    @Override
    public Optional<String> validate(final Integer numOfPlayers) {
        int maxPlayers = elementSupplier.getMaxOrder();

        if (numOfPlayers < Const.MINIMAL_PLAYER_COUNT) {
            return Optional.of("There have to be at least " + Const.MINIMAL_PLAYER_COUNT + " players");
        }

        if (numOfPlayers > maxPlayers) {
            return Optional.of("Number of players cannot exceed number of available elements");
        }

        return Optional.empty();
    }
}
