package ru.javarush.borets.module2.lifeCycle;

import ru.javarush.borets.module2.Entities;
import ru.javarush.borets.module2.entity.Activity;
import ru.javarush.borets.module2.entity.Alive;
import ru.javarush.borets.module2.entity.Animal;
import ru.javarush.borets.module2.entity.Caterpillar;
import ru.javarush.borets.module2.entity.Herbivores;
import ru.javarush.borets.module2.entity.Predator;
import ru.javarush.borets.module2.factory.AnimalFactory;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import static ru.javarush.borets.module2.Constants.NUMBER_OF_PARENTS;
import static ru.javarush.borets.module2.Main.log;
import static ru.javarush.borets.module2.factory.MaxQuantity.maxQuantity;
import static ru.javarush.borets.module2.field.Field.gameField;
import static ru.javarush.borets.module2.lifeCycle.LiveDay.report;

public interface Viable {

    //alternative variants of methods eat and reproduce without Threads

    static void reproduce() {
        AtomicInteger countOfReproduce = new AtomicInteger(0);
        for (int row = 1; row < gameField.length - 1; row++) {
            for (int column = 1; column < gameField[0].length - 1; column++) {
                ArrayList<String> listForReproduce = new ArrayList<>();

                for (int i = 0; i < gameField[row][column].size(); i++) {
                    if (gameField[row][column].get(i) instanceof Animal) {
                        listForReproduce.add(gameField[row][column].get(i).getClass().getSimpleName());
                        log.info(gameField[row][column].get(i).getClass().getSimpleName() + " is reproduced");
                    }
                }
                AnimalFactory factory = new AnimalFactory();
                Map<String, Long> result = listForReproduce.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

                for (Map.Entry<String, Long> item : result.entrySet()) {
                    int countPossibleChild = (int) (item.getValue() / NUMBER_OF_PARENTS);
                    int differenceBetweenMaxAndPossible = (int) (maxQuantity.get(Entities.valueOf(item.getKey().toUpperCase())) - item.getValue());

                    for (int i = 0; i < Math.random() * countPossibleChild && i < differenceBetweenMaxAndPossible; i++) {
                        gameField[row][column].add(factory.getAlive(Entities.valueOf(item.getKey().toUpperCase())));
                        countOfReproduce.getAndIncrement();
                    }
                }
            }
        }
        report.append(countOfReproduce).append(" animals were born " + "\n");
    }

    static void eat() throws FileNotFoundException {
        for (int row = 1; row < gameField.length - 1; row++) {
            for (int column = 1; column < gameField[0].length - 1; column++) {
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
        }
    }

    static void moveToAnotherLocation() {
        //Direction direction = randomDirectionMove();
        AtomicInteger count = new AtomicInteger(0);
        for (int row = 1; row < gameField.length - 1; row++) {
            for (int column = 1; column < gameField[0].length - 1; column++) {
                ArrayList<Alive> tempArray = gameField[row][column];

                for (int i = 0; i < tempArray.size(); i++) {
                    if (tempArray.get(i) instanceof Activity) {
                        log.info("  Animal moved " + tempArray.get(i));
                        ((Activity) tempArray.get(i)).move(row, column, tempArray.get(i), randomDirectionMove());
                        count.getAndIncrement();
                    }
                }
            }
        }
        report.append(count).append(" animals moved " + "\n");
    }

    private static Direction randomDirectionMove() {
        Random random = new Random();
        int direction = random.nextInt(4);
        return switch (direction) {
            case 0 -> Direction.LEFT;
            case 1 -> Direction.DOWN;
            case 2 -> Direction.UP;
            default -> Direction.RIGHT;
        };
    }
}
