package ru.javarush.borets.module2.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import static ru.javarush.borets.module2.field.Field.gameField;

@Getter
@EqualsAndHashCode(callSuper = false)
public class Caterpillar extends Animal implements Herbivores {

    public Caterpillar(){super(0.01,0,0,true,"Caterpillar");}

    @Override
    public String toString() {
        return getName();
    }


    public void caterpillarEat(int index, int row, int column) {
        for (int i = index + 1; i < gameField[row][column].size(); i++) {
            if (gameField[row][column].get(i) instanceof Plant) {
                Plant temp = (Plant) gameField[row][column].get(i);
                gameField[row][column].remove(i);
                break;
            }
        }
    }
}
