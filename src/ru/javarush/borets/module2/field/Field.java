package ru.javarush.borets.module2.field;

import lombok.Getter;
import lombok.Setter;
import ru.javarush.borets.module2.entity.Alive;
import ru.javarush.borets.module2.entity.Water;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ru.javarush.borets.module2.Constants.*;
import static ru.javarush.borets.module2.factory.AnimalCreator.getlistOfAnimals;
import static ru.javarush.borets.module2.factory.MaxQuantity.putMaxQuantity;


@Getter
@Setter
public class Field {
    private int sizeX;
    private int sizeY;

    public static ArrayList<Alive>[][] gameField;

    public Field(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        gameField = new ArrayList[sizeX + WATER_AROUND_FIELD][sizeY + WATER_AROUND_FIELD];
    }

    public void initialField() {

        ArrayList<Alive> water = new ArrayList<>();
        water.add(new Water());
        for (int i = 0; i < sizeY + WATER_AROUND_FIELD; i++) {
            gameField[0][i] = water;
        }
        for (int i = 0; i < sizeX + WATER_AROUND_FIELD; i++) {
            gameField[i][0] = water;
        }
        for (int i = 0; i < sizeY + WATER_AROUND_FIELD; i++) {
            gameField[sizeX + 1][i] = water;
        }
        for (int i = 0; i < sizeX + WATER_AROUND_FIELD; i++) {
            gameField[i][sizeY + 1] = water;
        }

        putMaxQuantity();
        for (int i = 1; i < sizeX + 1; i++) {
            for (int j = 1; j < sizeY + 1; j++) {
                List<? super Alive> listOfAnimalsForEachSpot = getlistOfAnimals();
                Collections.shuffle(listOfAnimalsForEachSpot);
                gameField[i][j] = (ArrayList<Alive>) listOfAnimalsForEachSpot;
            }
        }
    }

    public void printField() {
        for (ArrayList<Alive>[] arrayLists : gameField) {
            for (int j = 0; j < gameField[0].length; j++) {
                if (!(arrayLists[j].isEmpty()))
                    System.out.print(arrayLists[j].get(FIRST_ELEMENT) + "\t");
                else System.out.print("[ ]" + "\t");
            }
            System.out.print("\n");
        }
    }
}

