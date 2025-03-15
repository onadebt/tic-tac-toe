package cz.muni.fi.pv260.team4.tictactoe.interfaces;

import cz.muni.fi.pv260.team4.tictactoe.validators.InputValidator;

public interface IOProvider {
    /**
     * Read int value from the user.
     * <p>
     * If the validation fails, user will be prompted again for the value until validation succeeds.
     *
     * @param prompt    question to display
     * @param validator return empty for valid input or string error message
     * @return read int value
     */
    int readInt(String prompt, InputValidator<Integer> validator);

    /**
     * Read int value from the user or use default on empty input.
     * <p>
     * If the validation fails, user will be prompted again for the value until validation succeeds.
     *
     * @param prompt    question to display
     * @param defaultValue value to use on empty input
     * @param validator return empty for valid input or string error message
     * @return read int value
     */
    int readInt(String prompt, Integer defaultValue, InputValidator<Integer> validator);

    /**
     * Read String value from the user.
     * <p>
     * If the validation fails, user will be prompted again for the value until validation succeeds.
     *
     * @param prompt    question to display
     * @param validator return empty for valid input or a string error message
     * @return read string value
     */
    String readString(String prompt, InputValidator<String> validator);

    /**
     * Display String value to a user.
     *
     * @param value text to display
     */
    void writeString(String value);


    /**
     * Prints a new line. Created to make the provider platform independent.
     */
    void newline();
}
