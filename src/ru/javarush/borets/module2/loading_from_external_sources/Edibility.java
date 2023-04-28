package ru.javarush.borets.module2.loading_from_external_sources;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import static ru.javarush.borets.module2.Constants.PATH_TO_EDIBILITY_FILE;

public class Edibility {

    public static HashMap<String, HashMap<String, Integer>> edibility = new HashMap<>();

    public static HashMap<String, HashMap<String, Integer>> putEdibility() throws FileNotFoundException {
        try {
            edibility = readJsonFromFile(new File(PATH_TO_EDIBILITY_FILE));
        } catch (IOException e) {
            throw new FileNotFoundException("Problem with file: " + PATH_TO_EDIBILITY_FILE + " May be file not exists");
        }
        return edibility;
    }

    private static HashMap<String, HashMap<String, Integer>> readJsonFromFile(File inFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        byte[] json = Files.readAllBytes(inFile.toPath());
        return mapper.readValue(json, HashMap.class);
    }
}
