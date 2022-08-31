package ru.javarush.borets.module2.lifeCycle;

import ru.javarush.borets.module2.entity.Alive;
import ru.javarush.borets.module2.statistic.EntityCounter;
import ru.javarush.borets.module2.statistic.StatisticReport;
import ru.javarush.borets.module2.threads.ThreadEating;
import ru.javarush.borets.module2.threads.Threadreproduce;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static ru.javarush.borets.module2.Main.log;
import static ru.javarush.borets.module2.factory.AnimalCreator.listOfAnimals;

public class LiveDay implements Viable, ListUpdate {

    public static ArrayList<Alive> dayListOfAnimals = new ArrayList<>();
    public static StringBuilder report = new StringBuilder();

    public static ArrayList<Alive> liveDay() throws FileNotFoundException, InterruptedException {
        StatisticReport dayReport = new StatisticReport();
        report.setLength(0);

        Viable.moveToAnotherLocation();

        //Viable.eat();
        ExecutorService pool = Executors.newFixedThreadPool(20);
        ThreadEating eating = new ThreadEating();

        pool.submit(eating);
        Thread.sleep(1000);

        ListUpdate.updateListOfAnimals(dayListOfAnimals);
        report.append("Some animals were eaten. Left to exist in the population:  ").append(dayListOfAnimals.size()).append("\n");

        // Viable.reproduce();
        Threadreproduce reproducing = new Threadreproduce();
        pool.submit(reproducing);
        Thread.sleep(1000);
        pool.shutdown();
        final boolean isFinished = pool.awaitTermination(1, TimeUnit.MINUTES);
        log.debug("Executorservise is finished?" + isFinished);

        ListUpdate.updateListOfAnimals(dayListOfAnimals);
        report.append(dayListOfAnimals.size()).append(" entities are after reproducing." + "\n");
        report.append("Condition at the end of the day: ");
        report.append(EntityCounter.getStatistic(dayListOfAnimals)).append("\n");
        dayReport.printInfoAboutLifeDay(report);

        return dayListOfAnimals;
    }

    public static StringBuilder getWelcomeReport() {
        StringBuilder welcomeReport = new StringBuilder();
        welcomeReport.append(listOfAnimals.size()).append(" entities started. They are:").append("\n")
                .append(EntityCounter.getStatistic((ArrayList<? extends Alive>) listOfAnimals))
                .append("\n");

        return welcomeReport;
    }

}




