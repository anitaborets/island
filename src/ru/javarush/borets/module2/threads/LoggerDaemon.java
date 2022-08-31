package ru.javarush.borets.module2.threads;

import ru.javarush.borets.module2.logger.LoggerInitializationException;

import static ru.javarush.borets.module2.Main.log;

public class LoggerDaemon implements Runnable {
    @Override
    public void run() {
        try {
            log.info("We are reproduced" + Thread.currentThread().getName());
        } catch (LoggerInitializationException e) {
            throw new LoggerInitializationException(e.getMessage());
        }
    }
}
