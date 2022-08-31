package ru.javarush.borets.module2.threads;

import ru.javarush.borets.module2.Entities;
import ru.javarush.borets.module2.entity.Animal;
import ru.javarush.borets.module2.factory.AnimalFactory;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

import static ru.javarush.borets.module2.Constants.NUMBER_OF_PARENTS;
import static ru.javarush.borets.module2.Main.log;
import static ru.javarush.borets.module2.factory.MaxQuantity.maxQuantity;
import static ru.javarush.borets.module2.field.Field.gameField;
import static ru.javarush.borets.module2.lifeCycle.LiveDay.report;

public class Threadreproduce implements Runnable {
    AtomicInteger countOfReproduce = new AtomicInteger(0);

    public void reproduceWithThread(int row, int column) throws Exception {
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

    @Override
    public void run() {
        Thread loggerDaemon = new Thread(new LoggerDaemon());
        loggerDaemon.setDaemon(true);
        for (int row = 1; row < gameField.length - 1; row++) {
            for (int column = 1; column < gameField[0].length - 1; column++) {
                try {
                    reproduceWithThread(row, column);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                loggerDaemon.start();
            }
        }
        report.append(countOfReproduce).append(" animals were born " + "\n");
    }
}
