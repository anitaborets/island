package ru.javarush.borets.module2.threads;

import org.codehaus.jackson.org.objectweb.asm.Type;
import ru.javarush.borets.module2.Entities;
import ru.javarush.borets.module2.entity.Alive;
import ru.javarush.borets.module2.entity.Animal;
import ru.javarush.borets.module2.entity.Caterpillar;
import ru.javarush.borets.module2.entity.Herbivores;
import ru.javarush.borets.module2.entity.Predator;
import ru.javarush.borets.module2.factory.AnimalFactory;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import static ru.javarush.borets.module2.Constants.NUMBER_OF_PARENTS;
import static ru.javarush.borets.module2.Main.log;
import static ru.javarush.borets.module2.factory.MaxQuantity.maxQuantity;
import static ru.javarush.borets.module2.field.Field.gameField;
import static ru.javarush.borets.module2.lifeCycle.LiveDay.report;

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


