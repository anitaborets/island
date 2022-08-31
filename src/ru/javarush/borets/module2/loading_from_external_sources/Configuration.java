package ru.javarush.borets.module2.loading_from_external_sources;

import lombok.Getter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static ru.javarush.borets.module2.Constants.PATH_TO_PROPERTIES;

@Getter
public class Configuration {
    public static Map<String, Integer> appConfiguration = new HashMap<>();

    public static void getProperties() throws IOException {
        Properties appProps = new Properties();
        File file = new File(PATH_TO_PROPERTIES);

        try (InputStream inputStream = new FileInputStream(file)) {
            appProps.load(inputStream);
            Integer sizeX = Integer.parseInt(appProps.getProperty("WIDTH", String.valueOf(3)));
            appConfiguration.put("sizeX", sizeX);
            Integer sizeY = Integer.parseInt(appProps.getProperty("HEIGHT", String.valueOf(3)));
            appConfiguration.put("sizeY", sizeY);
            Integer dayOfLife = Integer.parseInt(appProps.getProperty("DAY_OF_LIFE", String.valueOf(3)));
            appConfiguration.put("DAY_OF_LIFE", dayOfLife);

        } catch (IOException e) {
            throw new FileNotFoundException("Problem with file: " + PATH_TO_PROPERTIES + " May be file not exists");
        }

    }
}

