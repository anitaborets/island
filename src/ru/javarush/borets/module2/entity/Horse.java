package ru.javarush.borets.module2.entity;

import lombok.Getter;

@Getter
public class Horse extends Animal implements Herbivores {
    double foodCount = START_FOOD_COUNT;

    public Horse() {
        super(400, 4, 60, true, "Horse");
    }

    @Override
    public String toString() {
        return getName();
    }
}
