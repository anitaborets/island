package ru.javarush.borets.module2.entity;

import static ru.javarush.borets.module2.field.Field.gameField;

public interface Flyable {
    public default void fly(int x, int y, Flyable flyable) {
        Animal animal = (Animal) flyable;
        int speed = animal.getSpeed();
        gameField[x][y].remove(flyable);
        gameField[1][y + speed].add((Alive) flyable);
    }
}
