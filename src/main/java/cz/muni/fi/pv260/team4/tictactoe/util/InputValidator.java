package cz.muni.fi.pv260.team4.tictactoe.util;

import java.util.Optional;

public interface InputValidator<T> {
    /**
     * Validate value and return error message.
     *
     * @param value value to be validated
     * @return empty for valid value or error message
     */
    Optional<String> validate(T value);
}
