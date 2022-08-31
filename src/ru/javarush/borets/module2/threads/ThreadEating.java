package ru.javarush.borets.module2.threads;

import ru.javarush.borets.module2.entity.Alive;
import ru.javarush.borets.module2.entity.Animal;
import ru.javarush.borets.module2.entity.Caterpillar;
import ru.javarush.borets.module2.entity.Herbivores;
import ru.javarush.borets.module2.entity.Predator;

import java.util.ArrayList;

import static ru.javarush.borets.module2.Main.log;
import static ru.javarush.borets.module2.field.Field.gameField;

public class ThreadEating implements Runnable {

    public static void eatWithThread(int row, int column) throws Exception {

        ArrayList<Alive> tempArray = gameField[row][column];
        for (int i = 0; i < tempArray.size(); i++) {
            if (tempArray.get(i) instanceof Caterpillar caterpillar) {
                caterpillar.caterpillarEat(i, row, column);
            } else if ((tempArray.get(i) instanceof Animal animal) && (!animal.isAte)) {
                if (animal instanceof Herbivores herbivores) {
                    herbivores.eatPlant(animal, i, row, column);
                } else if (animal instanceof Predator predator) {
                    predator.eat(animal, i, row, column);
                }
            }
        }
    }

    @Override
    public void run() {
        for (int row = 1; row < gameField.length - 1; row++) {
            for (int column = 1; column < gameField[0].length - 1; column++) {
                try {
                    eatWithThread(row, column);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                log.info("We are reproduced " + Thread.currentThread().getName());
            }
        }
    }
}


