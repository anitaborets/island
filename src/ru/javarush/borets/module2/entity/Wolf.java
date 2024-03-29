package ru.javarush.borets.module2.entity;

import lombok.Getter;

@Getter
public class Wolf extends Animal implements Predator {
    double foodCount = START_FOOD_COUNT;

    public Wolf() {
        super(50, 3, 8, false, "Wolf");
    }

    @Override
    public String toString() {
        return getName();
    }
}
