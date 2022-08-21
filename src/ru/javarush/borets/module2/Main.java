package ru.javarush.borets.module2;

import ru.javarush.borets.module2.entity.Alive;
import ru.javarush.borets.module2.field.Field;
import ru.javarush.borets.module2.logger.Logger;
import ru.javarush.borets.module2.statistic.EntityCounter;

import java.util.ArrayList;

import static ru.javarush.borets.module2.factory.AnimalCreator.listOfAnimals;
import static ru.javarush.borets.module2.lifeCycle.LifeCycle.liveDay;

public class Main {
    private static final Logger log = Logger.getINSTANCE();

    public static void main(String[] args) {

        Field field = new Field();
        field.initialField();
        field.printField();

        EntityCounter.getStatistic((ArrayList<? extends Alive>) listOfAnimals);
        System.out.println(listOfAnimals.size() + " entities started");

        //System.out.println(gameField[1][1].size() + " before start ");
        liveDay();







        // AnimalFactory factory = new AnimalFactory();
        //Alive animal = AnimalFactory.getRandomAnimal(factory);
        // System.out.println(animal);

        //TODO all statistic
        //EntityCounter.getStatistic((ArrayList<? extends Alive>) listOfAnimals);

    }
}
