package ru.javarush.borets.module2.entity;

import ru.javarush.borets.module2.Entities;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import static ru.javarush.borets.module2.loading_from_external_sources.Edibility.edibility;
import static ru.javarush.borets.module2.loading_from_external_sources.Edibility.putEdibility;
import static ru.javarush.borets.module2.field.Field.gameField;

public interface Predator {

    default void eat(Animal predator, int index, int row, int column) throws FileNotFoundException {

        putEdibility();
        HashMap<String, Integer> edibilityForThisAnimal = edibility.get(predator.getName().toUpperCase());

        for (int i = index + 1; i < gameField[row][column].size(); i++) {

            if (gameField[row][column].get(i) instanceof Caterpillar caterpillar) {
                if (edibilityForThisAnimal.containsKey(Entities.CATERPILLAR.toString())) {
                    Integer score = edibilityForThisAnimal.get(Entities.CATERPILLAR.toString());
                    int random = ThreadLocalRandom.current().nextInt(100);
                    if (random <= score) {
                        gameField[row][column].remove(i);
                        predator.setFoodCount(predator.getFoodCount() + caterpillar.getWeight());
                        predator.isAte = false;
                        break;
                    }
                }
            }

            else if ((gameField[row][column].get(i) instanceof Herbivores) && !(gameField[row][column].get(i) instanceof Caterpillar)){
                Animal herbivores = (Animal) gameField[row][column].get(i);

                if (edibilityForThisAnimal.containsKey(herbivores.getName().toUpperCase())) {
                    Integer score = edibilityForThisAnimal.get(herbivores.getName().toUpperCase());
                    int random = ThreadLocalRandom.current().nextInt(100);

                    if (random <= score) {
                        Animal temp = (Animal) gameField[row][column].get(i);
                        gameField[row][column].remove(i);
                        predator.setFoodCount(predator.getFoodCount() + temp.getWeight());
                        predator.isAte = true;
                        break;
                    }
                }
            }
        }
    }
}


