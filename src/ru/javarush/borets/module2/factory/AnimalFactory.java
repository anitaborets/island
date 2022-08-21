package ru.javarush.borets.module2.factory;

import ru.javarush.borets.module2.Entities;
import ru.javarush.borets.module2.entity.Alive;
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

import java.util.Random;

//class is not used temporary
public class AnimalFactory {

    public Alive getAlive(Entities type) {

        switch (type) {
            case BEAR -> {
                return new Bear();
            }
            case BOA -> {
                return new Boa();
            }
            case BUFFALO -> {
                return new Buffalo();
            }
            case CATERPILLAR -> {
                return new Caterpillar();
            }
            case DEER -> {
                return new Deer();
            }
            case DUCK -> {
                return new Duck();
            }
            case EAGLE -> {
                return new Eagle();
            }
            case FOX -> {
                return new Fox();
            }
            case GOAT -> {
                return new Goat();
            }
            case HORSE -> {
                return new Horse();
            }
            case MOUSE -> {
                return new Mouse();
            }
            case PIG -> {
                return new Pig();
            }
            case PLANT -> {
                return new Plant();
            }
            case RABBIT -> {
                return new Rabbit();
            }
            case SHEEP -> {
                return new Sheep();
            }
            case WOLF -> {
                return new Wolf();
            }

            default -> throw new IllegalArgumentException("Wrong entity" + type);
        }
    }

    public static Alive getRandomAnimal(AnimalFactory factory) {
        Random random = new Random();
        Entities type = Entities.values()[random.nextInt(Entities.values().length)];
        return factory.getAlive(type);
    }
}








