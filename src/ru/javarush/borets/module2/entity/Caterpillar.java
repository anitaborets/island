package ru.javarush.borets.module2.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import static ru.javarush.borets.module2.field.Field.gameField;

@Getter
@EqualsAndHashCode(callSuper = false)
public class Caterpillar extends Alive implements Liveable {
    private final double weight = 0.01;
    private final String view = "Caterpillar";
    private final boolean eaten = true;

    public Caterpillar() {
    }

    @Override
    public Alive reproduce() {
        return new Caterpillar();
    }

    @Override
    public String toString() {
        return view;
    }


    public void caterpillarEat(int index, int row, int column) {
        for (int i = index+1; i < gameField[row][column].size(); i++) {
            if (gameField[row][column].get(i) instanceof Plant) {
                Plant temp = (Plant) gameField[row][column].get(i);
                gameField[row][column].remove(i);
                break;
            }
        }
    }
}
