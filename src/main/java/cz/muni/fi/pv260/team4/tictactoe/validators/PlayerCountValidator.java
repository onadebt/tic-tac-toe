package cz.muni.fi.pv260.team4.tictactoe.validators;

import cz.muni.fi.pv260.team4.tictactoe.Const;
import cz.muni.fi.pv260.team4.tictactoe.element.ElementSupplier;

import java.util.Optional;

public final class PlayerCountValidator implements InputValidator<Long> {
    private final ElementSupplier elementSupplier;

    public PlayerCountValidator(ElementSupplier elementSupplier) {
        this.elementSupplier = elementSupplier;
    }

    @Override
    public Optional<String> validate(final Long numOfPlayers) {
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
