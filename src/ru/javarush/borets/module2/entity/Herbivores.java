package ru.javarush.borets.module2.entity;

import static ru.javarush.borets.module2.field.Field.gameField;

public interface Herbivores {

    default void eatPlant(Animal animal, int index, int row, int column) {
        for (int i = index + 1; i < gameField[row][column].size(); i++) {
            if (gameField[row][column].get(i) instanceof Plant) {
                Plant temp = (Plant) gameField[row][column].get(i);
                gameField[row][column].remove(i);
                animal.setFoodCount(animal.getFoodCount() + temp.getWeight());
                animal.isAte = true;
                break;
            }
        }
    }
}


