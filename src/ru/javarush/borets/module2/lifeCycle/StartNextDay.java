package ru.javarush.borets.module2.lifeCycle;

import ru.javarush.borets.module2.entity.Alive;
import ru.javarush.borets.module2.entity.Animal;
import ru.javarush.borets.module2.entity.Plant;
import ru.javarush.borets.module2.statistic.EntityCounter;
import ru.javarush.borets.module2.statistic.StatisticReport;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static ru.javarush.borets.module2.Constants.FOOD_CONSUMPTION;
import static ru.javarush.borets.module2.Entities.PLANT;
import static ru.javarush.borets.module2.Main.log;
import static ru.javarush.borets.module2.factory.MaxQuantity.maxQuantity;
import static ru.javarush.borets.module2.field.Field.gameField;

public class StartNextDay implements ListUpdate {

    public static StringBuilder reportStart = new StringBuilder();

    static ThreadLocalRandom random = ThreadLocalRandom.current();

    public static void startNextDay(ArrayList<Alive>[][] gameField) {

        StatisticReport reportStartDay = new StatisticReport();
        reportStart.setLength(0);

        diedStarvation();
        wantEatAgain();
        grownPlant();
        ArrayList<Alive> startDay = new ArrayList<>();
        ListUpdate.fillDayListOfAnimals(startDay);

        reportStart.append("Animals before start new day: ")
                .append(startDay.size())
                .append("\n")
                .append("They are: ")
                .append(EntityCounter.getStatistic(startDay));

        reportStartDay.printInfoAboutLifeDay(reportStart);
    }

    private static void diedStarvation() {

        int deadAnimals = 0;
        for (int row = 1; row < gameField.length - 1; row++) {
            for (int column = 1; column < gameField[0].length - 1; column++) {

                for (int i = 0; i < gameField[row][column].size(); i++) {
                    if (gameField[row][column].get(i) instanceof Animal) {
                        double foodCountAfterNight = ((Animal) gameField[row][column].get(i)).getFoodCount() / FOOD_CONSUMPTION;
                        ((Animal) gameField[row][column].get(i)).setAmountOfFood(foodCountAfterNight);

                        if (((Animal) gameField[row][column].get(i)).getFoodCount() == 0) {
                            log.info(gameField[row][column].get(i).getClass().getSimpleName() + " is died");
                            gameField[row][column].remove(i);
                            deadAnimals++;
                        }
                    }
                }
            }
        }
        reportStart.append("**************").append("\n").append("Start new day.").append("Some of the animals died.The population of the island has decreased by: ").append(deadAnimals).append("\n");
    }

    private static void grownPlant() {
        for (int row = 1; row < gameField.length - 1; row++) {
            for (int column = 1; column < gameField[0].length - 1; column++) {
                gameField[row][column].removeIf(e -> e instanceof Plant);
                for (int i = 0; i < random.nextInt(maxQuantity.get(PLANT)); i++) {
                    Plant plant = new Plant();
                    gameField[row][column].add(plant);
                }
            }
        }
        reportStart.append("Plant has grown...");
    }

    private static void wantEatAgain() {
        for (int row = 1; row < gameField.length - 1; row++) {
            for (int column = 1; column < gameField[0].length - 1; column++) {
                gameField[row][column].stream().filter(e -> e instanceof Animal).forEach(e -> ((Animal) e).isAte = false);
            }
        }
    }
}



