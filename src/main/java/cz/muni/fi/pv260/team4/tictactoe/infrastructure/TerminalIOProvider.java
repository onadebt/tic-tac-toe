package cz.muni.fi.pv260.team4.tictactoe.infrastructure;

import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.function.Function;

public final class TerminalIOProvider implements IOProvider {
    private final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    @Override
    public long readLong(
            final String prompt,
            final Function<Long, String> validator
    ) {
        return readLong(prompt, null, validator);
    }

    @Override
    public long readLong(final String prompt, final Long defaultValue, final Function<Long, String> validator) {
        long result;
        String errorMessage;

        do {
            var userInput = promptAndReadLine(prompt, defaultValue);

            if (defaultValue != null && userInput.trim().isEmpty()) {
                return defaultValue;
            }

            try {
                result = Long.parseLong(userInput);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number: " + userInput);
                continue;
            }

            errorMessage = validator.apply(result);
            if (errorMessage == null) {
                return result;
            }
            System.err.println(errorMessage);
        } while (true);
    }

    @Override
    public String readString(
            final String prompt,
            final Function<String, String> validator
    ) {
        String errorMessage;

        do {
            var userInput = promptAndReadLine(prompt, null);

            errorMessage = validator.apply(userInput);
            if (errorMessage == null) {
                return userInput;
            }
            System.err.println(errorMessage);
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
}
