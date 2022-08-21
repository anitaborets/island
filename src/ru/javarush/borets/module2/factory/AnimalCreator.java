package ru.javarush.borets.module2.factory;

import ru.javarush.borets.module2.entity.Alive;
import ru.javarush.borets.module2.entity.Animal;
import ru.javarush.borets.module2.entity.Bear;
import ru.javarush.borets.module2.entity.Boa;
import ru.javarush.borets.module2.entity.Buffalo;
import ru.javarush.borets.module2.entity.Caterpillar;
import ru.javarush.borets.module2.entity.Deer;
import ru.javarush.borets.module2.entity.Duck;
import ru.javarush.borets.module2.entity.Eagle;
import ru.javarush.borets.module2.entity.Fox;
import ru.javarush.borets.module2.entity.Goat;
import ru.javarush.borets.module2.entity.Horse;
import ru.javarush.borets.module2.entity.Mouse;
import ru.javarush.borets.module2.entity.Pig;
import ru.javarush.borets.module2.entity.Plant;
import ru.javarush.borets.module2.entity.Rabbit;
import ru.javarush.borets.module2.entity.Sheep;
import ru.javarush.borets.module2.entity.Wolf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static ru.javarush.borets.module2.Entities.*;
import static ru.javarush.borets.module2.factory.MaxQuantity.maxQuantity;

public class AnimalCreator {
    public static final List<Class<? extends Alive>> allAlives = Collections.unmodifiableList(Arrays.asList(Bear.class, Boa.class, Buffalo.class,
            Caterpillar.class, Deer.class, Animal.class, Alive.class));

    public static List<? super Alive> listOfAnimals = new ArrayList<>();

    public static List<? super Alive> getlistOfAnimals() {
        List<? super Alive> listOfAnimalsForSpot = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < random.nextInt(maxQuantity.get(BEAR)); i++) {
            Bear entity = new Bear();
            listOfAnimals.add(entity);
            listOfAnimalsForSpot.add(entity);
        }
        for (int i = 0; i < random.nextInt(maxQuantity.get(BOA)); i++) {
            Boa entity = new Boa();
            listOfAnimals.add(entity);
            listOfAnimalsForSpot.add(entity);
        }
        for (int i = 0; i < random.nextInt(maxQuantity.get(BUFFALO)); i++) {
            Buffalo entity = new Buffalo();
            listOfAnimals.add(entity);
            listOfAnimalsForSpot.add(entity);
        }
        for (int i = 0; i < random.nextInt(maxQuantity.get(CATERPILLAR)); i++) {
            Caterpillar entity = new Caterpillar();
            listOfAnimals.add(entity);
            listOfAnimalsForSpot.add(entity);
        }

        for (int i = 0; i < random.nextInt(maxQuantity.get(DEER)); i++) {
            Deer entity = new Deer();
            listOfAnimals.add(entity);
            listOfAnimalsForSpot.add(entity);
        }
        for (int i = 0; i < random.nextInt(maxQuantity.get(DUCK)); i++) {
            Duck entity = new Duck();
            listOfAnimals.add(entity);
            listOfAnimalsForSpot.add(entity);
        }
        for (int i = 0; i < random.nextInt(maxQuantity.get(EAGLE)); i++) {
            Eagle entity = new Eagle();
            listOfAnimals.add(entity);
            listOfAnimalsForSpot.add(entity);
        }
        for (int i = 0; i < random.nextInt(maxQuantity.get(FOX)); i++) {
            Fox entity = new Fox();
            listOfAnimals.add(entity);
            listOfAnimalsForSpot.add(entity);
        }
        for (int i = 0; i < random.nextInt(maxQuantity.get(GOAT)); i++) {
            Goat entity = new Goat();
            listOfAnimals.add(entity);
            listOfAnimalsForSpot.add(entity);
        }
        for (int i = 0; i < random.nextInt(maxQuantity.get(HORSE)); i++) {
            Horse entity = new Horse();
            listOfAnimals.add(entity);
            listOfAnimalsForSpot.add(entity);
        }
        for (int i = 0; i < random.nextInt(maxQuantity.get(MOUSE)); i++) {
            Mouse entity = new Mouse();
            listOfAnimals.add(entity);
            listOfAnimalsForSpot.add(entity);
        }
        for (int i = 0; i < random.nextInt(maxQuantity.get(PIG)); i++) {
            Pig entity = new Pig();
            listOfAnimals.add(entity);
            listOfAnimalsForSpot.add(entity);
        }
        for (int i = 0; i < random.nextInt(maxQuantity.get(PLANT)); i++) {
            Plant entity = new Plant();
            listOfAnimals.add(entity);
            listOfAnimalsForSpot.add(entity);
        }
        for (int i = 0; i < random.nextInt(maxQuantity.get(RABBIT)); i++) {
            Rabbit entity = new Rabbit();
            listOfAnimals.add(entity);
            listOfAnimalsForSpot.add(entity);
        }
        for (int i = 0; i < random.nextInt(maxQuantity.get(SHEEP)); i++) {
            Sheep entity = new Sheep();
            listOfAnimals.add(entity);
            listOfAnimalsForSpot.add(entity);
        }
        for (int i = 0; i < random.nextInt(maxQuantity.get(WOLF)); i++) {
            Wolf entity = new Wolf();
            listOfAnimals.add(entity);
            listOfAnimalsForSpot.add(entity);
        }

        return listOfAnimalsForSpot;
    }

}
