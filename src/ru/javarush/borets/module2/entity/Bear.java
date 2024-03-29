package ru.javarush.borets.module2.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static ru.javarush.borets.module2.field.Field.gameField;

@Getter
@EqualsAndHashCode(callSuper = false)
public class Bear extends Animal implements Predator {

    public Bear() {
        super(500, 2, 80, false, "Bear");
    }


    @Override
    public String toString() {
        return getName();
    }
}
