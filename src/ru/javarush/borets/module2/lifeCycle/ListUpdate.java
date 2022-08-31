package ru.javarush.borets.module2.lifeCycle;

import ru.javarush.borets.module2.entity.Alive;

import java.util.ArrayList;

import static ru.javarush.borets.module2.field.Field.gameField;

public interface ListUpdate {

    static void updateListOfAnimals(ArrayList<Alive> listOfAnimals){
        clearDayListOfAnimals(listOfAnimals);
        fillDayListOfAnimals(listOfAnimals);

    }
    private static void clearDayListOfAnimals(ArrayList<Alive> listOfAnimals) {
        for (int row = 1; row < gameField.length - 1; row++) {
            for (int column = 1; column < gameField[0].length - 1; column++) {
                listOfAnimals.clear();
            }
        }
    }

    static void fillDayListOfAnimals(ArrayList<Alive> listOfAnimals) {
        for (int row = 1; row < gameField.length - 1; row++) {
            for (int column = 1; column < gameField[0].length - 1; column++) {
                listOfAnimals.addAll(gameField[row][column]);
            }
        }
    }
}
