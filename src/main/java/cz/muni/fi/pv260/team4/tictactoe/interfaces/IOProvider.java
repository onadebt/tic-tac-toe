package cz.muni.fi.pv260.team4.tictactoe.interfaces;

import java.util.function.Function;

public interface IOProvider {
    /**
     * Read long value from the user.
     * <p>
     * If the validation fails, user will be prompted again for the value until validation succeeds.
     *
     * @param prompt    question to display
     * @param validator return null for valid input or string error message
     * @return read long value
     */
    long readLong(String prompt, Function<Long, String> validator);

    /**
     * Read long value from the user or use default on empty input.
     * <p>
     * If the validation fails, user will be prompted again for the value until validation succeeds.
     *
     * @param prompt    question to display
     * @param defaultValue value to use on empty input
     * @param validator return null for valid input or string error message
     * @return read long value
     */
    long readLong(String prompt, Long defaultValue, Function<Long, String> validator);

    /**
     * Read String value from the user.
     * <p>
     * If the validation fails, user will be prompted again for the value until validation succeeds.
     *
     * @param prompt    question to display
     * @param validator return null for valid input or a string error message
     * @return read string value
     */
    String readString(String prompt, Function<String, String> validator);

    /**
     * Display String value to a user.
     *
     * @param value text to display
     */
    void writeString(String value);
}
