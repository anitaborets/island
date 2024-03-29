package ru.javarush.borets.module2.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fox extends Animal implements Predator {
    double foodCount = START_FOOD_COUNT;

    public Fox() {
        super(8, 2, 2, true, "Fox");
           }

    @Override
    public String toString() {
        return getName();
    }
}
