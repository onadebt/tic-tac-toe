package cz.muni.fi.pv260.team4.tictactoe.infrastructure;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TerminalIOProviderTest extends StdStreamTest {

    @Test
    void shouldReturnLongOnInput() {
        var input = "5" + System.lineSeparator();
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        var output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        var ioProvider = new TerminalIOProvider();
        var readValue = ioProvider.readInt("test", (_1) -> Optional.empty());

        assertEquals(5L, readValue);
        assertTrue(output.toString().contains("test"));
    }

    @Test
    void shouldReturnLongOnInputAndDisplayDefaultValue() {
        var input = "42" + System.lineSeparator();
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        var output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        var ioProvider = new TerminalIOProvider();
        var readValue = ioProvider.readInt("test", 69, (_1) -> Optional.empty());

        assertEquals(42L, readValue);
        assertTrue(output.toString().contains("test"));
        assertTrue(output.toString().contains("69"));
    }

    @Test
    void shouldReturnDefaultValueOnEmptyInput() {
        var input = System.lineSeparator();
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        var output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        var ioProvider = new TerminalIOProvider();
        var readValue = ioProvider.readInt("test", 69, (_1) -> Optional.empty());

        assertEquals(69L, readValue);
        assertTrue(output.toString().contains("test"));
        assertTrue(output.toString().contains("69"));
    }

    @Test
    void shouldShowErrorMessageOnNonNumberInput() {
        var input = "a%s1%s".formatted(System.lineSeparator(), System.lineSeparator());
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        var output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        var error = new ByteArrayOutputStream();
        System.setErr(new PrintStream(error));

        var ioProvider = new TerminalIOProvider();
        var readValue = ioProvider.readInt("test", 69, (_1) -> Optional.empty());

        assertEquals(1L, readValue);
        assertTrue(output.toString().contains("test"));
        assertTrue(error.toString().contains("Invalid number: a"));
    }

    @Test
    void shouldShowErrorMessageOnLongValidatorFailureInput() {
        var input = "1%s2%s".formatted(System.lineSeparator(), System.lineSeparator());
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        var output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        var error = new ByteArrayOutputStream();
        System.setErr(new PrintStream(error));

        var ioProvider = new TerminalIOProvider();
        var readValue = ioProvider.readInt("test", 69, (n) -> {
            if (n == 1L) {
                return Optional.of("bad");
            }
            return Optional.empty();
        });

        assertEquals(2L, readValue);
        assertTrue(output.toString().contains("test"));
        assertTrue(error.toString().contains("bad"));
    }

    @Test
    void shouldReturnStringOnInput() {
        var input = "abc%s".formatted(System.lineSeparator());
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        var output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        var ioProvider = new TerminalIOProvider();
        var readValue = ioProvider.readString("test", (_1) -> Optional.empty());

        assertEquals("abc", readValue);
        assertTrue(output.toString().contains("test"));
    }

    @Test
    void shouldShowErrorMessageOnStringValidatorFailureInput() {
        var input = "a%sb%s".formatted(System.lineSeparator(), System.lineSeparator());
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        var output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        var error = new ByteArrayOutputStream();
        System.setErr(new PrintStream(error));

        var ioProvider = new TerminalIOProvider();
        var readValue = ioProvider.readString("test", (s) -> {
            if (s.equals("a")) {
                return Optional.of("bad");
            }
            return Optional.empty();
        });

        assertEquals("b", readValue);
        assertTrue(output.toString().contains("test"));
        assertTrue(error.toString().contains("bad"));
    }

    @Test
    void shouldWriteStringOutput() {
        var output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        var ioProvider = new TerminalIOProvider();
        ioProvider.writeString("Test output");

        assertTrue(output.toString().contains("Test output"));
    }
}
