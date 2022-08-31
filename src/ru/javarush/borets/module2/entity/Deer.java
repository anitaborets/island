package ru.javarush.borets.module2.entity;

import lombok.Getter;

@Getter
public class Deer extends Animal implements Herbivores {
    double foodCount = START_FOOD_COUNT;

    public Deer() {
        super(300, 4, 50, true, "Deer");
    }

    @Override
    public String toString() {
        return getName();
    }

}
