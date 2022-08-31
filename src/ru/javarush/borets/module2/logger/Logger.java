package ru.javarush.borets.module2.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String SEPARATOR = System.getProperty("file.separator");
    private static final String OUTPUT_DIRECTORY = "logs";
    private static final String OUTPUT_FILENAME = "output.log";
    private static final String OUTPUT_FILEPATH = OUTPUT_DIRECTORY + SEPARATOR + OUTPUT_FILENAME;

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    private static Logger INSTANCE;

    private Path outputFilePath;

    public Logger() throws IOException {
        validateAndCreateDirectory();
        validateAndCreateLogFile();
        outputFilePath = Path.of(OUTPUT_FILEPATH);
    }

    private void validateAndCreateLogFile() throws IOException {
        Path outputFile = Path.of(OUTPUT_FILEPATH);
        if (!Files.exists(outputFile)) {
            Files.createFile(outputFile);
        }
    }

    private void validateAndCreateDirectory() throws IOException {
        Path outputDirectory = Path.of(OUTPUT_DIRECTORY);
        if (!Files.exists(outputDirectory)) {
            Files.createDirectory(outputDirectory);
        }
    }

    public static Logger getINSTANCE() {
        if (INSTANCE == null) {
            try {
                INSTANCE = new Logger();
            } catch (IOException e) {
                throw new LoggerInitializationException("Error logger initialization");
            }
        }
        return INSTANCE;
    }

    public void debug(String message) {
        writeLog("DEBUG" + message);
    }

    public void info(String message) {
        writeLog("INFO" + message);
    }

    public void error(String message) {
        writeLog("ERROR" + message);
    }

    private void writeLog(String message) {
        synchronized (INSTANCE) {
            try {
                String timestamp = "[" + (LocalDateTime.now().format(DATE_TIME_FORMATTER) + "]" + Thread.currentThread().getName());
                Files.writeString(outputFilePath, timestamp + message + "\n", StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.err.println("Logger does not work properly.Error message " + e.getMessage());
            }
        }
    }
}
