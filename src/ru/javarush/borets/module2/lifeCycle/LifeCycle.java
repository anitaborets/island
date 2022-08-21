package ru.javarush.borets.module2.lifeCycle;

import ru.javarush.borets.module2.statistic.EntityCounter;
import ru.javarush.borets.module2.entity.Activity;
import ru.javarush.borets.module2.entity.Alive;
import ru.javarush.borets.module2.entity.Animal;
import ru.javarush.borets.module2.entity.Herbivores;
import ru.javarush.borets.module2.entity.Predator;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static ru.javarush.borets.module2.field.Field.gameField;

public class LifeCycle {

    public static ArrayList<Alive> dayListOfAnimals = new ArrayList<>();

    public static void liveDay() {

        AtomicInteger count = new AtomicInteger(0);
        AtomicInteger countEaten = new AtomicInteger(0);

        for (int row = 1; row < gameField.length - 1; row++) {
            for (int column = 1; column < gameField[0].length - 1; column++) {
                ArrayList<Alive> tempArray = gameField[row][column];

                for (int i = 0; i < tempArray.size(); i++) {
                    if (tempArray.get(i) instanceof Animal) {
                        ((Activity) tempArray.get(i)).move(row, column, tempArray.get(i));
                        count.getAndIncrement();
                    }
                }
            }
        }
        System.out.println(count + " animals moved ");

        for (int row = 1; row < gameField.length - 1; row++) {
            for (int column = 1; column < gameField[0].length - 1; column++) {

                // System.out.println(row + " row " + column + " column " + gameField[row][column].size() + " before eat ");
                //EntityCounter.getStatistic(gameField[row][column]);

                for (int i = 0; i < gameField[row][column].size(); i++) {
                    if ((gameField[row][column].get(i) instanceof Animal animal) && (!animal.isAte)) {
                        if (animal instanceof Herbivores herbivores) {
                            herbivores.eatPlant(animal, i, row, column);
                        } else if (animal instanceof Predator predator) {
                            predator.eat(animal, i, row, column);
                        }
                    }

                    // else if (gameField[row][column].get(i) instanceof Caterpillar caterpillar) {
                    //caterpillar.caterpillarEat(i, row, column);
                    //}
                }
                //EntityCounter.getStatistic(gameField[row][column]);
                // System.out.println(row + " row " + column + " column " + gameField[row][column].size() + " after eat");
            }
        }


        for (int row = 1; row < gameField.length - 1; row++) {
            for (int column = 1; column < gameField[0].length - 1; column++) {
                dayListOfAnimals.addAll(gameField[row][column]);
            }
        }
        EntityCounter.getStatistic(dayListOfAnimals);
        System.out.println(dayListOfAnimals.size() + " entities are after eating");


        for (int row = 1; row < gameField.length - 1; row++) {
            for (int column = 1; column < gameField[0].length - 1; column++) {
                dayListOfAnimals.clear();


                for (int i = 0; i < gameField[row][column].size(); i++) {
                    if (gameField[row][column].get(i) instanceof Animal animal) {
                        for (int j = i + 1; i < gameField[row][column].size(); i++) {
                            if (gameField[row][column].get(j).getClass() == animal.getClass()) {
                                gameField[row][column].add(animal.reproduce());
                                System.out.println(animal.getName() + " reproduce!!!");
                                break;
                            }
                        }
                    }
                }
            }
        }

        for (int row = 1; row < gameField.length - 1; row++) {
            for (int column = 1; column < gameField[0].length - 1; column++) {
                dayListOfAnimals.addAll(gameField[row][column]);
            }
        }
        EntityCounter.getStatistic(dayListOfAnimals);
        System.out.println(dayListOfAnimals.size() + " entities are after reproducing");
    }
}



