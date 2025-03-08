package cz.muni.fi.pv260.team4.tictactoe.infrastructure;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TerminalIOProviderTest extends StdStreamTest {

    @Test
    void shouldReturnLongOnInput() {
        var input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        var output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        var ioProvider = new TerminalIOProvider();
        var readValue = ioProvider.readLong("test", (_1) -> null);

        assertEquals(5L, readValue);
        assertTrue(output.toString().contains("test"));
    }

    @Test
    void shouldReturnLongOnInputAndDisplayDefaultValue() {
        var input = "42\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        var output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        var ioProvider = new TerminalIOProvider();
        var readValue = ioProvider.readLong("test", 69L, (_1) -> null);

        assertEquals(42L, readValue);
        assertTrue(output.toString().contains("test"));
        assertTrue(output.toString().contains("69"));
    }

    @Test
    void shouldReturnDefaultValueOnEmptyInput() {
        var input = "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        var output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        var ioProvider = new TerminalIOProvider();
        var readValue = ioProvider.readLong("test", 69L, (_1) -> null);

        assertEquals(69L, readValue);
        assertTrue(output.toString().contains("test"));
        assertTrue(output.toString().contains("69"));
    }

    @Test
    void shouldShowErrorMessageOnNonNumberInput() {
        var input = "a\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        var output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        var error = new ByteArrayOutputStream();
        System.setErr(new PrintStream(error));

        var ioProvider = new TerminalIOProvider();
        var readValue = ioProvider.readLong("test", 69L, (_1) -> null);

        assertEquals(1L, readValue);
        assertTrue(output.toString().contains("test"));
        assertTrue(error.toString().contains("Invalid number: a"));
    }

    @Test
    void shouldShowErrorMessageOnLongValidatorFailureInput() {
        var input = "1\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        var output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        var error = new ByteArrayOutputStream();
        System.setErr(new PrintStream(error));

        var ioProvider = new TerminalIOProvider();
        var readValue = ioProvider.readLong("test", 69L, (n) -> {
            if (n == 1L) {
                return "bad";
            }
            return null;
        });

        assertEquals(2L, readValue);
        assertTrue(output.toString().contains("test"));
        assertTrue(error.toString().contains("bad"));
    }

    @Test
    void shouldReturnStringOnInput() {
        var input = "abc\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        var output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        var ioProvider = new TerminalIOProvider();
        var readValue = ioProvider.readString("test", (_1) -> null);

        assertEquals("abc", readValue);
        assertTrue(output.toString().contains("test"));
    }

    @Test
    void shouldShowErrorMessageOnStringValidatorFailureInput() {
        var input = "a\nb\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        var output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        var error = new ByteArrayOutputStream();
        System.setErr(new PrintStream(error));

        var ioProvider = new TerminalIOProvider();
        var readValue = ioProvider.readString("test", (s) -> {
            if (s.equals("a")) {
                return "bad";
            }
            return null;
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
