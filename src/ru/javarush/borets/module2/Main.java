package ru.javarush.borets.module2;

import ru.javarush.borets.module2.entity.Alive;
import ru.javarush.borets.module2.field.Field;
import ru.javarush.borets.module2.lifeCycle.LiveDay;
import ru.javarush.borets.module2.loading_from_external_sources.Configuration;
import ru.javarush.borets.module2.logger.Logger;
import ru.javarush.borets.module2.statistic.EntityCounter;
import ru.javarush.borets.module2.statistic.StatisticReport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static ru.javarush.borets.module2.Constants.*;
import static ru.javarush.borets.module2.factory.AnimalCreator.listOfAnimals;
import static ru.javarush.borets.module2.field.Field.gameField;
import static ru.javarush.borets.module2.lifeCycle.LiveDay.liveDay;
import static ru.javarush.borets.module2.lifeCycle.StartNextDay.startNextDay;
import static ru.javarush.borets.module2.loading_from_external_sources.Configuration.appConfiguration;


public class Main {
    public static final Logger log = Logger.getINSTANCE();

    public static StringBuilder finalReport = new StringBuilder();
    static int daysOfLife = 1;
    public static ArrayList<Alive> finalListOfAnimals = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        log.info("Application started");
        StatisticReport report = new StatisticReport();
        Configuration.getProperties();
        Map<String, Integer> configurationFromUser;

        Dialog dialog = new Dialog();

        configurationFromUser = dialog.startDialog();

        int sizeX = configurationFromUser.get(WIDTH) == 0 ? appConfiguration.get("sizeX") : configurationFromUser.get(WIDTH);
        int sizeY = configurationFromUser.get(HEIGHT) == 0 ? appConfiguration.get("sizeY") : configurationFromUser.get(HEIGHT);

        Field field = new Field(sizeX, sizeY);
        field.initialField();
        field.printField();
        log.info("Island was created, size: " + sizeX + ", " + sizeY);

        int dayOfLife = configurationFromUser.get(HEIGHT) == 0 ? appConfiguration.get("DAY_OF_LIFE") : configurationFromUser.get(DAY_OF_LIFE);
        log.info("Count of iterations is " + dayOfLife);

        report.startReport((ArrayList<Alive>) listOfAnimals);
        report.printInfoAboutLifeDay(LiveDay.getWelcomeReport());

        liveDay();
        log.info("First day is finished");

        for (int i = 1; i < dayOfLife; i++) {
            System.out.println("Day " + i + " is finished");
            startNextDay(gameField);
            finalListOfAnimals = liveDay();
            daysOfLife++;
            log.info(daysOfLife + " day is finished");
        }

        HashMap<Class<?>, Integer> finalMap = EntityCounter.getStatisticForCalculation(finalListOfAnimals);
        report.finishReport(finalMap, finalListOfAnimals);
        report.whoIsDied(finalMap);

        dialog.finishDialog();
    }
}


