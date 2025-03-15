package cz.muni.fi.pv260.team4.tictactoe.infrastructure;

import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.validators.InputValidator;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.Scanner;

public final class TerminalIOProvider implements IOProvider {
    private final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    @Override
    public int readInt(
            final String prompt,
            final InputValidator<Integer> validator
    ) {
        return readInt(prompt, null, validator);
    }

    @Override
    public int readInt(final String prompt, final Integer defaultValue, final InputValidator<Integer> validator) {
        int result;
        Optional<String> errorMessage;

        do {
            var userInput = promptAndReadLine(prompt, defaultValue);

            if (defaultValue != null && userInput.trim().isEmpty()) {
                return defaultValue;
            }

            try {
                result = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number: " + userInput);
                continue;
            }

            errorMessage = validator.validate(result);
            if (errorMessage.isEmpty()) {
                return result;
            }
            System.err.println(errorMessage.get());
        } while (true);
    }

    @Override
    public String readString(
            final String prompt,
            final InputValidator<String> validator
    ) {
        Optional<String> errorMessage;

        do {
            var userInput = promptAndReadLine(prompt, null);

            errorMessage = validator.validate(userInput);
            if (errorMessage.isEmpty()) {
                return userInput;
            }
            System.err.println(errorMessage.get());
        } while (true);
    }

    /**
     * Prompt the user, with an optional default value, and read one line of user input.
     *
     * @param prompt       to show to the user
     * @param defaultValue to use if not null on empty input
     * @return the read line
     */
    private String promptAndReadLine(final String prompt, final Object defaultValue) {
        if (defaultValue == null) {
            System.out.printf("? %s: ", prompt);
        } else {
            System.out.printf("? %s [default: %s]: ", prompt, defaultValue);
        }
        System.out.flush();

        return scanner.nextLine();
    }


    @Override
    public void writeString(final String value) {
        System.out.println(value);
    }

    @Override
    public void newline() {
        System.out.println();
    }
}
