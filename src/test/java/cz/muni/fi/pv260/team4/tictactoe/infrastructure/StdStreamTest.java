package cz.muni.fi.pv260.team4.tictactoe.infrastructure;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.InputStream;
import java.io.PrintStream;

public class StdStreamTest {
    private InputStream originalStdIn;
    private PrintStream originalStdOut;
    private PrintStream originalStdErr;

    /**
     * Save original standard streams.
     */
    @BeforeEach
    void setUp() {
        originalStdIn = System.in;
        originalStdOut = System.out;
        originalStdErr = System.err;
    }

    /**
     * Restore original standard streams.
     */
    @AfterEach
    void tearDown() {
        System.setIn(originalStdIn);
        System.setOut(originalStdOut);
        System.setErr(originalStdErr);
    }
}
