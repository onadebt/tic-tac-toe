package cz.muni.fi.pv260.team4.tictactoe.e2e;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import cz.muni.fi.pv260.team4.tictactoe.Main;

import static org.junit.jupiter.api.Assertions.assertEquals;

class E2ETests {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errorStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        // Redirect system output
        System.setOut(new PrintStream(outputStream));
        System.setErr(new PrintStream(errorStream));
    }

    @AfterEach
    void tearDown() {
        // Restore system output and input
        System.setOut(System.out);
        System.setIn(System.in);
        System.setErr(System.err);
    }

    @ParameterizedTest
    @CsvSource({
            "src/test/resources/e2e/happy_path_input.txt, src/test/resources/e2e/happy_path_output.txt,"
                    + " src/test/resources/e2e/happy_path_error.txt",
            "src/test/resources/e2e/invalid_input_path_input.txt,"
                    + " src/test/resources/e2e/invalid_input_path_output.txt,"
                    + " src/test/resources/e2e/invalid_input_path_error.txt",
    })
    void shouldSuccessfullyFinish(final String inputFile,
                                  final String outputFile, final String errorFile) throws Exception {
        Path inputPath = Path.of(inputFile).toAbsolutePath().normalize();
        Path outputPath = Path.of(outputFile).toAbsolutePath().normalize();
        Path errorPath = Path.of(errorFile).toAbsolutePath().normalize();

        if (!Files.exists(inputPath) || !Files.isReadable(inputPath)) {
            throw new FileNotFoundException("Input file not found or not readable: " + inputPath);
        }
        if (!Files.exists(outputPath) || !Files.isReadable(outputPath)) {
            throw new FileNotFoundException("Expected output file not found or not readable: " + outputPath);
        }
        if (!Files.exists(errorPath) || !Files.isReadable(errorPath)) {
            throw new FileNotFoundException("Expected error file not found or not readable: " + errorPath);
        }

        // Arrange
        String expectedOutput = Files.readString(outputPath, StandardCharsets.UTF_8);
        String expectedError = Files.readString(errorPath, StandardCharsets.UTF_8);
        System.setIn(new FileInputStream(inputPath.toFile())); // Redirect system input

        // Act
        Main.main(new String[]{});

        // Assert
        assertEquals(expectedOutput.trim(), outputStream.toString().trim());
        assertEquals(expectedError.trim(), errorStream.toString().trim());
    }
}
