package ru.javarush.borets.module2.entity;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import static ru.javarush.borets.module2.entity.Edibility.edibility;
import static ru.javarush.borets.module2.entity.Edibility.putEdibility;
import static ru.javarush.borets.module2.field.Field.gameField;

public interface Predator {

      public default void eat(Animal predator, int index, int row, int column) {
          putEdibility();

        HashMap<String, Integer> edibilityForThisAnimal = edibility.get(predator.getName().toUpperCase());

        for (int i = index + 1; i < gameField[row][column].size(); i++) {
            if (gameField[row][column].get(i) instanceof Herbivores) {
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


