package ru.javarush.borets.module2.entity;

import ru.javarush.borets.module2.lifeCycle.Direction;

import java.util.ArrayList;

import static ru.javarush.borets.module2.Constants.FIRST_ELEMENT;
import static ru.javarush.borets.module2.field.Field.gameField;
import static ru.javarush.borets.module2.lifeCycle.Direction.DOWN;

public interface Activity {

    default void move(int x, int y, Alive alive, Direction direction) {

        if ((alive instanceof Predator) || (alive instanceof Herbivores)) {
            Animal animal = (Animal) alive;
            int speed = animal.getSpeed();

            switch (direction) {
                case RIGHT -> {
                    if ((y + speed) < gameField[0].length - 1) {
                        ArrayList<Alive> controlX = gameField[x][y + speed];
                        if (!(controlX.get(FIRST_ELEMENT) instanceof Water)) {
                            Alive temp = gameField[x][y].get(FIRST_ELEMENT);
                            gameField[x][y].remove(alive);
                            gameField[x][y + speed].add(temp);
                        }
                    }
                }
                case DOWN -> {
                    if ((x + speed) < gameField.length - 1) {
                        ArrayList<Alive> controlY = gameField[x + speed][y];
                        if (!(controlY.get(FIRST_ELEMENT) instanceof Water)) {
                            gameField[x + speed][y].add(FIRST_ELEMENT, alive);
                            gameField[x][y].remove(alive);
                        }
                    }
                }
                case LEFT -> {
                    if ((y - speed) > 0) {
                        ArrayList<Alive> controlX = gameField[x][y - speed];
                        if (!(controlX.get(FIRST_ELEMENT) instanceof Water)) {
                            Alive temp = gameField[x][y].get(FIRST_ELEMENT);
                            gameField[x][y].remove(alive);
                            gameField[x][y - speed].add(temp);
                        }
                    }

                }
                case UP -> {
                    if ((x - speed) > 0) {
                        ArrayList<Alive> controlY = gameField[x - speed][y];
                        if (!(controlY.get(FIRST_ELEMENT) instanceof Water)) {
                            gameField[x - speed][y].add(FIRST_ELEMENT, alive);
                            gameField[x][y].remove(alive);
                        }
                    }
                }
            }
        }
    }
}



